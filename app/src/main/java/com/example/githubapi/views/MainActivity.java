package com.example.githubapi.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.githubapi.R;
import com.example.githubapi.adapters.UsersAdapter;
import com.example.githubapi.models.ApiResponse;
import com.example.githubapi.models.User;
import com.example.githubapi.viewmodels.UsersViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UsersAdapter adapter;

    List<User> users = new ArrayList<>();
    UsersViewModel usersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new UsersAdapter(users);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        usersViewModel.getUsers("7").observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                users.addAll(apiResponse.getResults());
                adapter.notifyDataSetChanged();
            }
        });

    }
}
