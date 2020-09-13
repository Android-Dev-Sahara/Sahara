package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class NotificationGeneralNotificationAdapter extends RecyclerView.Adapter<NotificationGeneralNotificationAdapter.ViewHolder> {

    public NotificationGeneralNotificationAdapter(Context context, ArrayList<GeneralNotificationClass> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<GeneralNotificationClass> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_notification_general_purpose,parent,false);
        return  new NotificationGeneralNotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GeneralNotificationClass object = list.get(position);
        holder.textView_notify.setText(object.getText_data_notification());
        holder.textView_date.setText(object.getDate());
        holder.textView_time.setText(object.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_notify,textView_date,textView_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_notify = itemView.findViewById(R.id.general_notification_display);
            textView_date = itemView.findViewById(R.id.general_notification_date);
            textView_time = itemView.findViewById(R.id.general_notification_time);

        }
    }
}
