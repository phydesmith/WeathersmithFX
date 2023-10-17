package com.javasmithy;

import io.javasmithy.geo.GeoData;
import io.javasmithy.util.FXUtil;
import io.javasmithy.weather.BoundForecastPeriodProperties;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Builder;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import org.controlsfx.control.textfield.CustomTextField;
import org.kordamp.ikonli.antdesignicons.AntDesignIconsOutlined;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign2.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Consumer;

public class AppViewBuilder implements Builder<Region> {
    private final GeoModel geoModel;
    private final Consumer<Runnable> geoGetter;
    private final  WeatherModel weatherModel;
    private final BorderPane root;
    public AppViewBuilder (GeoModel geoModel, Consumer<Runnable> geoGetter, WeatherModel weatherModel) {
        this.geoModel = geoModel;
        this.geoGetter = geoGetter;
        this.weatherModel = weatherModel;
        this.root = new BorderPane();
    }

    @Override
    public Region build(){
        this.root.getStylesheets().add(getClass().getResource("css/root.css").toExternalForm());
        this.root.setTop(createMenuBar());

        Node node = weatherBox();
        BorderPane.setMargin(node, new Insets(8));
        this.root.setCenter(node);

        this.root.getCenter().setVisible(false);

        return this.root;
    }

    private Node createMenuBar(){
        Menu burgerMenu = createMenu("", List.of(
                createMenuItem("Exit", e -> {
                    exitApplication();
                })
        ), FontIcon.of(MaterialDesignM.MENU));


        CustomTextField searchTextField = new CustomTextField();
        searchTextField.textProperty().bindBidirectional(geoModel.postalCodeProperty());
        searchTextField.setPromptText("Search Zip Code");
        searchTextField.setRight(
                FXUtil.build(new Button(), b -> {
                    b.setGraphic(FontIcon.of(MaterialDesignM.MAGNIFY));
                    b.setDefaultButton(true);
                    b.setOnAction(
                            evt -> {
                                geoGetter.accept( () -> root.getCenter().setVisible(true) );
                            }
                    );}
                )
        );
        Pane searchPane = new Pane(searchTextField);
        searchPane.getStyleClass().add("search-pane-with-border");

        Button settingsButton = new Button();
        settingsButton.setGraphic(FontIcon.of(MaterialDesignC.COG_OUTLINE));

        Button reloadButton = new Button();
        reloadButton.setGraphic(FontIcon.of(MaterialDesignR.REFRESH));
        reloadButton.setOnAction(e -> {
            File f = new File("src/main/resources/io/javasmithy/css/root.css");
            root.getStylesheets().clear();
            root.getStylesheets().add(
                    "file:///" + f.getAbsolutePath().replace("\\", "/")
            );
        });

        return new ToolBar(
                new MenuBar(burgerMenu),
                createSpacer(Priority.SOMETIMES),
                searchPane,
                createSpacer(Priority.SOMETIMES),
                reloadButton,
                settingsButton
        );
    }
    private Menu createMenu(String text, List<MenuItem> menuItemList){
        Menu menu = new Menu(text);
        menu.getItems().setAll(menuItemList);
        return menu;
    }
    private Menu createMenu(String text, List<MenuItem> menuItemList, FontIcon fontIcon){
        Menu menu = createMenu(text, menuItemList);
        menu.setGraphic(fontIcon);
        return menu;
    }
    private Menu createMenu(String text, FontIcon fontIcon, EventHandler<ActionEvent> e){
        Menu menu = createMenu(text, List.of());
        menu.setGraphic(fontIcon);
        menu.setOnAction(e);
        return menu;
    }
    private MenuItem createMenuItem(String text, EventHandler<ActionEvent> e){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(e);
        return menuItem;
    }
    private void exitApplication(){
        Platform.exit();
        System.exit(0);
    }
    private Node createSpacer(Priority priority){
        Pane pane = new Pane();
        HBox.setHgrow(
                pane,
                priority
        );
        return pane;
    }
    private Button createButton(String text, Optional<FontIcon> fontIcon, boolean isDefault, EventHandler<ActionEvent> e){
        Button button = new Button();
        button.setText(text);
        fontIcon.ifPresent(button::setGraphic);

        button.setDefaultButton(isDefault);
        button.setOnAction(e);
        return button;
    }

    private Node weatherBox(){
        BoundForecastPeriodProperties props = this.weatherModel.getBoundForecastPeriodByKey("forecast-1");

        Label forecast = new Label();
        forecast.getStyleClass().add("body");
        forecast.textProperty().bindBidirectional(
                props.shortForecastProperty()
        );

        Label name = new Label();
        name.getStyleClass().add("small");
        name.textProperty().bindBidirectional(
                props.nameProperty()
        );

        Label temperature = new Label();
        temperature.getStyleClass().add("header");
        temperature.textProperty().bindBidirectional(
                props.temperatureProperty(), new NumberStringConverter()
        );
        temperature.setGraphic(FontIcon.of(MaterialDesignT.TEMPERATURE_FAHRENHEIT));
        temperature.setContentDisplay(ContentDisplay.RIGHT);

        Label location = new Label();
        location.textProperty().bind(
                Bindings.concat(this.geoModel.placeNameProperty(), ", ", this.geoModel.stateCodeProperty())
        );

        ImageView imageView = new ImageView();



        VBox vBox = new VBox(name, temperature, forecast, location);
        vBox.getStyleClass().add("center-vbox");
        return vBox;
    }

    public void setDisplayVisible(){
        this.root.getCenter().setVisible(true);
    }
}
