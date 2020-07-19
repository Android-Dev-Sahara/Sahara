package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;

public class SignUpPage2 extends AppCompatActivity {

    String get_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2);
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");
    }

    public void backBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        startActivity(intent);
        finish();
    }

    public void nextBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        startActivity(intent);
    }
}
