package com.daiict.internship.Sahara.UserDashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daiict.internship.Sahara.ModelData.DonationModelData;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class SpecialPurposeNotifcationFragment extends Fragment {
    public static ArrayList<SpecialNotificationClassNGO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_special_purpose_notifcation, container, false);
        RecyclerView rview = view.findViewById(R.id.recyclerview_notification_special_purpose);
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        //ArrayList list;
        //create list data
        Collections.reverse(list);
        final NotificationSpecialNotificationAdapter adapter = new NotificationSpecialNotificationAdapter(this.getActivity(), list);
        rview.setAdapter(adapter);

        if (SignUpSingle.getInstance().getActor().equals("NGO")) {
            final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

            reference.child("tbl_Donation").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    list.clear();
                    adapter.notifyDataSetChanged();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DonationModelData modelData = dataSnapshot.getValue(DonationModelData.class);
                        assert modelData != null;
                        if (modelData.getStatus().equals("Not Accepted")) {
                            final SpecialNotificationClassNGO model = new SpecialNotificationClassNGO();
                            model.setPickUpTime(modelData.getPickUpTime());
                            model.setDonationId(modelData.getDonationId());
                            reference.child("Donor").child(modelData.getDonorId()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    adapter.notifyDataSetChanged();
                                    String donorName = snapshot.child("userName").getValue(String.class);
                                    String area = snapshot.child("area").getValue(String.class);
                                    String email = snapshot.child("emailID").getValue(String.class);
                                    model.setDonorName(donorName);
                                    model.setLocation(area);
                                    model.setNoOfPerson(email);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                            list.add(model);
                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        final SwipeRefreshLayout swipeRefreshLayout = view.findViewById(R.id.swiper_notification_special_purpose);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Add the code to update the data from database
                adapter.notifyDataSetChanged();
                //update the adapter too by using the code adapter.notifyDataSetChanged()
            }
        });
        return view;
    }
}