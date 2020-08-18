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
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class BottomNavigationUsers extends AppCompatActivity {

    //Donor
    //NGO
    //Needy
    //Volunteer

    RelativeLayout relativeLayout_api23, relativeLayout_less;

    private String fragmentName;
    String fragmentype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_users);
        fragmentype = SignUpSingle.getInstance().getActor();

        //This intent is used to get the data from the back button that is if user goes from fragment to another activity it should remain in the same activity back
        Intent intent = getIntent();
        if (intent != null)
            fragmentName = intent.getStringExtra("Fragment");



        //Assigned The Hooks
        relativeLayout_api23 = findViewById(R.id.bottom_nav_users_containers);
        relativeLayout_less = findViewById(R.id.bottom_nav_users_containers_lessapi);

        //IF The API level is greater then 23 that is marshmallow then chip navigation is called else the default navigation is called
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            relativeLayout_api23.setVisibility(View.VISIBLE);
            //The Default Home Fragment is called rest will be maintained by the method
            typeOfCallBackLargerAPI();
            bottomNavigationView();
        }
        else {
            relativeLayout_less.setVisibility(View.VISIBLE);
            //The Default Home Fragment is called rest will be maintained by the method
            typeOfCallBackLesserAPI();
            bottomNavigationViewLesserAPI();
        }

    }



    //These Both functions are the listeners of the Bottom Navigation
    private void bottomNavigationViewLesserAPI() {
        final BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottom_nav_users_material_navigation);
        if(fragmentype.equalsIgnoreCase("Needy"))
        {

            bottomNavigationView.inflateMenu(R.menu.bottom_nav_needy_menubar);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottom_nav_needy_home:
                            fragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_needy_request:
                            fragment = new NeedyFoodRequestFormFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_needy_notification:

                            fragment = new NotificationsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;


                        case R.id.bottom_nav_needy_profile:
                            fragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                    }


                    return false;
                }
            });

        }
        else if(fragmentype.equalsIgnoreCase("NGO"))
        {
            bottomNavigationView.inflateMenu(R.menu.bottom_nav_ngo_menubar);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottom_nav_ngo_home:
                            fragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_ngo_recent_donations:
                            fragment = new RecentDonationsNGOFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_ngo_notification:

                            fragment = new NotificationsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;


                        case R.id.bottom_nav_ngo_profile:
                            fragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                    }


                    return false;
                }
            });
        }
        else if(fragmentype.equalsIgnoreCase("Volunteer"))
        {
            bottomNavigationView.inflateMenu(R.menu.bottom_nav_volunteer_menubar);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottom_nav_volunteer_home:
                            fragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_volunteer_order:
                            fragment = new OrdersVoulnteerFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_volunteer_notification:

                            fragment = new NotificationsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;


                        case R.id.bottom_nav_volunteer_profile:
                            fragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                    }


                    return false;
                }
            });
        }
        else if(fragmentype.equalsIgnoreCase("Donor"))
        {
            bottomNavigationView.inflateMenu(R.menu.bottom_nav_donor_menubar);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottom_nav_donor_home:
                            fragment = new HomeFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_donor_add:
                            fragment = new AddDonorFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                        case R.id.bottom_nav_donor_notification:

                            fragment = new NotificationsFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;


                        case R.id.bottom_nav_donor_profile:
                            fragment = new ProfileFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, fragment).commit();
                            return true;

                    }


                    return false;
                }
            });
        }


    }

    private void bottomNavigationView() {
        final ChipNavigationBar chipNavigationBar;
        chipNavigationBar = findViewById(R.id.bottom_nav_users_chipnav);
        if(fragmentype.equalsIgnoreCase("Needy"))
        {
            chipNavigationBar.setMenuResource(R.menu.bottom_nav_needy_menubar);
            chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
                @Override
                public void onItemSelected(int i) {
                    Fragment fragment = null;
                    switch (i) {
                        case R.id.bottom_nav_needy_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.bottom_nav_needy_request:
                            fragment = new NeedyFoodRequestFormFragment();
                            break;

                        case R.id.bottom_nav_needy_notification:
                            fragment = new NotificationsFragment();
                            break;

                        case R.id.bottom_nav_needy_profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, fragment).commit();
                }
            });
        }
        else if(fragmentype.equalsIgnoreCase("NGO"))
        {
            chipNavigationBar.setMenuResource(R.menu.bottom_nav_ngo_menubar);
            chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
                @Override
                public void onItemSelected(int i) {
                    Fragment fragment = null;
                    switch (i) {
                        case R.id.bottom_nav_ngo_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.bottom_nav_ngo_recent_donations:
                            fragment = new RecentDonationsNGOFragment();
                            break;

                        case R.id.bottom_nav_ngo_notification:
                            fragment = new NotificationsFragment();
                            break;

                        case R.id.bottom_nav_ngo_profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, fragment).commit();
                }
            });
        }
        else if(fragmentype.equalsIgnoreCase("Volunteer"))
        {
            chipNavigationBar.setMenuResource(R.menu.bottom_nav_volunteer_menubar);
            chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
                @Override
                public void onItemSelected(int i) {
                    Fragment fragment = null;
                    switch (i) {
                        case R.id.bottom_nav_volunteer_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.bottom_nav_volunteer_order:
                            fragment = new OrdersVoulnteerFragment();
                            break;

                        case R.id.bottom_nav_volunteer_notification:
                            fragment = new NotificationsFragment();
                            break;

                        case R.id.bottom_nav_volunteer_profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, fragment).commit();
                }
            });
        }
        else if(fragmentype.equalsIgnoreCase("Donor"))
        {
            chipNavigationBar.setMenuResource(R.menu.bottom_nav_donor_menubar);
            chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
                @Override
                public void onItemSelected(int i) {
                    Fragment fragment = null;
                    switch (i) {
                        case R.id.bottom_nav_donor_home:
                            fragment = new HomeFragment();
                            break;

                        case R.id.bottom_nav_donor_add:
                            fragment = new AddDonorFragment();
                            break;

                        case R.id.bottom_nav_donor_notification:
                            fragment = new NotificationsFragment();
                            break;

                        case R.id.bottom_nav_donor_profile:
                            fragment = new ProfileFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, fragment).commit();
                }
            });
        }


    }

    //These two methods are for coming back to the navigation bar and getting back to the same page
    private void typeOfCallBackLargerAPI(){
        if(fragmentype.equalsIgnoreCase("Needy"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new HomeFragment()).commit();
            else if (fragmentName.equalsIgnoreCase("needyFoodRequestFormFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NeedyFoodRequestFormFragment()).commit();

            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NotificationsFragment()).commit();

            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new ProfileFragment()).commit();

            }
        }
        else if(fragmentype.equalsIgnoreCase("NGO"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new HomeFragment()).commit();
            else if (fragmentName.equalsIgnoreCase("RecentDonationsNGOFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new RecentDonationsNGOFragment()).commit();

            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NotificationsFragment()).commit();

            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new ProfileFragment()).commit();

            }
        }
        else if(fragmentype.equalsIgnoreCase("Volunteer"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new HomeFragment()).commit();
            else if (fragmentName.equalsIgnoreCase("OrdersVoulnteerFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new OrdersVoulnteerFragment()).commit();

            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NotificationsFragment()).commit();

            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new ProfileFragment()).commit();

            }
        }
        else if(fragmentype.equalsIgnoreCase("Donor"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new HomeFragment()).commit();
            else if (fragmentName.equalsIgnoreCase("adddonorfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new AddDonorFragment()).commit();

            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new NotificationsFragment()).commit();

            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers, new ProfileFragment()).commit();

            }
        }

    }

    private void typeOfCallBackLesserAPI() {
        if(fragmentype.equalsIgnoreCase("Needy"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new HomeFragment()).commit();

            else if (fragmentName.equalsIgnoreCase("needyFoodRequestFormFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NeedyFoodRequestFormFragment()).commit();


            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NotificationsFragment()).commit();


            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new ProfileFragment()).commit();


            }
        }
        else if(fragmentype.equalsIgnoreCase("NGO"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new HomeFragment()).commit();

            else if (fragmentName.equalsIgnoreCase("RecentDonationsNGOFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new RecentDonationsNGOFragment()).commit();


            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NotificationsFragment()).commit();


            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new ProfileFragment()).commit();


            }
        }
        else if(fragmentype.equalsIgnoreCase("Volunteer"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new HomeFragment()).commit();

            else if (fragmentName.equalsIgnoreCase("OrdersVoulnteerFragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new OrdersVoulnteerFragment()).commit();


            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NotificationsFragment()).commit();


            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new ProfileFragment()).commit();


            }
        }
        else if(fragmentype.equalsIgnoreCase("Donor"))
        {
            if (fragmentName.equalsIgnoreCase("Homefragment"))
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new HomeFragment()).commit();

            else if (fragmentName.equalsIgnoreCase("adddonorfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new AddDonorFragment()).commit();


            } else if (fragmentName.equalsIgnoreCase("notificationsfragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new NotificationsFragment()).commit();


            } else {
                getSupportFragmentManager().beginTransaction().replace(R.id.bottom_nav_users_containers_lessapi, new ProfileFragment()).commit();


            }
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //On Back Press from this Activity the user should go back to the Apps Section of Phone
        //finishAffinity closes the Activity and clears the back stack;
        finishAffinity();
    }
}