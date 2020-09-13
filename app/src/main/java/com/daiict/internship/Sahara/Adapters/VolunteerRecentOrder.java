package com.daiict.internship.Sahara.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.ModelData.VolunteerRecentOrders;
import com.daiict.internship.Sahara.R;

import java.util.List;

public class VolunteerRecentOrder extends RecyclerView.Adapter<VolunteerRecentOrder.ViewHolder> {
    private Activity activity;
    private List<VolunteerRecentOrders> list;

    public VolunteerRecentOrder(FragmentActivity activity, List<VolunteerRecentOrders> dataList) {
        this.activity = activity;
        this.list = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View view = layoutInflater.inflate(R.layout.cardview_recent_orders_list_layout, parent,false);
        return  new VolunteerRecentOrder.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VolunteerRecentOrders data = list.get(position);
        holder.volunteer_orders_time.setText("Time: " + data.getTime());
        holder.volunteer_orders_date.setText("Date: " + data.getDate());
        holder.volunteers_order_status.setText("Status: " + data.getStatus());
        if (data.getArea() != null) {
            holder.volunteer_orders_area.setText("Area: " + data.getArea());
        } else {
            holder.volunteer_orders_area.setVisibility(View.GONE);
        }

        holder.volunteer_orders_category.setText("Category: " + data.getCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView volunteer_orders_date, volunteer_orders_category, volunteers_order_status, volunteer_orders_area, volunteer_orders_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            volunteer_orders_date = itemView.findViewById(R.id.volunteer_orders_date);
            volunteer_orders_category = itemView.findViewById(R.id.volunteer_orders_category);
            volunteers_order_status = itemView.findViewById(R.id.volunteers_order_status);
            volunteer_orders_area = itemView.findViewById(R.id.volunteer_orders_area);
            volunteer_orders_time = itemView.findViewById(R.id.volunteer_orders_time);
        }
    }
}
