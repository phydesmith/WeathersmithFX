package io.javasmithy.geo.point;


public class PointProperties {
    private String forecastOffice;
    private String gridId;
    private int gridX;
    private int gridY;
    private String forecastSevenDay;
    private String forecastHourly;

    public PointProperties(String forecastOffice, String gridId, int gridX, int gridY, String forecastSevenDay, String forecastHourly) {
        this.forecastOffice = forecastOffice;
        this.gridId = gridId;
        this.gridX = gridX;
        this.gridY = gridY;
        this.forecastSevenDay = forecastSevenDay;
        this.forecastHourly = forecastHourly;
    }

    public String getForecastOffice() {
        return forecastOffice;
    }

    public void setForecastOffice(String forecastOffice) {
        this.forecastOffice = forecastOffice;
    }

    public String getGridId() {
        return gridId;
    }

    public void setGridId(String gridId) {
        this.gridId = gridId;
    }

    public int getGridX() {
        return gridX;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }

    public String getForecastSevenDay() {
        return forecastSevenDay;
    }

    public void setForecastSevenDay(String forecastSevenDay) {
        this.forecastSevenDay = forecastSevenDay;
    }

    public String getForecastHourly() {
        return forecastHourly;
    }

    public void setForecastHourly(String forecastHourly) {
        this.forecastHourly = forecastHourly;
    }

    @Override
    public String toString() {
        return "PointProperties{" +
                "forecastOffice='" + forecastOffice + '\'' +
                ", gridId='" + gridId + '\'' +
                ", gridX=" + gridX +
                ", gridY=" + gridY +
                ", forecastSevenDay='" + forecastSevenDay + '\'' +
                ", forecastHourly='" + forecastHourly + '\'' +
                '}';
    }
}
