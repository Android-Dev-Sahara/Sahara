package com.daiict.internship.Sahara.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class ForgetPasswordSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_success_message);
    }

    public void do_login(View view) {
        Intent intent = new Intent(ForgetPasswordSuccessMessage.this, Login.class);
        startActivity(intent);
    }
}