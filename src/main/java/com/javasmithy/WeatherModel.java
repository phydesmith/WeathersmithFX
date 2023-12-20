package com.javasmithy;

import com.javasmithy.weather.Forecast;
import com.javasmithy.weather.ForecastPeriod;
import com.javasmithy.weather.BoundForecastPeriodProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherModel {

    private Forecast forecast;
    private Map<String, BoundForecastPeriodProperties> forecastMap;

    public WeatherModel(){
        this.forecastMap = new HashMap<>();
        initializeForecastMap();
    }

    private void initializeForecastMap(){
        for(int i = 1; i < 15; i++){
            String key = "forecast-"+i;
            this.forecastMap.put(key, new BoundForecastPeriodProperties());
            System.out.println("forecastmap initialized");
        }
    }

    private void updateForecastMap(){
        List<ForecastPeriod> forecastPeriods = this.forecast.getForecastProperties().getPeriods();
        for (int i = 0; i < forecastPeriods.size(); i++){
            ForecastPeriod forecastPeriod = forecastPeriods.get(i);
            String key = "forecast-" + forecastPeriod.getNumber();
            this.forecastMap.get(key).updateProperties(forecastPeriod);
        }
    }

    public BoundForecastPeriodProperties getBoundForecastPeriodByKey(String key){
        System.out.println(key);
        System.out.println(this.forecastMap.get(key).toString());
        return this.forecastMap.get(key);
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public void updateForecast(Forecast forecast){
        setForecast(forecast);
        updateForecastMap();
    }

    public Forecast getForecast(){
        return this.forecast;
    }

}
