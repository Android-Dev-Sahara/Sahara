package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class ProfileSettingContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting_contact_us);
    }

    public void mailMe(View view) {
        Log.e("mail","sendEmail");
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"address@mail.com"} );
        startActivity(Intent.createChooser(intent,"Choose Gmail To Contact Us!"));
    }
}