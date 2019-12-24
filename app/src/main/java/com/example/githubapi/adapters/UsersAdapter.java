package com.example.githubapi.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubapi.R;
import com.example.githubapi.databinding.UserItemBinding;
import com.example.githubapi.models.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    List<User> users;

    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_item,
                parent, false
        );
        return new UserViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        UserItemBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setUser(user);
        binding.executePendingBindings();
    }

    @BindingAdapter({"imgUrl", "placeHolder"})
    public static void bindProilePic(ImageView imageView, String url, Drawable drawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(drawable)
                .fitCenter()
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
