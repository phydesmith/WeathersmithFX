package io.javasmithy;

import io.javasmithy.weather.Forecast;
import io.javasmithy.weather.ForecastPeriod;
import io.javasmithy.weather.BoundForecastPeriodProperties;

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
