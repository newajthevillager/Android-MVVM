package com.example.githubapi.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.githubapi.models.ApiResponse;
import com.example.githubapi.network.ApiService;
import com.example.githubapi.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    ApiService apiService;
    MutableLiveData<ApiResponse> apiResponse;

    public UserRepository() {
        apiService = RetrofitClient.createApiService(ApiService.class);
        apiResponse = new MutableLiveData<>();
    }

    public MutableLiveData<ApiResponse> getApiResponse(String numberOfResult) {
        apiService.getResponse(numberOfResult).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("MVVM", "Response successful");
                    apiResponse.setValue(response.body());
                } else {
                    Log.d("MVVM", "Response is not successful " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("MVVM", "Response Failure : " + t.getMessage().toString());
            }
        });
        return apiResponse;
    }

}
