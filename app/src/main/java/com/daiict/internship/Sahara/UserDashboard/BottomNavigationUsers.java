package com.daiict.internship.Sahara.UserDashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class BottomNavigationUsers extends AppCompatActivity {


    RelativeLayout relativeLayout_api23, relativeLayout_less;

    private String fragmentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_users);
        //This intent is used to get the data from the back button that is if user goes from fragment to another activity it should remain in the same activity back
        Intent intent = getIntent();
        if (intent != null)
            fragmentName = intent.getStringExtra("Fragment");

        //Need to create the Object to get the Instance of type of user he/she is


        //Assigned The Hooks
        relativeLayout_api23 = findViewById(R.id.bottom_nav_users_containers);
        relativeLayout_less = findViewById(R.id.bottom_nav_users_containers_lessapi);

        //IF The API level is greater then 23 that is marshmallow then chip navigation is called else the default navigation is called
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            relativeLayout_api23.setVisibility(View.VISIBLE);
            //The Default Home Fragment is called rest will be maintained by the method
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new HomeFragment()).commit();
            else if (fragmentName.equalsIgnoreCase("adddonorfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new AddDonorFragment()).commit();

            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NotificationsFragment()).commit();

            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new ProfileFragment()).commit();

            }
            bottomNavigationView();
        } else {
            relativeLayout_less.setVisibility(View.VISIBLE);
            //The Default Home Fragment is called rest will be maintained by the method

            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new HomeFragment()).commit();

            else if (fragmentName.equalsIgnoreCase("adddonorfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new AddDonorFragment()).commit();


            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NotificationsFragment()).commit();


            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new ProfileFragment()).commit();


            }


            bottomNavigationViewLesserAPI();
        }

    }

    //These Both functions are the listeners of the Bottom Navigation
    private void bottomNavigationViewLesserAPI() {
        final BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom_nav_users_material_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        fragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                        return true;

                    case R.id.bottom_nav_add:
                        fragment = new AddDonorFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                        return true;

                    case R.id.bottom_nav_notification:

                        fragment = new NotificationsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                        return true;


                    case R.id.bottom_nav_profile:
                        fragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                        return true;

                }


                return false;
            }
        });

    }

    private void bottomNavigationView() {
        final ChipNavigationBar chipNavigationBar;
        chipNavigationBar = findViewById(R.id.bottom_nav_users_chipnav);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottom_nav_home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.bottom_nav_add:
                        fragment = new AddDonorFragment();
                        break;

                    case R.id.bottom_nav_notification:
                        fragment = new NotificationsFragment();
                        break;

                    case R.id.bottom_nav_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, fragment).commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //On Back Press from this Activity the user should go back to the Apps Section of Phone
        //finishAffinity closes the Activity and clears the back stack;
        finishAffinity();
    }
}