package com.daiict.internship.Sahara.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.UserDashboard.BottomNavigationUsers;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CovidInfoActivity extends AppCompatActivity {

    FirebaseAuth mAuthentication;
    DatabaseReference mRef;

    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_info);
        mAuthentication = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();

        FirebaseUser currentUser = mAuthentication.getCurrentUser();

        if (currentUser != null) {
            userId = currentUser.getUid();
        }

        Log.e("onCreate: ", userId);

        mRef.child("NGO").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mRef.child("NGO").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in NGO and Verification is Updated");
                                changeActivity();
                            } else {
                                Log.e("onComplete: ", "Try Again Later..");
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRef.child("Donor").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mRef.child("NGO").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Donor and Verification is Updated");
                                changeActivity();
                            } else {
                                Log.e("onComplete: ", "Try Again Later..");
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRef.child("Needy").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mRef.child("NGO").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Needy and Verification is Updated");
                                changeActivity();
                            } else {
                                Log.e("onComplete: ", "Try Again Later..");
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRef.child("Volunteer").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mRef.child("NGO").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Volunteer and Verification is Updated");
                                changeActivity();
                            } else {
                                Log.e("onComplete: ", "Try Again Later..");
                            }
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void changeActivity() {
        Intent intent = new Intent(CovidInfoActivity.this, BottomNavigationUsers.class);
        intent.putExtra("Fragment","homefragment");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
