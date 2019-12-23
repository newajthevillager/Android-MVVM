package com.example.githubapi.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.githubapi.models.ApiResponse;
import com.example.githubapi.repositories.UserRepository;

public class UsersViewModel extends AndroidViewModel {

    UserRepository userRepository;
    MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<>();

    public UsersViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ApiResponse> getUsers(String numberOfUsers) {
        userRepository = new UserRepository();
        apiResponse = userRepository.getApiResponse(numberOfUsers);
        return apiResponse;
    }

}
