package com.javasmithy.geo;

import java.util.Objects;

public class GeoData {
    private String countryCode;
    private String postalCode;
    private String placeName;
    private String stateName;
    private String stateCode;
    private String countyName;
    private String countyCode;
    private double latitude;
    private double longitude;
    private int accuracy;

    public GeoData() {}

    public GeoData(String countryCode, String postalCode, String placeName, String stateName, String stateCode, String countyName, String countyCode, double latitude, double longitude, int accuracy) {
        this.countryCode = countryCode;
        this.postalCode = postalCode;
        this.placeName = placeName;
        this.stateName = stateName;
        this.stateCode = stateCode;
        this.countyName = countyName;
        this.countyCode = countyCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracy = accuracy;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoData geoData = (GeoData) o;
        return Double.compare(geoData.latitude, latitude) == 0 && Double.compare(geoData.longitude, longitude) == 0 && accuracy == geoData.accuracy && Objects.equals(countryCode, geoData.countryCode) && Objects.equals(postalCode, geoData.postalCode) && Objects.equals(placeName, geoData.placeName) && Objects.equals(stateName, geoData.stateName) && Objects.equals(stateCode, geoData.stateCode) && Objects.equals(countyName, geoData.countyName) && Objects.equals(countyCode, geoData.countyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, postalCode, placeName, stateName, stateCode, countyName, countyCode, latitude, longitude, accuracy);
    }

    @Override
    public String toString() {
        return "GeoData{" +
                "countryCode='" + countryCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", placeName='" + placeName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", countyName='" + countyName + '\'' +
                ", countyCode='" + countyCode + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", accuracy=" + accuracy +
                '}';
    }
}
