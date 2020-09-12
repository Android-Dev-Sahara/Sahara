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

public class donationAdapter extends RecyclerView.Adapter<donationAdapter.ViewHolder> {
    Context ctx;
    ArrayList<DonationClass> List;

    public donationAdapter(Context ctx, ArrayList<DonationClass> list) {
        this.ctx = ctx;
        List = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(ctx);
        View view=layoutInflater.inflate(R.layout.cardview_home_likeshare,parent,false);
        return  new donationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonationClass donationItem = List.get(position);
        holder.areaName.setText(donationItem.getArea_name());
        holder.noOfDonation.setText(donationItem.getNo_of_donation());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView areaName,noOfDonation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            areaName=itemView.findViewById(R.id.card_home_area);
            noOfDonation=itemView.findViewById(R.id.card_home_time);
        }


    }

}
