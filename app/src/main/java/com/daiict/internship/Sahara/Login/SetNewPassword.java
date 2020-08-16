package com.daiict.internship.Sahara.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void setPassword(View view) {
        Intent intent = new Intent(SetNewPassword.this, ForgetPasswordSuccessMessage.class);
        startActivity(intent);
    }

    public void back_to_makeSelection(View view) {
        Intent intent = new Intent(SetNewPassword.this, SelectForgotPassMethod.class);
        startActivity(intent);
    }
}