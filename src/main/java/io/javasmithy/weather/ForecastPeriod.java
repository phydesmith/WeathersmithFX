package io.javasmithy.weather;

import com.google.gson.annotations.SerializedName;

public class ForecastPeriod {
    private int number;
    private String name;
    private String startTime;
    private String endTime;
    private boolean isDayTime;
    private int temperature;
    private String temperatureUnit;
    private String temperatureTrend;
    private String windSpeed;
    private String windDirection;
    private String icon;
    private String shortForecast;
    @SerializedName("detailedForecast")
    private String longForecast;

    public ForecastPeriod(int number, String name, String startTime, String endTime, boolean isDayTime, int temperature, String temperatureUnit, String temperatureTrend, String windSpeed, String windDirection, String icon, String shortForecast, String longForecast) {
        this.number = number;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isDayTime = isDayTime;
        this.temperature = temperature;
        this.temperatureUnit = temperatureUnit;
        this.temperatureTrend = temperatureTrend;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.icon = icon;
        this.shortForecast = shortForecast;
        this.longForecast = longForecast;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isDayTime() {
        return isDayTime;
    }

    public void setDayTime(boolean dayTime) {
        isDayTime = dayTime;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTemperatureTrend() {
        return temperatureTrend;
    }

    public void setTemperatureTrend(String temperatureTrend) {
        this.temperatureTrend = temperatureTrend;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShortForecast() {
        return shortForecast;
    }

    public void setShortForecast(String shortForecast) {
        this.shortForecast = shortForecast;
    }

    public String getLongForecast() {
        return longForecast;
    }

    public void setLongForecast(String longForecast) {
        this.longForecast = longForecast;
    }

    @Override
    public String toString() {
        return "ForecastPeriod{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isDayTime=" + isDayTime +
                ", temperature=" + temperature +
                ", temperatureUnit='" + temperatureUnit + '\'' +
                ", temperatureTrend='" + temperatureTrend + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", icon='" + icon + '\'' +
                ", shortForecast='" + shortForecast + '\'' +
                ", longForecast='" + longForecast + '\'' +
                '}';
    }
}
