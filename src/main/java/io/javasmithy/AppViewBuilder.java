package io.javasmithy;

import io.javasmithy.weather.BoundForecastPeriodProperties;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Builder;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.weathericons.WeatherIcons;
import org.kordamp.ikonli.weathericons.WeatherIconsIkonProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class AppViewBuilder implements Builder<Region> {
    private final GeoModel geoModel;
    private final Runnable geoGetter;
    private final  WeatherModel weatherModel;
    public AppViewBuilder (GeoModel geoModel, Runnable geoGetter, WeatherModel weatherModel) {
        this.geoModel = geoModel;
        this.geoGetter = geoGetter;
        this.weatherModel = weatherModel;
    }

    @Override
    public Region build(){
        BorderPane root = new BorderPane();
        root.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

        VBox centerVBox = new VBox(5);
        centerVBox.getChildren().addAll(createTop());

        Node center = createCenter();

        root.setTop(centerVBox);
        root.setCenter(center);
        root.setMargin(centerVBox, new Insets(10,10,10,10));
        root.setMargin(center, new Insets(20, 20, 20, 20));
        root.setAlignment(centerVBox, Pos.CENTER);
        return root;
    }

    private Node createTop(){
        VBox vBox = new VBox(5);
        HBox center = new HBox(5);
        center.getChildren().addAll(
                labeledTextField("Postal Code:", geoModel.postalCodeProperty(), "body-label"),
                goButton(),
                styledLabel("CURRENT FORECAST", "header-label")
        );
        center.setAlignment(Pos.CENTER);
        HBox subCenter = new HBox(5);
        subCenter.getChildren().addAll(
                boundStringStyledLabel(geoModel.placeNameProperty(), "bold-sub-header")
        );
        subCenter.setAlignment(Pos.BOTTOM_CENTER);
        vBox.getChildren().addAll(center, subCenter);
        return vBox;
    }

    private Node labeledTextField(String labelContents, StringProperty boundProperty, String styleClass){
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(styledLabel(labelContents, styleClass), boundTextField(boundProperty));
        return hbox;
    }
    private Node boundTextField(StringProperty boundProperty){
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(boundProperty);
        return textField;
    }
    private Node styledLabel(String labelText, String styleClass){
        Label label = new Label(labelText);
        label.getStyleClass().add(styleClass);
        label.setWrapText(true);
        return label;
    }

    private Node goButton(){
        Button button = styledButton("Go", "body-label");
        button.setOnAction(evt -> geoGetter.run());
        Tooltip tooltip = new Tooltip("Local Forecast by \"City, St\" or ZIP code");
        Tooltip.install(button, tooltip);
        return button;
    }
    private Button styledButton(String buttonText, String styleClass){
        Button button = new Button(buttonText);
        button.getStyleClass().add(styleClass);
        return button;
    }

    private Node createCenter(){
        ScrollPane scrollPane = new ScrollPane();
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(getAllForecastNodes());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setContent(hBox);
        return scrollPane;
    }

    private List<Node> getAllForecastNodes(){
        List<Node> nodes = new ArrayList<>();
        int size = 14;
        for (int i = 0; i < size; i++){
            ImageView imageView = new ImageView();
            VBox vBox = new VBox(5);
            Text text = new Text();
            text.setWrappingWidth(100);
            try {
                BoundForecastPeriodProperties boundForecastPeriodProperties = weatherModel.getBoundForecastPeriodByKey("forecast-"+i);
                text.textProperty().bindBidirectional(
                        boundForecastPeriodProperties.longForecastProperty()
                );
                Image image = new Image(boundForecastPeriodProperties.getIcon());
                imageView.setImage(image);
                vBox.getChildren().addAll(imageView, boundStringStyledLabel(boundForecastPeriodProperties.nameProperty(), "bold-sub-header"), text);
            } catch (NullPointerException | IllegalArgumentException e){
                System.out.println("Exception: Caught Null from forecast properties.");
            }
            nodes.add(vBox);
        }
        return nodes;
    }

    private Node boundStringStyledLabel(StringProperty stringProperty, String styleClass){
        Node styledLabel = styledLabel("", styleClass);
        ((Label)styledLabel).textProperty().bindBidirectional(stringProperty);
        return  styledLabel;
    }
    private Node horizontalLabelWithProp(String labelText, StringProperty stringProperty, String styleClass){
        HBox hBox = new HBox(5);
        Label staticLabel = new Label(labelText);
        Node propertyLabel = boundStringStyledLabel(stringProperty, styleClass);
        hBox.getChildren().addAll(staticLabel, propertyLabel);
        return hBox;
    }
    private Node boundImageView(SimpleObjectProperty<Image> imageObjectProperty){
        ImageView imageView = new ImageView();
        imageView.imageProperty().bindBidirectional(imageObjectProperty);
        return imageView;
    }


}
