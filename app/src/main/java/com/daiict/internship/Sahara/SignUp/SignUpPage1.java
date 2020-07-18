package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpPage1 extends AppCompatActivity {

    TextInputLayout textInputLayout_ngo;
    String get_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1);
        viewVisibility();


    }

    public void backBtnSignUpF(View view) {
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    public void loginBtnSignUpF(View view) {
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void nextBtnSignUpF(View view) {
        Intent intent = new Intent(this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        startActivity(intent);

    }

    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");

        textInputLayout_ngo = findViewById(R.id.txtlayout_signup_first_ngo);


        if (get_category.equalsIgnoreCase("volunteer")) {

        } else if (get_category.equalsIgnoreCase("ngo")) {
            textInputLayout_ngo.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }
}
