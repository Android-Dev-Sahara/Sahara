package com.daiict.internship.Sahara.LoginSignUPDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SelectionCategory;

public class LoginSignUpDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_dashboard);
    }

    public void dashboardSignUp(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, SelectionCategory.class);
        startActivity(intent);
    }

    public void dashboardLogin(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, Login.class);
        startActivity(intent);
    }

    public void dashboardHowWeWork(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, AppWorkDetails.class);
        startActivity(intent);
    }
}
