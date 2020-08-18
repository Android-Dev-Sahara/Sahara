package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommonDonationAdapter extends RecyclerView.Adapter<CommonDonationAdapter.ViewHolder> {

    Context context;
    ArrayList<DonationCommonClass> list;

    public CommonDonationAdapter(Context context, ArrayList<DonationCommonClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.cardview_of_common_donation,parent,false);
        return new CommonDonationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonationCommonClass object = list.get(position);
        holder.donarName.setText(object.getDonar_name().toString());
        holder.contact_no.setText(object.getContact_no());
        holder.no_of_person.setText(object.getNo_of_persons());
        holder.date.setText(object.getDate());
        holder.time.setText(object.getTime());
        holder.location.setText(object.getLocation().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView donarImage;
        TextView donarName,location,date,time,no_of_person,contact_no;

        public ViewHolder(@NotNull View itemView){
            super(itemView);

            donarImage=itemView.findViewById(R.id.card_common_circleImageView);
            donarName=itemView.findViewById(R.id.card_common_donorname);
            location=itemView.findViewById(R.id.card_common_location);
            date=itemView.findViewById(R.id.card_common_date);
            time=itemView.findViewById(R.id.card_common_time);
            no_of_person=itemView.findViewById(R.id.card_common_noofpersons);
            contact_no=itemView.findViewById(R.id.card_common_contact_no);
        }
    }
}
