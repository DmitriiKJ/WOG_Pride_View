package com.example.wog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DirectionsApi {
    @GET
    Call<DirectionsResponse> getDirections(@Url String url);
}
