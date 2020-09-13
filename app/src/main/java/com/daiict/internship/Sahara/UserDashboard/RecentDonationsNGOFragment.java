package com.daiict.internship.Sahara.UserDashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.daiict.internship.Sahara.ModelData.NGODonationModelData;
import com.daiict.internship.Sahara.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecentDonationsNGOFragment extends Fragment {
    Switch switch_isRawFood;
    Spinner spinner_pickUpTime;

    String deliveryTime, isRawFood, ngoName;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recent_donations_n_g_o, container, false);
        switch_isRawFood = (Switch) view.findViewById(R.id.switchRawFood_ngo);
        spinner_pickUpTime = (Spinner) view.findViewById(R.id.spin_donation_ngo);
        Button button = (Button) view.findViewById(R.id.btn_additem_ngo);
        getName();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NgoDonationsAddItemData.class);

                if (validatePickUpTime()) {
                    deliveryTime = spinner_pickUpTime.getSelectedItem().toString();
                    isRawFood = switch_isRawFood.isChecked() ? "true" : "false";

                    intent.putExtra("Fragment", "recentdonationsngofragment");
                    intent.putExtra("ngoname", ngoName);
                    intent.putExtra("deliveryTime", deliveryTime);
                    intent.putExtra("israwfood", isRawFood);

                    startActivity(intent);
                }
            }
        });

        return view;
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

    private boolean validatePickUpTime() {
        if (!spinner_pickUpTime.getSelectedItem().toString().equals("--Select an Option--")) {
            return true;
        } else {
            Snackbar errorMsg = Snackbar.make(view, "Select Pick Time.", Snackbar.LENGTH_LONG);
            errorMsg.show();
            return false;
        }
    }
}