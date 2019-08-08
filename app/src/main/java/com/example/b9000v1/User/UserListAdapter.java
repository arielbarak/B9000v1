package com.example.b9000v1.User;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v1.Schema.User;
import com.example.b9000v1.R;

import java.util.Vector;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserRowViewHolder>  {

    private Vector<User> searchList; //TODO maybe to delete

    public UserListAdapter(Vector<User> usersList) {
        this.searchList = usersList;
    }

    @NonNull
    @Override
    public UserRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_user, parent, false);
        return new UserRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRowViewHolder holder, int position) {
        User user = searchList.elementAt(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }


    static class UserRowViewHolder extends RecyclerView.ViewHolder {

        ImageView userImage;
        TextView userUsername;

        public UserRowViewHolder(@NonNull View itemView) {

            super(itemView);

            userImage = itemView.findViewById(R.id.searched_user_user_image);
            userUsername = itemView.findViewById(R.id.searched_user_user_username);
        }

        public void bind(User user){

            Log.d("TAG:" , user.toString());
            String str = user.getUsername();
            userUsername.setText(str); // TODO change
        }
    }
}