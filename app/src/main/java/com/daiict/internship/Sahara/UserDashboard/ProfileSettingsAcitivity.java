package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.daiict.internship.Sahara.DataOperation.SharedPrefManager;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileSettingsAcitivity extends AppCompatActivity {

    private String fragmentName;
    private static final String LOGOUTCREDENTIAL = "logoutCredentials";
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings_acitivity);
        fragmentName = getIntent().getStringExtra("Fragment");
        mAuth = FirebaseAuth.getInstance();
    }

    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void passwordChangeButtonPressed(View view) {
        Snackbar.make(view, "A reset Link has been sent to your registered email id ", Snackbar.LENGTH_LONG).show();
        //Kindly share the password change link
    }

    public void generalSettingButtonPressed(View view) {
        //Pending To-Do


    }

    public void contactUsButtonPressed(View view) {
        Intent intent = new Intent(this, ProfileSettingsContactUs.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);

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

        Intent intent = new Intent(this, AboutUsCommonActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void logoutButtonPressed(View view) {
        boolean logoutCred = SharedPrefManager.getBooleanPrefVal(ProfileSettingsAcitivity.this, LOGOUTCREDENTIAL);
        Log.e("TAG", "logoutButtonPressed:" + logoutCred);
        if (logoutCred) {
            Log.e("TAG", "logoutButtonPressed: Direct Logout");
            mAuth.signOut();
            moveToLoginSignUpDashBoard();
        } else {
            Log.e("TAG", "logoutButtonPressed: Dialog Shown");
            AlertDialog.Builder Builder = new AlertDialog.Builder(ProfileSettingsAcitivity.this);
            View view_pop = getLayoutInflater().inflate(R.layout.pop_window_settings_logout, null);
            final Button confirm, cancel;
            //hooks
            confirm = view_pop.findViewById(R.id.settings_pop_btn_confirm_logout);
            cancel = view_pop.findViewById(R.id.settings_pop_btn_reject_logout);
            final CheckBox checkBox = view_pop.findViewById(R.id.settings_logout_checkbox_remember);

            //setting the view
            Builder.setView(view_pop);
            final Dialog dialog = Builder.create();
            dialog.show();
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean remember = checkBox.isChecked();
                    dialog.dismiss();
                    // Firebase Authentication Code
                    mAuth.signOut();
                    Snackbar.make(v, "You have been Logged out from the application ", Snackbar.LENGTH_LONG).show();

                    if (remember) {
                        //Code to Store the values in sharedPreference
                        SharedPrefManager.setBooleanPrefVal(ProfileSettingsAcitivity.this, LOGOUTCREDENTIAL, true);
                        Log.e("TAG", "onClick: Remember Checked");
                    } else {
                        SharedPrefManager.setBooleanPrefVal(ProfileSettingsAcitivity.this, LOGOUTCREDENTIAL, false);
                        Log.e("TAG", "onClick: Remember Not Checked");
                    }

                    moveToLoginSignUpDashBoard();
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
    private void moveToLoginSignUpDashBoard() {
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finishAffinity();
    }
}