package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.daiict.internship.Sahara.IntroSlider.IntroSlider;
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
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.putExtra("category", "Needy");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryVolunteer(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.putExtra("category", "Volunteer");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryNgo(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.putExtra("category", "NGO");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void categoryDonor(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.putExtra("category", "Donor");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    private void btnAnimationView()
    {
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
