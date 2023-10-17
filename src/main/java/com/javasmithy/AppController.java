package com.javasmithy;

import io.javasmithy.geo.GeoData;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;


public class AppController {
    private Builder<Region> viewBuilder;
    private AppInteractor interactor;

    public AppController(){
        GeoModel geoModel = new GeoModel();
        WeatherModel weatherModel = new WeatherModel();
        this.interactor = new AppInteractor(geoModel, weatherModel);
        this.viewBuilder = new AppViewBuilder(geoModel, this::getGeoData, weatherModel);
    }

    private void getGeoData(Runnable postTaskGuiActions){
        Task<Void> getGeoDataTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                interactor.getGeoData();
                return null;
            }
        };
        getGeoDataTask.setOnSucceeded( evt -> {
            interactor.updatedWeatherModel();
            postTaskGuiActions.run();
        });
        Thread geoDataThread = new Thread(getGeoDataTask);
        geoDataThread.start();
    }

    public Region getView(){
        return viewBuilder.build();
    }

}
