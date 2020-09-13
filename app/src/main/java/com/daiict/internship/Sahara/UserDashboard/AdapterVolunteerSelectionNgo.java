package com.daiict.internship.Sahara.UserDashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterVolunteerSelectionNgo extends RecyclerView.Adapter<AdapterVolunteerSelectionNgo.MyViewHolder> {

    Context context;
    ArrayList<VolunteerSelectionClass> list;
    String donationID;
    String fromNgo;

    public AdapterVolunteerSelectionNgo(Context context, ArrayList<VolunteerSelectionClass> list, String id, String fromNgo) {
        this.context = context;
        this.list = list;
        this.donationID = id;
        this.fromNgo = fromNgo;
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
        holder.btn_assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                if (fromNgo.equalsIgnoreCase("yes")) {
                    // From NGO Donation Side
                    reference.child("tbl_NGO_Donation").child(donationID).child("assignTo").setValue(item.getId()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent = new Intent(context, BottomNavigationUsers.class);
                            intent.putExtra("Fragment", "Homefragment");
                            context.startActivity(intent);
                        }
                    });
                } else {
                    // From Special Notification Side
                    reference.child("tbl_Donation").child(donationID).child("assignTo").setValue(item.getId()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent = new Intent(context, BottomNavigationUsers.class);
                            intent.putExtra("Fragment", "Homefragment");
                            context.startActivity(intent);
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Name, btn_assign;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.card_data_name_display);
            btn_assign = itemView.findViewById(R.id.volunteer_assign);

        }

    }
}
