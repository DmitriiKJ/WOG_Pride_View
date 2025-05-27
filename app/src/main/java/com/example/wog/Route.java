package com.example.wog;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Route {
    @SerializedName("overview_polyline")
    private OverviewPolyline overview_polyline;
    @SerializedName("legs")
    private List<Leg> legs;

    public OverviewPolyline getOverviewPolyline() {
        return overview_polyline;
    }

    public List<Leg> getLegs() {
        return legs;
    }
}
