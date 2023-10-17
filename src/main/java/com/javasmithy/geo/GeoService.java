package com.javasmithy.geo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GeoService {
    @GET("geosmith/v1/geodata/{postalCode}")
    Call<GeoData> getGeoData(@Path("postalCode") String postalCode);
}
