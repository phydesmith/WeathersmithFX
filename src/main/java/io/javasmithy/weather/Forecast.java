package io.javasmithy.weather;

import com.google.gson.annotations.SerializedName;

public class Forecast {
    @SerializedName("properties")
    private ForecastProperties forecastProperties;

    public Forecast(ForecastProperties forecastProperties) {
        this.forecastProperties = forecastProperties;
    }

    public ForecastProperties getForecastProperties() {
        return forecastProperties;
    }

    public void setForecastProperties(ForecastProperties forecastProperties) {
        this.forecastProperties = forecastProperties;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "forecastProperties=" + forecastProperties +
                '}';
    }
}
