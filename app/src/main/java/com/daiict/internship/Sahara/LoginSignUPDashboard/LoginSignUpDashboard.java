package com.daiict.internship.Sahara.LoginSignUPDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
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
        Pair[] pairs = new Pair[1];

        //From here the transition that is popup effect will be generated if and only if the API version > 21
        pairs[0] = new Pair<View,String>(findViewById(R.id.btn_login_dashboard),"btn_login_transition");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginSignUpDashboard.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else
        {
            startActivity(intent);
        }

    }

    public void dashboardHowWeWork(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, AppWorkDetails.class);
        startActivity(intent);
    }
}
