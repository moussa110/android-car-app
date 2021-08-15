package com.example.carapp.api;

import com.example.carapp.pojo.CarResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("cars")
    Call<CarResponse> getCars(
            @Query("page") int page
    );
}
