package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.ModelData.AreaModelData;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder>{

    Context context;
    ArrayList<AreaModelData> list;
    String fragmentName, ngoName, donationId;

    public AreaAdapter(NgoSelectionLocationAddData ngoSelectionLocationAddData, ArrayList<AreaModelData> list, String fragmentName, String ngoName, String donationId) {
        context = ngoSelectionLocationAddData;
        this.list = list;
        this.fragmentName = fragmentName;
        this.ngoName = ngoName;
        this.donationId = donationId;
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
        AreaModelData model = list.get(position);
        holder.txtAreaName.setText(model.getAreaName());
        holder.area_donation_count.setText("Donations: " + model.getNoOfDonation());
        holder.area_population_count.setText("Population: " + model.getPopulation());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                AreaModelData data = list.get(position);
                String areaName = data.getAreaName();
                Toast.makeText(context, areaName + "is Selected...", Toast.LENGTH_SHORT).show();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                ref.child("tbl_NGO_Donation").child(donationId).child("location").setValue(areaName).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(context, NgoSelectionofVolunteer.class);
                            intent.putExtra("Fragment", fragmentName);
                            intent.putExtra("fromNgo", "yes");
                            intent.putExtra("ngoname", ngoName);
                            intent.putExtra("donationid", donationId);
                            context.startActivity(intent);
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtAreaName;
        TextView area_donation_count;
        TextView area_population_count;

        private ItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAreaName = itemView.findViewById(R.id.txtAreaName);
            area_donation_count = itemView.findViewById(R.id.area_donation_count);
            area_population_count = itemView.findViewById(R.id.area_population_count);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
