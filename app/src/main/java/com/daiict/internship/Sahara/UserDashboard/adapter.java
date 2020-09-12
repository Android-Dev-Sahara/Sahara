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

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    public adapter(Context context, ArrayList<AddItemDataClass> list) {
        this.context = context;
        this.list = list;
    }

    Context context;
    ArrayList<AddItemDataClass> list;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_donor_dataitem_showing,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddItemDataClass item;
        item = list.get(position);
        holder.itemname.setText(item.getItemname());
        holder.persons.setText( item.getNoofpersons());
        holder.weight.setText(item.getWeight());
        holder.spoilage.setText(item.getSpoilage());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView itemname,persons,weight,spoilage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.adddonor_card_itemname);
            persons = itemView.findViewById(R.id.adddonor_card_noofpersons);
            weight = itemView.findViewById(R.id.adddonor_card_weight);
            spoilage = itemView.findViewById(R.id.adddonor_card_spoilage);
        }

    }


}
