package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.ModelData.AreaModelData;
import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder>{

    Context context;
    ArrayList<AreaModelData> list;

    public AreaAdapter(NgoSelectionLocationAddData ngoSelectionLocationAddData, ArrayList<AreaModelData> list) {
        context = ngoSelectionLocationAddData;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_location_tracking,parent,false);
        return  new AreaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AreaModelData modelData = list.get(position);
        holder.txtAreaName.setText(modelData.getAreaName());
        holder.area_donation_count.setText(holder.area_donation_count.getText() + " " + modelData.getNoOfDonation());
        holder.area_population_count.setText(holder.area_population_count.getText() + " " + modelData.getPopulation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAreaName;
        TextView area_donation_count;
        TextView area_population_count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAreaName = itemView.findViewById(R.id.txtAreaName);
            area_donation_count = itemView.findViewById(R.id.area_donation_count);
            area_population_count = itemView.findViewById(R.id.area_population_count);
        }
    }
}
