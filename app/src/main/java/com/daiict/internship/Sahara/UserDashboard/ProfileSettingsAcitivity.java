package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileSettingsAcitivity extends AppCompatActivity {

    private String fragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings_acitivity);
        fragmentName = getIntent().getStringExtra("Fragment");
    }

    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void passwordChangeButtonPressed(View view) {
        Snackbar.make(view, "A reset Link has been sent to your registered email id ", Snackbar.LENGTH_LONG).show();
    }

    public void generalSettingButtonPressed(View view) {

    }

    public void contactUsButtonPressed(View view) {

    }

    public void reportProblemButtonPressed(View view) {
        Intent intent = new Intent(this, ProfileSettingsReportProblem.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);

    }

    public void feedbackButtonPressed(View view) {
        Intent intent = new Intent(this, ProfileSettingsFeedback.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);

    }

    public void aboutSaharaButtonPressed(View view) {

    }

    public void logoutButtonPressed(View view) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(ProfileSettingsAcitivity.this);
        View view_pop = getLayoutInflater().inflate(R.layout.pop_window_settings_logout, null);
        final Button confirm ,cancel;
        //hooks
        confirm = view_pop.findViewById(R.id.settings_pop_btn_confirm_logout);
        cancel = view_pop.findViewById(R.id.settings_pop_btn_reject_logout);
        final CheckBox checkBox = view_pop.findViewById(R.id.settings_logout_checkbox_remember);
        final boolean remember = checkBox.isChecked();
        //setting the view
        Builder.setView(view_pop);
        final Dialog dialog  = Builder.create();
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                // Firebase Authentication Code
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginSignUpDashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finishAffinity();

               Snackbar.make(v, "You have been Logged out from the application ", Snackbar.LENGTH_LONG).show();
               if(remember)
               {
                   //Code to Store the values in sharedPreference
               }
               else
               {

               }

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}