package com.javasmithy.geo.point;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PointResolutionService {
    @GET("points/{latitude},{longitude}")
    Call<Point> getPointInformation(@Path("latitude") Double latitude, @Path("longitude") Double longitude);
}
