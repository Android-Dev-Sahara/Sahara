package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daiict.internship.Sahara.Adapters.FoodItemAdapter;
import com.daiict.internship.Sahara.ModelData.DonationModelData;
import com.daiict.internship.Sahara.ModelData.FoodItemModelData;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DonationDetails extends AppCompatActivity {

    List<FoodItemModelData> modelData = new ArrayList<>();

    TextView donation_details_name;
    TextView donation_details_raw_food;
    TextView donation_details_date;
    TextView donation_details_status;
    TextView donation_details_pickup;

    RecyclerView itemList;

    DatabaseReference mref;

    private String donationID, rawFood, date, status, pickup;
    private String ngoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);
        String donorName = getIntent().getStringExtra("donorName");
        donationID = getIntent().getStringExtra("donationID");
        mref = FirebaseDatabase.getInstance().getReference();
        getName();

        donation_details_name = findViewById(R.id.donation_details_name);
        donation_details_raw_food = findViewById(R.id.donation_details_raw_food);
        donation_details_date = findViewById(R.id.donation_details_date);
        donation_details_status = findViewById(R.id.donation_details_status);
        donation_details_pickup = findViewById(R.id.donation_details_pickup);
        itemList = findViewById(R.id.donation_details_items);
        itemList.setHasFixedSize(true);

        donation_details_name.setText(donation_details_name.getText() + donorName);

        final FoodItemAdapter adapter = new FoodItemAdapter(DonationDetails.this, modelData);
        itemList.setAdapter(adapter);

        assert donationID != null;
        mref.child("tbl_Donation").child(donationID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adapter.notifyDataSetChanged();

                rawFood = snapshot.child("isRawFood").getValue(String.class);
                date = snapshot.child("modifyDate").getValue(String.class);
                status = snapshot.child("status").getValue(String.class);
                pickup = snapshot.child("pickUpTime").getValue(String.class);

                donation_details_date.setText(donation_details_date.getText() + date);
                donation_details_pickup.setText(donation_details_pickup.getText() + pickup);
                donation_details_raw_food.setText(donation_details_raw_food.getText() + rawFood);
                donation_details_status.setText(donation_details_status.getText() + status);

                mref.child("tbl_Donation").child(donationID).child("Items").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        adapter.notifyDataSetChanged();
                        modelData.clear();
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            FoodItemModelData data = dataSnapshot.getValue(FoodItemModelData.class);
                            Log.e("onDataChange: ", data.getItemname());
                            modelData.add(data);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void getName() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String id = auth.getCurrentUser().getUid();


        DatabaseReference name = FirebaseDatabase.getInstance().getReference();
        name.child("NGO").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ngoName = snapshot.child("ngoName").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void backButtonPressed(View view) {
    }

    public void checkItem(View view) {
        if (status.equalsIgnoreCase("Not Accepted")) {
            mref.child("tbl_Donation").child(donationID).child("status").setValue("Accepted").addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    mref.child("tbl_Donation").child(donationID).child("acceptedBy").setValue(ngoName).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent = new Intent(DonationDetails.this, NgoSelectionofVolunteer.class);
                            intent.putExtra("donationid", donationID);
                            intent.putExtra("ngoname", ngoName);
                            intent.putExtra("fromNgo", "no");
                            startActivity(intent);
                        }
                    });
                }
            });
        }
    }
}