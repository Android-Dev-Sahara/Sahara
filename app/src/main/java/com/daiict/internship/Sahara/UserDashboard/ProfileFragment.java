package com.daiict.internship.Sahara.UserDashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.Adapters.DonationAdapter;
import com.daiict.internship.Sahara.ModelData.DonationModelData;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;


public class ProfileFragment extends Fragment {

    TextView profilefrag_text_name, profilefrag_text_area;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView dataList;

   @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
       ImageView imageView_settings = view.findViewById(R.id.profilefrag_btn_settings);
       profilefrag_text_name = view.findViewById(R.id.profilefrag_text_name);
       profilefrag_text_area = view.findViewById(R.id.profilefrag_text_area);
       dataList = view.findViewById(R.id.profilefrag_recyclerview_data_show);
       swipeRefreshLayout = view.findViewById(R.id.swiper_notification_general_purpose);
       dataList.setHasFixedSize(true);

        imageView_settings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),ProfileSettingsAcitivity.class);
               intent.putExtra("Fragment", "profilefragment");
               startActivity(intent);
           }
       });


        Button editprofilebutton = view.findViewById(R.id.profilefrag_btn_edit_prof);
        editprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ProfileEditProfileActivity.class);
                intent.putExtra("Fragment", "profilefragment");
                startActivity(intent);

            }
        });

       loadProfileData();
       //loadData();
       return view;
    }

    private void loadProfileData() {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String userRole = SignUpSingle.getInstance().getActor();
        String userID = mAuth.getUid();

        assert userID != null;
        mRef.child(userRole).child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("userName").getValue(String.class);
                String address = snapshot.child("address").getValue(String.class);
                String area = address + ", " + snapshot.child("area").getValue(String.class);

                profilefrag_text_name.setText(name);
                profilefrag_text_area.setText(area);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void loadData() {
       DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
       FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String userRole = SignUpSingle.getInstance().getActor();
        final String userID = mAuth.getUid();

        assert userID != null;

        if (userRole.equalsIgnoreCase("Donor")) {
            final ArrayList<DonationModelData> donationList = new ArrayList<>();
            // Show his Recent Donations
            ref.child("tbl_Donation").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        if (Objects.equals(dataSnapshot.child("donorId").getValue(String.class), userID)) {
                            // Get Data of Donation
                            String modifyDate = dataSnapshot.child("modifyDate").getValue(String.class);
                            String pickUp = dataSnapshot.child("pickUpTime").getValue(String.class);
                            String stat = dataSnapshot.child("status").getValue(String.class);
                            String acceptBy = "--";
                            if (stat != null && !stat.equals("Not Accepted")) {
                                acceptBy = dataSnapshot.child("acceptedBy").getValue(String.class);
                            }

                            DonationModelData modelData = new DonationModelData(modifyDate, pickUp, stat, acceptBy);
                            donationList.add(modelData);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            final DonationAdapter adapter = new DonationAdapter(this.getActivity(), donationList);
            dataList.setAdapter(adapter);

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    //Add the code to update the data from database

                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}