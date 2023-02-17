package io.javasmithy.weather;

import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BoundForecastPeriodProperties {
    private SimpleIntegerProperty number;
    private SimpleStringProperty name;
    private SimpleStringProperty startTime;
    private SimpleStringProperty endTime;
    private SimpleBooleanProperty isDayTime;
    private SimpleIntegerProperty temperature;
    private SimpleStringProperty temperatureUnit;
    private SimpleStringProperty temperatureTrend;
    private SimpleStringProperty windSpeed;
    private SimpleStringProperty windDirection;
    private SimpleStringProperty icon;
    private SimpleStringProperty shortForecast;
    @SerializedName("detailedForecast")
    private SimpleStringProperty longForecast;

    public BoundForecastPeriodProperties(){
        this.number = new SimpleIntegerProperty(-1);
        this.name = new SimpleStringProperty("");
        this.startTime = new SimpleStringProperty("");
        this.endTime = new SimpleStringProperty("");
        this.isDayTime = new SimpleBooleanProperty(false);
        this.temperature = new SimpleIntegerProperty(1);
        this.temperatureUnit = new SimpleStringProperty("");
        this.temperatureTrend = new SimpleStringProperty("");
        this.windSpeed = new SimpleStringProperty("");
        this.windDirection = new SimpleStringProperty("");
        this.icon = new SimpleStringProperty("");
        this.shortForecast = new SimpleStringProperty("");
        this.longForecast = new SimpleStringProperty("");
    }

    public BoundForecastPeriodProperties(SimpleIntegerProperty number, SimpleStringProperty name, SimpleStringProperty startTime, SimpleStringProperty endTime, SimpleBooleanProperty isDayTime, SimpleIntegerProperty temperature, SimpleStringProperty temperatureUnit, SimpleStringProperty temperatureTrend, SimpleStringProperty windSpeed, SimpleStringProperty windDirection, SimpleStringProperty icon, SimpleStringProperty shortForecast, SimpleStringProperty longForecast) {
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
        return number.get();
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public SimpleStringProperty startTimeProperty() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getEndTime() {
        return endTime.get();
    }

    public SimpleStringProperty endTimeProperty() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime.set(endTime);
    }

    public boolean isIsDayTime() {
        return isDayTime.get();
    }

    public SimpleBooleanProperty isDayTimeProperty() {
        return isDayTime;
    }

    public void setIsDayTime(boolean isDayTime) {
        this.isDayTime.set(isDayTime);
    }

    public int getTemperature() {
        return temperature.get();
    }

    public SimpleIntegerProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature.set(temperature);
    }

    public String getTemperatureUnit() {
        return temperatureUnit.get();
    }

    public SimpleStringProperty temperatureUnitProperty() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit.set(temperatureUnit);
    }

    public String getTemperatureTrend() {
        return temperatureTrend.get();
    }

    public SimpleStringProperty temperatureTrendProperty() {
        return temperatureTrend;
    }

    public void setTemperatureTrend(String temperatureTrend) {
        this.temperatureTrend.set(temperatureTrend);
    }

    public String getWindSpeed() {
        return windSpeed.get();
    }

    public SimpleStringProperty windSpeedProperty() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed.set(windSpeed);
    }

    public String getWindDirection() {
        return windDirection.get();
    }

    public SimpleStringProperty windDirectionProperty() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection.set(windDirection);
    }

    public String getIcon() {
        return icon.get();
    }

    public SimpleStringProperty iconProperty() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon.set(icon);
    }

    public String getShortForecast() {
        return shortForecast.get();
    }

    public SimpleStringProperty shortForecastProperty() {
        return shortForecast;
    }

    public void setShortForecast(String shortForecast) {
        this.shortForecast.set(shortForecast);
    }

    public String getLongForecast() {
        return longForecast.get();
    }

    public SimpleStringProperty longForecastProperty() {
        return longForecast;
    }

    public void setLongForecast(String longForecast) {
        this.longForecast.set(longForecast);
    }

    @Override
    public String toString() {
        return "SimpleForecastPeriod{" +
                "number=" + number +
                ", name=" + name +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isDayTime=" + isDayTime +
                ", temperature=" + temperature +
                ", temperatureUnit=" + temperatureUnit +
                ", temperatureTrend=" + temperatureTrend +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", icon=" + icon +
                ", shortForecast=" + shortForecast +
                ", longForecast=" + longForecast +
                '}';
    }

    public void updateProperties(ForecastPeriod forecastPeriod){
        setNumber(forecastPeriod.getNumber());
        setName(forecastPeriod.getName());
        setStartTime(forecastPeriod.getStartTime());
        setEndTime(forecastPeriod.getEndTime());
        setIsDayTime(forecastPeriod.isDayTime());
        setTemperature(forecastPeriod.getTemperature());
        setTemperatureUnit(forecastPeriod.getTemperatureUnit());
        setTemperatureTrend(forecastPeriod.getTemperatureTrend());
        setWindSpeed(forecastPeriod.getWindSpeed());
        setWindDirection(forecastPeriod.getWindDirection());
        setIcon(forecastPeriod.getIcon());
        setShortForecast(forecastPeriod.getShortForecast());
        setLongForecast(forecastPeriod.getLongForecast());
    }
}
