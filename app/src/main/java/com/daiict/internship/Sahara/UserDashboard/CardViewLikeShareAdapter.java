package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.text.style.AlignmentSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class CardViewLikeShareAdapter extends RecyclerView.Adapter<CardViewLikeShareAdapter.ViewHolder> {
    Context ctx;
    ArrayList<HomeDataFetchClass> list;

    public CardViewLikeShareAdapter(Context ctx, ArrayList<HomeDataFetchClass> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.cardview_home_likeshare, parent, false);
        return new CardViewLikeShareAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        HomeDataFetchClass abc = list.get(position);
        String a, b, c, d, e;
        a = abc.getNgoname();
        b = abc.getDate();
        c = abc.getCity();
        d = abc.getArea();
        e = abc.getTime();
        holder.image.setImageResource(R.drawable.intro_image_volunteeer);
        holder.tvName.setText(a);
        holder.tvDate.setText(b);
        holder.tvCity.setText(c);
        holder.tvArea.setText(d);
        holder.tvTime.setText(e);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTime, tvDate, tvArea, tvCity;
      final  ImageView imgLike, imgShare, image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.card_home_ngoname);
            tvTime = itemView.findViewById(R.id.card_home_time);
            tvDate = itemView.findViewById(R.id.card_home_date);
            tvArea = itemView.findViewById(R.id.card_home_area);
            tvCity = itemView.findViewById(R.id.card_home_city);

            imgLike = itemView.findViewById(R.id.card_home_like);
            imgShare = itemView.findViewById(R.id.card_home_share);
            image = itemView.findViewById(R.id.card_home_image);



        }

    }
}
