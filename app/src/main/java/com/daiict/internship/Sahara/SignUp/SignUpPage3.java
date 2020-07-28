package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpPage3 extends AppCompatActivity {

    String get_category;
    TextInputLayout inputLayout_ngo_members_family_member;
    TextInputEditText editText_contact, editText_ngo_member;
    Spinner spin_signup_third_city;
    Switch aSwitch_worksfor;
    TextView textView_cityErrorMsg;
    RadioGroup rgrp_gender, rgrp_volunteer;
    LinearLayout linearLayout_volunteer_gender, linearLayout_volunteer_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        viewVisibility();

    }

    public void backBtnSignUpT(View view) {
        Intent intent = new Intent(SignUpPage3.this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category",get_category);
        startActivity(intent);

    }

    public void nextBtnSignUpT(View view) {
        int selectedRadioButtonID;
        RadioButton selectedRadioButton;

        if (validateContact() && validateCitySpinner() && validateGender() && validateVolunteerType() && validateMemberCount()) {
            // SignUp Process Start
            String contact = editText_contact.getText().toString().trim();
            String cityName = spin_signup_third_city.getSelectedItem().toString();
            // Get Gender
            selectedRadioButtonID =  rgrp_gender.getCheckedRadioButtonId();
            selectedRadioButton = (rgrp_gender.getCheckedRadioButtonId() != -1) ? (RadioButton) findViewById(selectedRadioButtonID) : null;
            String gender = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : null;
            // Get Volunteer Type
            selectedRadioButtonID =  rgrp_volunteer.getCheckedRadioButtonId();
            selectedRadioButton = (rgrp_volunteer.getCheckedRadioButtonId() != -1) ? (RadioButton) findViewById(selectedRadioButtonID) : null;
            String volunteerType = (selectedRadioButton != null) ? selectedRadioButton.getText().toString() : null;
            String isWorkNgo = (aSwitch_worksfor.getVisibility() == View.VISIBLE) ? (aSwitch_worksfor.isChecked() ? "Yes" : "No") : null;
            String memberCount = editText_ngo_member.getText().toString();

            SignUpSingle.getInstance().setContactNo(contact);
            SignUpSingle.getInstance().setCityName(cityName);
            SignUpSingle.getInstance().setGender(gender);
            SignUpSingle.getInstance().setVolunteerType(volunteerType);
            SignUpSingle.getInstance().setIsWorkWithNgo(isWorkNgo);
            SignUpSingle.getInstance().setMembersCount(memberCount);

        }
    }

    private void viewVisibility() {
        get_category = SignUpSingle.getInstance().getActor();
        aSwitch_worksfor = findViewById(R.id.switch_signup_third_works_with);
        linearLayout_volunteer_gender = findViewById(R.id.linearlayout_signup_third_gender);
        linearLayout_volunteer_type = findViewById(R.id.linearlayout_signup_third_volunteer);
        inputLayout_ngo_members_family_member = findViewById(R.id.txtlayout_signup_third_ngo);
        spin_signup_third_city = findViewById(R.id.spin_signup_third_city);
        editText_contact = findViewById(R.id.edttxt_signup_third_contact);
        editText_ngo_member = findViewById(R.id.edttxt_signup_third_ngo_member);
        textView_cityErrorMsg = findViewById(R.id.cityErrorMsg);
        rgrp_gender = findViewById(R.id.rgrp_signup_third_gender);
        rgrp_volunteer = findViewById(R.id.rgrp_signup_third_volunteer);


        if (get_category.equalsIgnoreCase("volunteer")) {
            aSwitch_worksfor.setVisibility(View.VISIBLE);
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            linearLayout_volunteer_type.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("ngo")) {
            inputLayout_ngo_members_family_member.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            inputLayout_ngo_members_family_member.setVisibility(View.VISIBLE);
            inputLayout_ngo_members_family_member.setHint("Family Member Count ");
        } else {
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
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

    private boolean validateCitySpinner() {
        /*
        * City Spinner Validation:
        * To check whether the Selected Option is Valid or Not
        * */

        String cityName = spin_signup_third_city.getSelectedItem().toString();

        if (cityName.equalsIgnoreCase("--Select an Option--")) {
            textView_cityErrorMsg.setVisibility(View.VISIBLE);
            return false;
        } else {
            textView_cityErrorMsg.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean validateGender() {
        if ((!get_category.equalsIgnoreCase("ngo"))&& rgrp_gender.getCheckedRadioButtonId() == -1) {
            View rootView = getWindow().getDecorView().getRootView();
            Snackbar genderErrMsg = Snackbar.make(rootView, "Select any one Gender", Snackbar.LENGTH_SHORT);
            genderErrMsg.show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateVolunteerType() {
        if (get_category.equalsIgnoreCase("volunteer") && rgrp_volunteer.getCheckedRadioButtonId() == -1) {
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
}
