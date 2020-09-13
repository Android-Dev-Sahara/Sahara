package com.daiict.internship.Sahara.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daiict.internship.Sahara.DataOperation.*;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.daiict.internship.Sahara.UserDashboard.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

public class CovidInfoActivity extends AppCompatActivity {

    FirebaseAuth mAuthentication;
    DatabaseReference mRef;

    boolean isdatafetchingdone = false;
    String userId;
    TextView tvCases, tvRecovered, tvCritical, tvActive, tvTodayCases, tvTotalDeaths, tvTodayDeaths, tvAffectedCountries;
    Button covidbtnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_info);


        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        covidbtnsubmit = findViewById(R.id.cobidbtnsubmit);
        coronaDataFetch();

        mAuthentication = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();

        FirebaseUser currentUser = mAuthentication.getCurrentUser();

        if (currentUser != null) {
            userId = currentUser.getUid();
        }

        SharedPrefManager.setPrefVal(CovidInfoActivity.this, SharedPrefManager.userID, userId);
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
                                SignUpSingle.getInstance().setActor("NGO");       // Singleton Usage
                                covidbtnsubmit.setEnabled(true);
                                // Store in Shared Pref
                                SharedPrefManager.setPrefVal(CovidInfoActivity.this, SharedPrefManager.userRole, "NGO");
                               // changeActivity();
                                isdatafetchingdone = true;

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
                    mRef.child("Donor").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Donor and Verification is Updated");
                                SignUpSingle.getInstance().setActor("Donor");       // Singleton Usage
                                covidbtnsubmit.setEnabled(true);
                                // Store the Data in Shared Preferences
                                SharedPrefManager.setPrefVal(CovidInfoActivity.this, SharedPrefManager.userRole, "Donor");
                                isdatafetchingdone = true;
                                //changeActivity();
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
                    mRef.child("Needy").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Needy and Verification is Updated");
                                SignUpSingle.getInstance().setActor("Needy");       // Singleton Usage
                                covidbtnsubmit.setEnabled(true);
                                SharedPrefManager.setPrefVal(CovidInfoActivity.this, SharedPrefManager.userRole, "Needy");
                                isdatafetchingdone = true;
                                //changeActivity();
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
                    mRef.child("Volunteer").child(userId).child("userIsVerified").setValue("Yes").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.e("onComplete: ", "User is in Volunteer and Verification is Updated");
                                SignUpSingle.getInstance().setActor("Volunteer");       // Singleton Usage
                                covidbtnsubmit.setEnabled(true);
                                SharedPrefManager.setPrefVal(CovidInfoActivity.this, SharedPrefManager.userRole, "Volunteer");
                                isdatafetchingdone = true;
                                //changeActivity();
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
        SharedPrefManager.setBooleanPrefVal(CovidInfoActivity.this, "isLoginOperSuccess", true);
        Intent intent = new Intent(CovidInfoActivity.this, BottomNavigationUsers.class);
        intent.putExtra("Fragment","homefragment");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


    public void coronaDataFetch()
    {
        String url = "https://disease.sh/v3/covid-19/all";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Handle the JSON object and handle it inside try and catch
                try {

                    // Creating object of JSONObject
                    JSONObject jsonObject
                            = new JSONObject(
                            response.toString());

                    // Set the data in text view
                    // which are available in JSON format
                    // Note that the parameter inside
                    // the getString() must match
                    // with the name given in JSON format
                    tvCases.setText(
                            jsonObject.getString(
                                    "cases"));
                    tvRecovered.setText(
                            jsonObject.getString(
                                    "recovered"));
                    tvCritical.setText(
                            jsonObject.getString(
                                    "critical"));
                    tvActive.setText(
                            jsonObject.getString(
                                    "active"));
                    tvTodayCases.setText(
                            jsonObject.getString(
                                    "todayCases"));
                    tvTotalDeaths.setText(
                            jsonObject.getString(
                                    "deaths"));
                    tvTodayDeaths.setText(
                            jsonObject.getString(
                                    "todayDeaths"));
                    tvAffectedCountries.setText(
                            jsonObject.getString(
                                    "affectedCountries"));
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

        }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CovidInfoActivity.this, "Cant load : \n" + error  , Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void btnLoginOnClick(View view) {
        if(isdatafetchingdone)
        {
            changeActivity();
        }
        else
        {
            //Wait until isdatafecthing gets true
        }

    }
}

