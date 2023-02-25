package io.javasmithy;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.util.Builder;

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
        root.getStylesheets().add(getClass().getResource("css/root.css").toExternalForm());

        root.setTop(createTop());

        root.setCenter(createCenter());
        BorderPane.setMargin(root.getCenter(), new Insets(8,8,0,0));

        root.setBottom(createBottom());

        return root;
    }

    private Node createTop(){
        HBox hBox = new HBox(128);
        hBox.getStylesheets().add(getClass().getResource("css/top.css").toExternalForm());
        hBox.setAlignment(Pos.BOTTOM_LEFT);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.getStyleClass().add("vbox");

        Label titleLabel = new Label("Weather Forecast");
        titleLabel.getStyleClass().add("title-label");

        Label textfieldLabel = new Label("Local forecast by ZIP code");
        TextField textField = new TextField("Enter location... ");
        textField.textProperty().bindBidirectional(geoModel.postalCodeProperty());
        textField.setPrefSize(128, 32);
        textField.setMaxSize(128, 32);

        Button button = new Button("Go");
        button.setPrefSize(128, 32);
        button.setOnAction(evt -> geoGetter.run());

        vBox.getChildren().addAll(
                textfieldLabel,
                new HBox(8,
                        textField,
                        button
                )
        );


        hBox.getChildren().addAll(
                vBox,
                titleLabel
        );

        return hBox;
    }

    private Node createCenter(){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStylesheets().add(getClass().getResource("css/center.css").toExternalForm());
        return scrollPane;
    }

    private Node createBottom(){
        VBox vBox = new VBox();
        vBox.getStylesheets().add(getClass().getResource("css/bottom.css").toExternalForm());
        Label label = new Label("... consequatur aut perferendis doloribus asperiores repellat");
        vBox.getChildren().add(label);
        return vBox;
    }

}
