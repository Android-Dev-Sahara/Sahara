package com.daiict.internship.Sahara.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.LoginSignUPDashboard.AppWorkDetails;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SelectionCategory;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginBack(View view)
    {
        Intent intent = new Intent(Login.this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    public void loginForgotPassword(View view)
    {
        Intent intent = new Intent(Login.this, ForgotPassword.class);
        startActivity(intent);

    }
    public void loginLoginButton(View view)
    {

    }
    public void loginCreateAccount(View view)
    {
        Intent intent = new Intent(Login.this, SelectionCategory.class);
        startActivity(intent);
        finish();
    }
}
