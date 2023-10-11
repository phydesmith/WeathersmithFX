package io.javasmithy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new AppController().getView()));
        stage.setTitle("WeathersmithFX");
        stage.setWidth(1440);
        stage.setHeight(512);


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}