package com.javasmithy.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ForecastService {
    @GET("gridpoints/{office}/{gridX},{gridY}/forecast")
    Call<Forecast> getDailyForecast(@Path("office") String office, @Path("gridX") int gridX, @Path("gridY") int gridY);

    @GET("gridpoints/{office}/{gridX},{gridY}/forecast/hourly")
    Call<Forecast> getHourlyForecast(@Path("office") String office, @Path("gridX") int gridX, @Path("gridY") int gridY);
}