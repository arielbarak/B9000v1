package com.example.b9000v1.Comments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v1.R;
import com.example.b9000v1.Schema.Comment;
import com.example.b9000v1.Utilities.DateTimeUtilities;

import java.util.Date;
import java.util.Vector;

public class CommentsListAdapter extends RecyclerView.Adapter<CommentsListAdapter.CommentRowViewHolder> {

    private Vector<Comment> commentsList; //TODO maybe to delete

    public CommentsListAdapter(Vector<Comment> commentsList) {

    }

    @NonNull
    @Override
    public CommentRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notification, parent, false);
        return new CommentRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentRowViewHolder holder, int position) {
        Comment user = commentsList.elementAt(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }


    static class CommentRowViewHolder extends RecyclerView.ViewHolder {

        ImageView commentUserImage;
        TextView commentUserUsername;
        TextView commentDescription;
        TextView actionElapsedTime;

        public CommentRowViewHolder(@NonNull View itemView) {

            super(itemView);

            commentUserImage = itemView.findViewById(R.id.comment_commenter_image);
            commentUserUsername = itemView.findViewById(R.id.comment_commenter_username);
            commentDescription = itemView.findViewById(R.id.comment_description);
            actionElapsedTime = itemView.findViewById(R.id.notifications_elapsed_time);

        }

        public void bind(Comment comment) {

            commentUserUsername.setText("Username " + comment.getUser_Id()); // TODO change
            commentDescription.setText(comment.getContent());
            actionElapsedTime.setText(DateTimeUtilities.getFormattedElapsedTime(comment.getActionTime()));
        }
    }
}