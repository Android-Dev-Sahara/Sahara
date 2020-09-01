package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileEditProfileActivity extends AppCompatActivity {

    private String fragmentName;
    String viewFragment;
    TextInputEditText fname, lname, emailid, ngoname, addressline1, addressline2, contact, membersngo, status;
    TextInputLayout txtfname,txtngoname,txtmembercount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_profile);
        fragmentName = getIntent().getStringExtra("Fragment");
        viewFragment = SignUpSingle.getInstance().getActor();

        txtfname = findViewById(R.id.textinputlayout_fname);
        txtngoname = findViewById(R.id.setting_change_ngoname_txtlayout);
        txtmembercount = findViewById(R.id.setting_change_members_in_ngo_family_txtlayout);;

        fname = findViewById(R.id.setting_change_fname);
        lname = findViewById(R.id.setting_change_lname);
        emailid = findViewById(R.id.setting_change_email);
        ngoname = findViewById(R.id.setting_change_ngoname_text);
        addressline1 = findViewById(R.id.setting_change_address1);
        contact = findViewById(R.id.setting_change_contact);
        membersngo = findViewById(R.id.setting_change_members_in_ngo_family);
        status = findViewById(R.id.setting_change_status);

        if (viewFragment.equalsIgnoreCase("Donor")) {
            viewVisibiltyDonor();
        } else if (viewFragment.equalsIgnoreCase("Needy")) {
            viewVisibiltyNeedy();
        } else if (viewFragment.equalsIgnoreCase("Volunteer")) {
            viewVisibiltyVolunteer();
        } else if (viewFragment.equalsIgnoreCase("Ngo")) {
            viewVisibiltyNgo();
        }
    }


    void viewVisibiltyDonor() {
        txtmembercount.setVisibility(View.GONE);
        txtngoname.setVisibility(View.GONE);
        emailid.setText(SignUpSingle.getInstance().getEmailID());
        emailid.setEnabled(false);
    }

    void viewVisibiltyNeedy() {
        txtmembercount.setVisibility(View.GONE);
        txtngoname.setVisibility(View.GONE);
        emailid.setText(SignUpSingle.getInstance().getEmailID());
        emailid.setEnabled(false);

    }

    void viewVisibiltyVolunteer() {
        txtmembercount.setVisibility(View.GONE);
        txtngoname.setVisibility(View.GONE);
        emailid.setText(SignUpSingle.getInstance().getEmailID());
        emailid.setEnabled(false);

    }

    void viewVisibiltyNgo() {
        txtmembercount.setVisibility(View.VISIBLE);
        txtngoname.setVisibility(View.VISIBLE);
        emailid.setText(SignUpSingle.getInstance().getEmailID());
        emailid.setEnabled(false);
    }


    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);
    }

    public void confirmButtonPressed(View view) {
        AlertDialog.Builder Builder = new AlertDialog.Builder(ProfileEditProfileActivity.this);
        View view_pop = getLayoutInflater().inflate(R.layout.popup_window_settings_changesettings_confirm, null);
        final Button confirm, cancel;
        confirm = view_pop.findViewById(R.id.editsettings_pop_btn_confirm);
        cancel = view_pop.findViewById(R.id.editsettings_pop_btn_reject);
        Builder.setView(view_pop);
        final Dialog dialog = Builder.create();
        dialog.show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(getApplicationContext(), BottomNavigationUsers.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //Update the data
                intent.putExtra("Fragment", fragmentName);
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