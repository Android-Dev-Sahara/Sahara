package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.daiict.internship.Sahara.R;

public class SelectionCategory extends AppCompatActivity {

    Animation btn_Animation;
    ImageView needy,ngo,donor,volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_category);
        btnAnimationView();
    }

    public void categoryNeedy(View view) {
        // Actor: Needy Person
        Intent intent = new Intent(this, SignUpPage1.class);
        SignUpSingle.getInstance().setActor("Needy");       // Singleton Usage
        startActivity(intent);
        finish();
    }

    public void categoryVolunteer(View view) {
        // Actor: Volunteer
        Intent intent = new Intent(this, SignUpPage1.class);
        SignUpSingle.getInstance().setActor("Volunteer");       // Singleton Usage
        startActivity(intent);
        finish();
    }

    public void categoryNgo(View view) {
        // Actor: NGO
        Intent intent = new Intent(this, SignUpPage1.class);
        SignUpSingle.getInstance().setActor("NGO");       // Singleton Usage
        startActivity(intent);
        finish();
    }

    public void categoryDonor(View view) {
        // Actor: Donor
        Intent intent = new Intent(this, SignUpPage1.class);
        SignUpSingle.getInstance().setActor("Donor");       // Singleton Usage
        startActivity(intent);
        finish();

    }

    private void btnAnimationView()
    {
        // Starting Function of the Activity...
        // Binding UI Widgets..
        needy = findViewById(R.id.category_imgv_needy);
        ngo = findViewById(R.id.category_imgv_ngo);
        volunteer = findViewById(R.id.category_imgv_volunteer);
        donor = findViewById(R.id.category_imgv_donor);

        btn_Animation = AnimationUtils.loadAnimation(SelectionCategory.this, R.anim.side_animation);
        needy.setAnimation(btn_Animation);
        ngo.setAnimation(btn_Animation);
        volunteer.setAnimation(btn_Animation);
        donor.setAnimation(btn_Animation);
    }
}
