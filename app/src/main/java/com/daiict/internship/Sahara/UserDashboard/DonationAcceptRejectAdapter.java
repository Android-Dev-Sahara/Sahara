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

import de.hdodenhof.circleimageview.CircleImageView;

public class DonationAcceptRejectAdapter extends RecyclerView.Adapter<DonationAcceptRejectAdapter.ViewHolder> {
    Context context;
    ArrayList list;

    public DonationAcceptRejectAdapter(Context context, ArrayList list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_notification_special_purpose,parent,false);
        return  new DonationAcceptRejectAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //use setext for all the hooks that are created below
        //Kindly Add class and update the data;
        //use holder.

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView donorname,date,Location,Time,noofpersons;
        CircleImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //create hooks for all the card view;
            donorname = itemView.findViewById(R.id.card_special_donorname);
            date = itemView.findViewById(R.id.card_special_date);
            Location = itemView.findViewById(R.id.card_special_location);
            Time = itemView.findViewById(R.id.card_special_time);
            noofpersons = itemView.findViewById(R.id.card_special_noofpersons);
            imageView = itemView.findViewById(R.id.card_special_circleImageView);
        }


    }
}
