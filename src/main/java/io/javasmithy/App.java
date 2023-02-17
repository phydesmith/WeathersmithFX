package io.javasmithy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new AppController().getView()));
        stage.setTitle("WeathersmithFX");
        stage.setWidth(768);
        stage.setHeight(320);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}