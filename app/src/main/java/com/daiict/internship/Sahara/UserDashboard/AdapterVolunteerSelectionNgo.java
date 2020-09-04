package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class AdapterVolunteerSelectionNgo extends RecyclerView.Adapter<AdapterVolunteerSelectionNgo.MyViewHolder> {

    Context context;
    ArrayList<VolunteerSelectionClass> list;

    public AdapterVolunteerSelectionNgo(Context context, ArrayList<VolunteerSelectionClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_ngo_volunteer_selection,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final VolunteerSelectionClass item = list.get(position);
        holder.Name.setText(item.getName());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.checkBox.isChecked())
                {
                    item.setChecked(true);
                }
                else
                    item.setChecked(false);
            }
        });


    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        CheckBox checkBox;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.card_data_name_display);
            checkBox = itemView.findViewById(R.id.checkbox_selection_card);

        }

    }
}
