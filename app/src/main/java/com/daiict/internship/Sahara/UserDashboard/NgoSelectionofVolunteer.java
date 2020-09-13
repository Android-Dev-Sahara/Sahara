package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daiict.internship.Sahara.ModelData.VolunteerModelData;
import com.daiict.internship.Sahara.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NgoSelectionofVolunteer extends AppCompatActivity {
    public RecyclerView rview;
    private String fragmentName;
    ArrayList<VolunteerSelectionClass> list;

    DatabaseReference mRef;

    String donationID, ngoName, fromngo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_selectionof_volunteer);
        fragmentName = getIntent().getStringExtra("Fragment");

        mRef = FirebaseDatabase.getInstance().getReference();

        donationID = getIntent().getStringExtra("donationid");
        ngoName = getIntent().getStringExtra("ngoname");
        fromngo = getIntent().getStringExtra("fromNgo");

        //Hooks added for recyclerview
        rview = findViewById(R.id.recyclerview_data_volunteer_ngo);
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();


        final AdapterVolunteerSelectionNgo adapter = new AdapterVolunteerSelectionNgo(this, list, donationID, fromngo);
        rview.setAdapter(adapter);


        mRef.child("Volunteer").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.notifyDataSetChanged();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    VolunteerModelData modelData = dataSnapshot.getValue(VolunteerModelData.class);
                    if (modelData.getNgoName().equalsIgnoreCase(ngoName)) {
                        String name = modelData.getUserName();
                        String id = modelData.getVolunteerID();
                        list.add(new VolunteerSelectionClass(id, name));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    //recyclerview_data_volunteer_ngo

    public void backBtnAddNgoDataDisplay(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);

    }

    public void AllDataProceed(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);

    }
}