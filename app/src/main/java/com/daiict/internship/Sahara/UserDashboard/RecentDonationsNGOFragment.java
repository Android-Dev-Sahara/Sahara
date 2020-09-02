package com.daiict.internship.Sahara.UserDashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;

import com.daiict.internship.Sahara.R;
import com.google.android.material.snackbar.Snackbar;

public class RecentDonationsNGOFragment extends Fragment {
    Switch switch_isRawFood;
    Spinner spinner_pickUpTime;

    String pickUpTime, isRawFood;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recent_donations_n_g_o, container, false);
        switch_isRawFood = (Switch) view.findViewById(R.id.switchRawFood_ngo);
        spinner_pickUpTime = (Spinner) view.findViewById(R.id.spin_donation_ngo);
        Button button = (Button) view.findViewById(R.id.btn_additem_ngo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NgoDonationsAddItemData.class);

                if (validatePickUpTime()) {
                    pickUpTime = spinner_pickUpTime.getSelectedItem().toString();
                    isRawFood = switch_isRawFood.isChecked() ? "true" : "false";

                    intent.putExtra("Fragment", "recentdonationsngofragment");
                    //intent.putExtra("pickUpValue", pickUpTime);
                    //intent.putExtra("isRawFood", isRawFood);

                    startActivity(intent);
                }
            }
        });

        return view;
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