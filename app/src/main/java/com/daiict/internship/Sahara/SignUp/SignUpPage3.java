package com.daiict.internship.Sahara.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daiict.internship.Sahara.Login.*;
import com.daiict.internship.Sahara.ModelData.*;
import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class SignUpPage3 extends AppCompatActivity {

    String get_category;

    TextInputLayout inputLayout_ngo_members_family_member, txtlayout_signup_third_select_ngo;
    MaterialAutoCompleteTextView edttxt_signup_third_ngo_list;
    TextInputEditText editText_contact, editText_ngo_member;
    RadioGroup rgrp_gender;
    Button btn_signup;
    LinearLayout linearLayout_volunteer_gender;
    RelativeLayout relativeLayout_progress;

    private ArrayAdapter<String> adapter;

    private FirebaseAuth mAuth;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        viewVisibility();

    }

    private void viewVisibility() {
        get_category = SignUpSingle.getInstance().getActor();
        linearLayout_volunteer_gender = findViewById(R.id.linearlayout_signup_third_gender);
        inputLayout_ngo_members_family_member = findViewById(R.id.txtlayout_signup_third_ngo);
        edttxt_signup_third_ngo_list = findViewById(R.id.edttxt_signup_third_ngo_list);
        txtlayout_signup_third_select_ngo = findViewById(R.id.txtlayout_signup_third_select_ngo);
        editText_contact = findViewById(R.id.edttxt_signup_third_contact);
        editText_ngo_member = findViewById(R.id.edttxt_signup_third_ngo_member);
        rgrp_gender = findViewById(R.id.rgrp_signup_third_gender);
        relativeLayout_progress = findViewById(R.id.progress_bar_login_rl_create);
        // Firebase Code Binding
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        if (get_category.equalsIgnoreCase("volunteer")) {
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            txtlayout_signup_third_select_ngo.setVisibility(View.VISIBLE);
            loadNGO();
            edttxt_signup_third_ngo_list.setAdapter(adapter);
        } else if (get_category.equalsIgnoreCase("ngo")) {
            linearLayout_volunteer_gender.setVisibility(View.GONE);
            inputLayout_ngo_members_family_member.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            inputLayout_ngo_members_family_member.setVisibility(View.VISIBLE);
            inputLayout_ngo_members_family_member.setHint("Family Member Count ");
        } else {
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
        }
    }

    public void backBtnSignUpT(View view) {
        Intent intent = new Intent(SignUpPage3.this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void nextBtnSignUpT(View view) {

        int selectedRadioButtonID;
        RadioButton selectedRadioButton;

        if (validateContact() && validateGender() && validateNGOName() && validateMemberCount()) {
            btn_signup = findViewById(R.id.btn_signup_third_signup);
            btn_signup.setEnabled(false);
            // SignUp Process Start
            String contact = editText_contact.getText().toString().trim();
            // Get Gender
            selectedRadioButtonID = rgrp_gender.getCheckedRadioButtonId();
            selectedRadioButton = (rgrp_gender.getCheckedRadioButtonId() != -1) ? (RadioButton) findViewById(selectedRadioButtonID) : null;
            String gender = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : null;
            // Get NGO Member
            String memberCount = editText_ngo_member.getText().toString();

            // Get NGO name for Volunteer
            String NgoName = edttxt_signup_third_ngo_list.getText().toString().trim();

            SignUpSingle.getInstance().setContactNo(contact);
            SignUpSingle.getInstance().setGender(gender);
            SignUpSingle.getInstance().setVolunteerNgo(NgoName);
            SignUpSingle.getInstance().setMembersCount(memberCount);

            // If all things and Validation are Correct then now Create User Account
            createUserAccount();
        }

    }

    private void createUserAccount() {
        relativeLayout_progress.setVisibility(View.VISIBLE);
        // Using Firebase Authentication, We create User Account
        String emailId = SignUpSingle.getInstance().getEmailID();
        String password = SignUpSingle.getInstance().getAccPass();

        if (!emailId.isEmpty() && !password.isEmpty()) {
            // Create Account with Email and Password
            mAuth.createUserWithEmailAndPassword(emailId, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // If Creation of Account is Successfull....
                                Log.e("onComplete: ", "Account Creation Successfull");
                                // Send Email Verification
                                relativeLayout_progress.setVisibility(View.INVISIBLE);
                                sendEmailVerification();
                            } else {
                                // If Task is not Successfull
                                relativeLayout_progress.setVisibility(View.INVISIBLE);
                                Log.e("onComplete: ", String.valueOf(task.getException()));
                                btn_signup.setEnabled(true);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Purpose is to fetch the Exception where Account with Given Email is Already Exist
                    if (e.toString().equals("com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account.")) {
                        View rootView = getWindow().getDecorView().getRootView();
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        Snackbar alredyInUseMsg = Snackbar.make(rootView, "Given Email Already in Use", Snackbar.LENGTH_SHORT);
                        alredyInUseMsg.show();
                    } else {
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        Log.e("Authentication Error: ", e.toString() + "");
                    }
                    btn_signup.setEnabled(true);
                }
            });
        } else {
            Toast.makeText(this, "Error in Singleton Pattern", Toast.LENGTH_SHORT).show();
            btn_signup.setEnabled(true);
        }
    }

    private void sendEmailVerification() {
        relativeLayout_progress.setVisibility(View.VISIBLE);
        // Get Current User From Firebase Authentication...
        FirebaseUser mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            mUser.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        Log.e("onComplete: ", "Email Verification Sent!!!");
                        // Now the Final Task is to Register Data
                        registerData();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    relativeLayout_progress.setVisibility(View.INVISIBLE);
                    Log.e("Verification Error:", e.toString() + "");
                    btn_signup.setEnabled(true);
                }
            });
        }
    }

    private void registerData() {
        String userID = (mAuth != null) ? mAuth.getUid() : null;
        String name = SignUpSingle.getInstance().getFirstName() + " " + SignUpSingle.getInstance().getLastName();
        String address = SignUpSingle.getInstance().getAddressLine1();
        String area = SignUpSingle.getInstance().getAddressLine2();
        String createDate = Calendar.getInstance().getTime().toString();
        String modifyDate = Calendar.getInstance().getTime().toString();
        String userIsVerified = "No";

        assert userID != null;

        if (get_category.equalsIgnoreCase("donor")) {
            DonoModelData modelData = new DonoModelData(
                    userID,
                    name,
                    SignUpSingle.getInstance().getEmailID(),
                    address,
                    area,
                    SignUpSingle.getInstance().getDateOfBirth_Establishment(),
                    SignUpSingle.getInstance().getContactNo(),
                    SignUpSingle.getInstance().getGender(),
                    createDate,
                    modifyDate,
                    userIsVerified);

            mReference.child(get_category).child(userID).setValue(modelData).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.e("onComplete: ", "Registration Successfully");
                        mAuth.signOut();
                        Snackbar successFullMsg = Snackbar.make(rootView, "Done. Please Verify Email Before Login.", Snackbar.LENGTH_LONG);
                        successFullMsg.show();
                        Intent intent = new Intent(SignUpPage3.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    relativeLayout_progress.setVisibility(View.INVISIBLE);
                    Log.e("onFailure: ", "Registration Failed!!" + " " + e.toString());
                    btn_signup.setEnabled(true);
                }
            });
        } else if (get_category.equalsIgnoreCase("ngo")) {
            NGOModelData modelData = new NGOModelData(userID,
                    name,
                    SignUpSingle.getInstance().getEmailID(),
                    SignUpSingle.getInstance().getNgoName(),
                    address,
                    area,
                    SignUpSingle.getInstance().getDateOfBirth_Establishment(),
                    SignUpSingle.getInstance().getContactNo(),
                    SignUpSingle.getInstance().getMembersCount(),
                    createDate,
                    modifyDate,
                    userIsVerified);

            mReference.child(get_category).child(userID).setValue(modelData).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.e("onComplete: ", "Registration Successfully");
                        mAuth.signOut();
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        Snackbar successFullMsg = Snackbar.make(rootView, "Done. Please Verify Email Before Login.", Snackbar.LENGTH_LONG);
                        successFullMsg.show();
                        Intent intent = new Intent(SignUpPage3.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    relativeLayout_progress.setVisibility(View.INVISIBLE);
                    Log.e("onFailure: ", "Registration Failed!!" + " " + e.toString());
                    btn_signup.setEnabled(true);
                }
            });
        } else if (get_category.equalsIgnoreCase("volunteer")) {
            VolunteerModelData modelData = new VolunteerModelData(
                    userID,
                    name,
                    SignUpSingle.getInstance().getEmailID(),
                    address,
                    area,
                    SignUpSingle.getInstance().getDateOfBirth_Establishment(),
                    SignUpSingle.getInstance().getContactNo(),
                    SignUpSingle.getInstance().getGender(),
                    SignUpSingle.getInstance().getVolunteerNgo(),
                    createDate,
                    modifyDate,
                    userIsVerified);

            mReference.child(get_category).child(userID).setValue(modelData).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.e("onComplete: ", "Registration Successfully");
                        mAuth.signOut();
                        Snackbar successFullMsg = Snackbar.make(rootView, "Done. Please Verify Email Before Login.", Snackbar.LENGTH_LONG);
                        successFullMsg.show();

                        Intent intent = new Intent(SignUpPage3.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    relativeLayout_progress.setVisibility(View.INVISIBLE);
                    Log.e("onFailure: ", "Registration Failed!!" + " " + e.toString());
                    btn_signup.setEnabled(true);
                }
            });
        } else if (get_category.equalsIgnoreCase("needy")){
            NeedyModelData modelData = new NeedyModelData(
                    userID,
                    name,
                    SignUpSingle.getInstance().getEmailID(),
                    address,
                    area,
                    SignUpSingle.getInstance().getDateOfBirth_Establishment(),
                    SignUpSingle.getInstance().getContactNo(),
                    SignUpSingle.getInstance().getMembersCount(),
                    SignUpSingle.getInstance().getGender(),
                    createDate,
                    modifyDate,
                    userIsVerified);

            mReference.child(get_category).child(userID).setValue(modelData).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        relativeLayout_progress.setVisibility(View.INVISIBLE);
                        View rootView = getWindow().getDecorView().getRootView();
                        Log.e("onComplete: ", "Registration Successfully");
                        mAuth.signOut();
                        Toast.makeText(SignUpPage3.this, "Done. Please Verify Email Before Login.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignUpPage3.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    relativeLayout_progress.setVisibility(View.INVISIBLE);
                    Log.e("onFailure: ", "Registration Failed!!" + " " + e.toString());
                    btn_signup.setEnabled(true);
                }
            });
        }
    }

    private boolean validateContact() {
        /*
         * Conact Number Validation
         * Empty - NonEmpty Validation
         * Contact No Length
         * Numeric Characters Only
         * */

        String contact = editText_contact.getText().toString().trim();

        if (TextUtils.isEmpty(contact)) {
            editText_contact.setError("Enter Contact Number");
            return false;
        } else if (contact.length() != 10) {
            editText_contact.setError("Enter Valid Contact Number");
            return false;
        } else if (!contact.matches("[0-9]+")) {
            editText_contact.setError("Enter Valid Contact Number");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateGender() {
        if ((!get_category.equalsIgnoreCase("ngo")) && rgrp_gender.getCheckedRadioButtonId() == -1) {
            View rootView = getWindow().getDecorView().getRootView();
            Snackbar genderErrMsg = Snackbar.make(rootView, "Select any one Gender", Snackbar.LENGTH_SHORT);
            genderErrMsg.show();
            return false;
        } else {
            return true;
        }
    }


    private boolean validateNGOName() {
        if (get_category.equalsIgnoreCase("volunteer") && edttxt_signup_third_ngo_list.getText().toString().isEmpty()) {
            View rootView = getWindow().getDecorView().getRootView();
            Snackbar volunteerErrMsg = Snackbar.make(rootView, "Select any one Type", Snackbar.LENGTH_SHORT);
            volunteerErrMsg.show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateMemberCount() {
        /*
         * NGO Members or Family Members Count
         * Empty-NonEmpty Validation
         * Numeric Validation
         * */

        String membersCount = editText_ngo_member.getText().toString().trim();

        if ((get_category.equalsIgnoreCase("ngo") || get_category.equalsIgnoreCase("needy")) && TextUtils.isEmpty(membersCount)) {
            editText_ngo_member.setError("Please Enter Members Count");
            return false;
        } else if ((get_category.equalsIgnoreCase("ngo") || get_category.equalsIgnoreCase("needy")) && !membersCount.matches("[0-9]+")) {
            editText_ngo_member.setError("Numeric Only");
            return false;
        } else {
            return true;
        }

    }

    private void loadNGO() {
        mReference.child("NGO").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String name = dataSnapshot.child("ngoName").getValue(String.class);
                    adapter.add(name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

/*
                        // This will Edit....
                        Snackbar successFullMsg = Snackbar.make(rootView, "Done. Please Verify Email Before Login.", Snackbar.LENGTH_LONG);
                        successFullMsg.show();
                         */