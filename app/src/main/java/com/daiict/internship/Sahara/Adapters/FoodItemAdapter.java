package com.daiict.internship.Sahara.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.ModelData.FoodItemModelData;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.UserDashboard.DonationDetails;

import java.util.List;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder>  {

    public FoodItemAdapter(DonationDetails donationDetails, List<FoodItemModelData> modelData) {
        activity = donationDetails;
        list = modelData;
    }

    Activity activity;
    List<FoodItemModelData> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View view = layoutInflater.inflate(R.layout.cardview_fooditem_layout, parent,false);
        return  new FoodItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItemModelData modelData = list.get(position);
        holder.donation_item_name.setText(holder.donation_item_name.getText() + modelData.getItemname());
        holder.donation_item_person.setText(holder.donation_item_person.getText() + modelData.getNoofpersons());
        holder.donation_item_spoilage.setText(holder.donation_item_spoilage.getText() + modelData.getSpoilage());
        holder.donation_item_weight.setText(holder.donation_item_weight.getText() + modelData.getWeight());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView donation_item_name, donation_item_person, donation_item_spoilage, donation_item_weight;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            donation_item_weight = itemView.findViewById(R.id.donation_item_weight);
            donation_item_spoilage = itemView.findViewById(R.id.donation_item_spoilage);
            donation_item_person = itemView.findViewById(R.id.donation_item_person);
            donation_item_name = itemView.findViewById(R.id.donation_item_name);
        }
    }
}
