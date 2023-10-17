package com.javasmithy;

import io.javasmithy.geo.GeoData;
import io.javasmithy.geo.GeoService;
import io.javasmithy.geo.point.Point;
import io.javasmithy.geo.point.PointResolutionService;
import io.javasmithy.weather.Forecast;
import io.javasmithy.weather.ForecastService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class AppInteractor {
    private final String BASE_GEO_URL = "http://192.168.1.30:8080/";
    private final String BASE_WEATHER_API_URL = "https://api.weather.gov/";
    private GeoModel geoModel;
    private WeatherModel weatherModel;

    private Forecast forecast;
    private GeoData geoData;
    public AppInteractor(GeoModel geoModel, WeatherModel weatherModel){
        this.geoModel = geoModel;
        this.weatherModel = weatherModel;
    }

    public void getGeoData(){
        try {
            //  Fetch GeoData
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_GEO_URL).addConverterFactory(GsonConverterFactory.create())
                .validateEagerly(true)
                .build();
            GeoService service = retrofit.create(GeoService.class);
            Call<GeoData> geoDataCall = service.getGeoData(this.geoModel.getPostalCode());
            Response<GeoData> geoDataResponse = geoDataCall.execute();
            this.geoData = geoDataResponse.body();
            System.out.println(this.geoData.toString());

            //  Point Resolution
            Retrofit retrofitWeatherAPI = new Retrofit.Builder()
                    .baseUrl(BASE_WEATHER_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .validateEagerly(true)
                    .build();
            PointResolutionService prService = retrofitWeatherAPI.create(PointResolutionService.class);
            Call<Point> pointCall = prService.getPointInformation(geoData.getLatitude(), geoData.getLongitude());
            Response<Point> pointResponse = pointCall.execute();
            Point point = pointResponse.body();
            System.out.println(point);

            //  Fetch Forecast
            ForecastService forecastService = retrofitWeatherAPI.create(ForecastService.class);
            Call<Forecast> forecastCall = forecastService.getDailyForecast(
                    point.getPointProperties().getGridId(),
                    point.getPointProperties().getGridX(),
                    point.getPointProperties().getGridY()
            );
            Response<Forecast> forecastResponse = forecastCall.execute();
            this.forecast = forecastResponse.body();
            System.out.println(this.forecast);


        } catch (IOException | RuntimeException e ){
            e.printStackTrace();
        }
    }

    public void updatedWeatherModel(){
        this.geoModel.setPlaceName(this.geoData.getPlaceName());
        this.geoModel.setStateCode(this.geoData.getStateCode());
        this.weatherModel.updateForecast(this.forecast);
    }

}
