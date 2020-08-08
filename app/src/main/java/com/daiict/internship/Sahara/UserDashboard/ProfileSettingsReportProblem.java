package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class ProfileSettingsReportProblem extends AppCompatActivity {

    private String fragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings_report_problem);
        fragmentName = getIntent().getStringExtra("Fragment");
    }

    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, ProfileSettingsAcitivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void submitButtonPressed(View view) {


    }
}