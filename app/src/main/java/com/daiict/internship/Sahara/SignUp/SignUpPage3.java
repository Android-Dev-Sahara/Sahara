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
    TextInputLayout inputLayout_ngo_members;
    Switch aSwitch_worksfor;
    LinearLayout linearLayout_volunteer_gender, linearLayout_volunteer_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3);
        viewVisibility();

    }

    public void backBtnSignUpT(View view) {
        Intent intent = new Intent(this, SignUpPage2.class);
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

        inputLayout_ngo_members = findViewById(R.id.txtlayout_signup_third_ngo);


        if (get_category.equalsIgnoreCase("volunteer")) {
            aSwitch_worksfor.setVisibility(View.VISIBLE);
            linearLayout_volunteer_gender.setVisibility(View.VISIBLE);
            linearLayout_volunteer_type.setVisibility(View.VISIBLE);

        } else if (get_category.equalsIgnoreCase("ngo")) {
            inputLayout_ngo_members.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }
}
