package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpPage3 extends AppCompatActivity {

    String get_category;
    TextInputLayout inputLayout_ngo_members_family_member;
    Switch aSwitch_worksfor;
    LinearLayout linearLayout_volunteer_gender, linearLayout_volunteer_type;

    private String s_firstname, s_lname, s_emailid, s_password, s_ngoname, s_address1, s_address2, s_dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        fetchData();
        viewVisibility();

    }

    public void backBtnSignUpT(View view) {
        Intent intent = new Intent(SignUpPage3.this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    public void nextBtnSignUpT(View view) {


    }

    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");

        aSwitch_worksfor = findViewById(R.id.switch_signup_third_works_with);

        linearLayout_volunteer_gender = findViewById(R.id.linearlayout_signup_third_gender);
        linearLayout_volunteer_type = findViewById(R.id.linearlayout_signup_third_volunteer);

        inputLayout_ngo_members_family_member = findViewById(R.id.txtlayout_signup_third_ngo);


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

    private void fetchData() {
        Intent intent = getIntent();
        s_firstname = intent.getStringExtra("FirstName");
        s_lname = intent.getStringExtra("LastName");
        s_emailid = intent.getStringExtra("EmailId");
        s_password = intent.getStringExtra("Password");
        s_ngoname = intent.getStringExtra("ngoname");
        s_address1 = intent.getStringExtra("address1");
        s_address2 = intent.getStringExtra("address2");
        s_dob = intent.getStringExtra("dob");

    }
}
