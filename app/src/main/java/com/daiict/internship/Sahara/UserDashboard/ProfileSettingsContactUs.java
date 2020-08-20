package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class ProfileSettingsContactUs extends AppCompatActivity {

    private String fragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings_contact_us);
        fragmentName = getIntent().getStringExtra("Fragment");
    }

    public void mailMe(View view) {
        Log.e("mail","sendEmail");
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"address@mail.com"} );
        startActivity(Intent.createChooser(intent,"Choose Gmail To Contact Us!"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ProfileSettingsAcitivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }
}