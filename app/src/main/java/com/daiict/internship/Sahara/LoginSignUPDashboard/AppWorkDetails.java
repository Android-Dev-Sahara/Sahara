package com.daiict.internship.Sahara.LoginSignUPDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.UserDashboard.BottomNavigationUsers;

public class AppWorkDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_work_details);
    }

    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        startActivity(intent);
        finishAffinity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        startActivity(intent);
        finishAffinity();
    }
}
