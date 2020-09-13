package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.daiict.internship.Sahara.ModelData.AreaModelData;
import com.daiict.internship.Sahara.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NgoSelectionLocationAddData extends AppCompatActivity {
    private String fragmentName, ngoname, donationid;
    AreaAdapter areaAdapter;
    private ArrayList<AreaModelData> list = new ArrayList<>();
    RecyclerView rView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_selection_location_add_data);
        fragmentName = getIntent().getStringExtra("Fragment");
        ngoname = getIntent().getStringExtra("ngoname");
        donationid = getIntent().getStringExtra("donationid");

        rView = findViewById(R.id.recyclerview_data_location_ngo);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this));

        areaAdapter = new AreaAdapter(this, list, fragmentName, ngoname, donationid);
        rView.setAdapter(areaAdapter);

        getAreaData();
    }

    private void getAreaData() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("tbl_Areas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                areaAdapter.notifyDataSetChanged();
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String name = dataSnapshot.child("areaName").getValue(String.class);
                    String latitude = dataSnapshot.child("latitude").getValue(String.class);
                    String longitude = dataSnapshot.child("longitude").getValue(String.class);
                    String donation = dataSnapshot.child("noOfDonation").getValue(String.class);
                    String pincode = dataSnapshot.child("pincode").getValue(String.class);
                    String population = dataSnapshot.child("population").getValue(String.class);
                    String marker = dataSnapshot.child("marker").getValue(String.class);
                    list.add(new AreaModelData(name, latitude, longitude, marker, donation, pincode, population));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void backBtnAddNgoDataDisplay(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);

    }

    public void LocationSelectionProceed(View view) {
        RecentDonationsNGOFragment recentDonationsNGOFragment = new RecentDonationsNGOFragment();

        Intent intent = new Intent(this, NgoSelectionofVolunteer.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        //intent.putExtra("ngoname", modelData.getNgoName());
        //context.startActivity(intent);

    }
}