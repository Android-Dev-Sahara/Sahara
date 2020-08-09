package com.daiict.internship.Sahara.UserDashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.daiict.internship.Sahara.R;


public class ProfileFragment extends Fragment {


   @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView imageView_settings = view.findViewById(R.id.profilefrag_btn_settings);
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
       return view;
    }
}