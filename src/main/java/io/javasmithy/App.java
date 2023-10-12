package io.javasmithy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new AppController().getView()));
        stage.setTitle("WeathersmithFX");
        stage.getIcons().add(new Image(getClass().getResource("icons/weathersmith-sigil.png").toExternalForm()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}