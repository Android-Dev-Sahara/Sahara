package com.daiict.internship.Sahara.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class VerifyOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);
    }

    public void code_verification(View view) {
        Intent intent = new Intent(VerifyOTP.this, SetNewPassword.class);
        startActivity(intent);
    }
}