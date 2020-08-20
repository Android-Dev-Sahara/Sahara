package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.daiict.internship.Sahara.IntroSlider.IntroSlider;
import com.daiict.internship.Sahara.R;

public class AboutUsCommonActivity extends AppCompatActivity {

    private String fragmentName;
    Button btn;
    Animation btn_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_common);
        fragmentName = getIntent().getStringExtra("Fragment");

        btn = findViewById(R.id.aboutus_backbutton);
        btn_animation = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        btn.setAnimation(btn_animation);
        btn.setVisibility(View.VISIBLE);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, ProfileSettingsAcitivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }

    public void backButtonPressed(View view) {
        Intent intent = new Intent(this, ProfileSettingsAcitivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment",fragmentName);
        startActivity(intent);
    }
}