package com.javasmithy.weather;

import java.util.List;

public class ForecastProperties {

    List<ForecastPeriod> periods;

    public ForecastProperties(List<ForecastPeriod> periods) {
        this.periods = periods;
    }

    public List<ForecastPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(List<ForecastPeriod> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "ForecastProperties{" +
                "periods=" + periods.isEmpty() +
                '}';
    }
}
