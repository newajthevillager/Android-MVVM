package com.example.githubapi.network;

import com.example.githubapi.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api")
    Call<ApiResponse> getResponse(
            @Query("results")
            String results // number of users
    );

}
