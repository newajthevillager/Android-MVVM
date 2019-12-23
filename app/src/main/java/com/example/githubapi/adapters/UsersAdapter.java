package com.example.githubapi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.githubapi.R;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameTv.setText(user.getName().getFirst() + " " + user.getName().getLast());
        holder.emailTv.setText(user.getEmail());
        holder.genderTv.setText(user.getGender());
        Glide.with(holder.imageView.getContext())
                .load(user.getPicture().getThumbnail())
                .fitCenter()
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTv, emailTv, genderTv;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivProPic);
            nameTv = itemView.findViewById(R.id.tvName);
            emailTv = itemView.findViewById(R.id.tvEmail);
            genderTv = itemView.findViewById(R.id.tvGender);

        }
    }

}
