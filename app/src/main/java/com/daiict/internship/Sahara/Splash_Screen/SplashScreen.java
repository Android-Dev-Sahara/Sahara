package com.daiict.internship.Sahara.Splash_Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.IntroSlider.IntroSlider;
import com.daiict.internship.Sahara.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000;
    //above value is in milisecs

    //creating variable for animation
    Animation top,bottom;

    //Creating Objects of layouts
    ImageView imageView;
    TextView txtname,txttag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        top = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imageView);

        txtname = findViewById(R.id.txtname);
        txttag = findViewById(R.id.txttag);
        //Assigning animations
        imageView.setAnimation(top);
        txtname.setAnimation(bottom);
        txttag.setAnimation(bottom);

        //Lets give the timeout after which nextpage will be loaded;
        //Create a Handler
        //within run intent passed

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, IntroSlider.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}
