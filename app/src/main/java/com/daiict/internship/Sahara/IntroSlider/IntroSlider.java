package com.daiict.internship.Sahara.IntroSlider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daiict.internship.Sahara.R;

public class IntroSlider extends AppCompatActivity {


    ViewPager viewPager;
    LinearLayout layout_linear;

     //The class that we created
    SliderAdapter sliderAdapter;

    TextView[] dots_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);

        viewPager = findViewById(R.id.viewpager);
        layout_linear = findViewById(R.id.layout_linear_dots);

       //assigning values to the class constructor
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter) ;

        addDots(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }
    private void addDots(int position)
    {
        dots_tv = new TextView[4];
        layout_linear.removeAllViews();
        for(int i= 0 ; i<dots_tv.length;i++)
        {
            dots_tv[i] = new TextView(this);
            dots_tv[i].setText(Html.fromHtml("&#8226;"));
            dots_tv[i].setTextSize(35);

            layout_linear.addView(dots_tv[i]);
        }
        if(dots_tv.length >0)
        {
            dots_tv[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
