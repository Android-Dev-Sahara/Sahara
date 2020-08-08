package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        AlertDialog.Builder Builder = new AlertDialog.Builder(ProfileSettingsReportProblem.this);
        View view_pop = getLayoutInflater().inflate(R.layout.popup_window_settings_changesettings_confirm, null);
        final Button confirm ,cancel;
        final TextView title;
        confirm = view_pop.findViewById(R.id.editsettings_pop_btn_confirm);
        cancel = view_pop.findViewById(R.id.editsettings_pop_btn_reject);
        title = view_pop.findViewById(R.id.popup_window_tv_title);
        title.setText("Do you want to Submit");
        Builder.setView(view_pop);
        final Dialog dialog  = Builder.create();
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(getApplicationContext(), ProfileSettingsAcitivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Fragment",fragmentName);
                startActivity(intent);

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