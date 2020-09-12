package com.daiict.internship.Sahara.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.ModelData.DonationModelData;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.UserDashboard.GeneralNotificationClass;
import com.daiict.internship.Sahara.UserDashboard.NotificationGeneralNotificationAdapter;

import java.util.ArrayList;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {

    public DonationAdapter(Context context, ArrayList<DonationModelData> list) {
        this.context = context;
        this.list = list;
    }


    Context context;
    ArrayList<DonationModelData> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_donation_list, parent,false);
        return  new DonationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonationModelData modelData = list.get(position);
        holder.recent_donation_date.setText(holder.recent_donation_date.getText() + modelData.getModifyDate());
        holder.recent_donation_pickup.setText(holder.recent_donation_pickup.getText() + modelData.getPickUpTime());
        holder.recent_donation_status.setText(holder.recent_donation_status.getText() + modelData.getStatus());
        holder.recent_donation_pickby.setText(holder.recent_donation_pickby.getText() + modelData.getAcceptedBy());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView recent_donation_date, recent_donation_pickup, recent_donation_status, recent_donation_pickby;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recent_donation_date = itemView.findViewById(R.id.recent_donation_date);
            recent_donation_pickup = itemView.findViewById(R.id.recent_donation_pickup);
            recent_donation_status = itemView.findViewById(R.id.recent_donation_status);
            recent_donation_pickby = itemView.findViewById(R.id.recent_donation_pickby);
        }
    }
}
