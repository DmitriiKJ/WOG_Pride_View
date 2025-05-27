package com.example.wog;

import com.google.gson.annotations.SerializedName;

public class Leg {
    @SerializedName("distance")
    private Distance distance;

    public Distance getDistance() {
        return distance;
    }
}
