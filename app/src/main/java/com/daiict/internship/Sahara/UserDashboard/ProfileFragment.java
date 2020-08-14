package com.daiict.internship.Sahara.UserDashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    TextView profilefrag_text_name;
    DatabaseReference mRef;
    FirebaseAuth mAuth;

   @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView imageView_settings = view.findViewById(R.id.profilefrag_btn_settings);
       profilefrag_text_name = view.findViewById(R.id.profilefrag_text_name);
       mRef = FirebaseDatabase.getInstance().getReference();
       mAuth = FirebaseAuth.getInstance();

       // Error......
       String userRole = SignUpSingle.getInstance().getActor();
       String userID = mAuth.getUid();

       assert userID != null;
       mRef.child(userRole).child(userID).child("userName").addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               String val = snapshot.getValue(String.class);
               profilefrag_text_name.setText(val);
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

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