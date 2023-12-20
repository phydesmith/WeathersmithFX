package com.javasmithy.geo.point;

import com.google.gson.annotations.SerializedName;

public class Point {
    @SerializedName("properties")
    private PointProperties pointProperties;

    public Point(PointProperties pointProperties) {
        this.pointProperties = pointProperties;
    }

    public PointProperties getPointProperties() {
        return pointProperties;
    }

    public void setPointProperties(PointProperties pointProperties) {
        this.pointProperties = pointProperties;
    }

    @Override
    public String toString() {
        return "Point{" +
                "pointProperties=" + pointProperties +
                '}';
    }
}
