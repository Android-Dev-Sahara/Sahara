package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class NotificationSpecialNotificationAdapter extends RecyclerView.Adapter<NotificationSpecialNotificationAdapter.ViewHolder> {
    public NotificationSpecialNotificationAdapter(Context context, ArrayList<SpecialNotificationClassNGO> list) {
        this.context = context;
        this.list = list;
    }


    Context context;
    ArrayList<SpecialNotificationClassNGO> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_notification_special_purpose,parent,false);
        return  new NotificationSpecialNotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final SpecialNotificationClassNGO object = list.get(position);
        holder.textView_donorName.setText(object.getDonorName());
        holder.location.setText(object.getLocation());
        holder.noOfPerson.setText(object.getNoOfPerson());
        holder.time.setText(object.getPickUpTime());

        holder.data_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DonationDetails.class);
                intent.putExtra("donorName", object.getDonorName());
                intent.putExtra("donationID", object.getDonationId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView_donorName;
        TextView location;
        TextView noOfPerson;
        TextView time;
        ImageButton data_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_donorName = itemView.findViewById(R.id.card_special_donorname);
            location = itemView.findViewById(R.id.card_special_location);
            noOfPerson = itemView.findViewById(R.id.card_special_noofpersons);
            time = itemView.findViewById(R.id.card_special_time);
            data_details = itemView.findViewById(R.id.data_details);
        }
    }
}
