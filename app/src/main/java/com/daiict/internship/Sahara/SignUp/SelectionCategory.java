package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.daiict.internship.Sahara.R;

public class SelectionCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_category);
    }

    public void categoryNeedy(View view) {
        Intent intent = new Intent(this,SignUpPage1.class);
        intent.putExtra("category","Needy");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryVolunteer(View view) {
        Intent intent = new Intent(this,SignUpPage1.class);
        intent.putExtra("category","Volunteer");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryNgo(View view) {
        Intent intent = new Intent(this,SignUpPage1.class);
        intent.putExtra("category","NGO");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryDonor(View view) {
        Intent intent = new Intent(this,SignUpPage1.class);
        intent.putExtra("category","Donor");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

}
