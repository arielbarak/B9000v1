package com.example.b9000v1.Notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b9000v1.Schema.Notification;
import com.example.b9000v1.R;
import com.example.b9000v1.Utilities.DateTimeUtilities;

import java.util.Vector;

public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.NotificationRowViewHolder>  {

    private Vector<Notification> notificationsList; //TODO maybe to delete

    public NotificationsListAdapter(Vector<Notification> notificationsList) {
        this.notificationsList = notificationsList;
    }//TODO maybe to delete

    @NonNull
    @Override
    public NotificationRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_notification, parent, false);
        return new NotificationRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationRowViewHolder holder, int position) {
        Notification notification = notificationsList.elementAt(position);
        holder.bind(notification);
    }

    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    static class NotificationRowViewHolder extends RecyclerView.ViewHolder {

        ImageView triggeringUserImage;
        ImageView effectedUserImage;
        TextView  triggeringUserUsername;
        TextView  description;
        TextView  actionElapsedTime;

        public NotificationRowViewHolder(@NonNull View itemView) {

            super(itemView);

            triggeringUserImage = itemView.findViewById(R.id.notification_trigger_user_image);
            effectedUserImage = itemView.findViewById(R.id.notifications_effected_user_image);
            triggeringUserUsername = itemView.findViewById(R.id.notification_trigger_user_username);
            description = itemView.findViewById(R.id.notification_description);
            actionElapsedTime = itemView.findViewById(R.id.notifications_elapsed_time);
        }

        public void bind(Notification notification){
            triggeringUserUsername.setText("Triggering User # " + notification.getTriggering_user_id()); // TODO change
            description.setText(notification.getAction().getDescription());
            actionElapsedTime.setText(DateTimeUtilities.getFormattedElapsedTime(notification.getAction_time()));
        }
    }
}
