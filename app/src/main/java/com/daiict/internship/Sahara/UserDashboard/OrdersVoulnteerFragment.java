package com.daiict.internship.Sahara.UserDashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daiict.internship.Sahara.Adapters.VolunteerRecentOrder;
import com.daiict.internship.Sahara.ModelData.DonationModelData;
import com.daiict.internship.Sahara.ModelData.NGODonationModelData;
import com.daiict.internship.Sahara.ModelData.VolunteerRecentOrders;
import com.daiict.internship.Sahara.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrdersVoulnteerFragment extends Fragment {

    private FirebaseAuth mauth;
    private DatabaseReference orderRef;

    String userId;

    RecyclerView recentOrderList;
    List<VolunteerRecentOrders> dataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.fragment_orders_voulnteer, container, false);
        dataList.clear();
        mauth = FirebaseAuth.getInstance();
        orderRef = FirebaseDatabase.getInstance().getReference();

        userId = mauth.getCurrentUser().getUid();

        recentOrderList = view.findViewById(R.id.recent_orders_list_volunteers);
        recentOrderList.setHasFixedSize(true);

        getNGODonationList();
        getPickDonationList();

        VolunteerRecentOrder adapter = new VolunteerRecentOrder(getActivity(), dataList);
        recentOrderList.setAdapter(adapter);

        return view;
    }

    // Get Delivery Detail's
    private void getNGODonationList() {
        orderRef.child("tbl_NGO_Donation").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    NGODonationModelData ngoDonationModelData = dataSnapshot.getValue(NGODonationModelData.class);
                    assert ngoDonationModelData != null;

                    if (ngoDonationModelData.getAssignTo().equalsIgnoreCase(userId) && !ngoDonationModelData.getStatus().equalsIgnoreCase("Complete")) {
                        VolunteerRecentOrders recentOrders = new VolunteerRecentOrders(
                                ngoDonationModelData.getDonationId(),
                                ngoDonationModelData.getCreateDate(),
                                "Delivery",
                                ngoDonationModelData.getStatus(),
                                ngoDonationModelData.getLocation(),
                                ngoDonationModelData.getDeliveryTime());

                        Log.e("onDataChange: ", recentOrders.getCategory());

                        dataList.add(recentOrders);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getPickDonationList() {
        orderRef.child("tbl_Donation").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    DonationModelData donationModelData = dataSnapshot.getValue(DonationModelData.class);

                    assert donationModelData != null;
                    if (donationModelData.getAssignTo().equalsIgnoreCase(userId) && !donationModelData.getStatus().equalsIgnoreCase("Complete")) {
                        VolunteerRecentOrders recentOrders = new VolunteerRecentOrders(
                                donationModelData.getDonationId(),
                                donationModelData.getModifyDate(),
                                "PickUp",
                                donationModelData.getStatus(),
                                null,
                                donationModelData.getPickUpTime()
                        );

                        Log.e("onDataChange: ", recentOrders.getId());
                        dataList.add(recentOrders);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}