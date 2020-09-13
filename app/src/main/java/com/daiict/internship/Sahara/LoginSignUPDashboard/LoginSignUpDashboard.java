package com.daiict.internship.Sahara.LoginSignUPDashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.daiict.internship.Sahara.DataOperation.*;
import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SelectionCategory;
import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.daiict.internship.Sahara.UserDashboard.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginSignUpDashboard extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_dashboard);
        mAuth = FirebaseAuth.getInstance();

        //checkUserAlreadySignInOrNot();
    }

    private void checkUserAlreadySignInOrNot() {
        boolean isLoginSuccess = SharedPrefManager.getBooleanPrefVal(LoginSignUpDashboard.this, "isLoginOperSuccess");
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (isLoginSuccess && currentUser != null) {
            // Set Singleton data
            String userRole = SharedPrefManager.getPrefVal(LoginSignUpDashboard.this, SharedPrefManager.userRole);
            SignUpSingle.getInstance().setActor(userRole);
            Log.e("TAG", "checkUserAlreadySignInOrNot: " + SignUpSingle.getInstance().getActor());

            // User is Already Logged In
            Intent intent = new Intent(LoginSignUpDashboard.this, BottomNavigationUsers.class);
            intent.putExtra("Fragment","homefragment");
            startActivity(intent);
            finish();
        }
    }

    public void dashboardSignUp(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, SelectionCategory.class);
        startActivity(intent);
    }

    public void dashboardLogin(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, Login.class);
        Pair[] pairs = new Pair[1];

        //From here the transition that is popup effect will be generated if and only if the API version > 21
        pairs[0] = new Pair<View,String>(findViewById(R.id.btn_login_dashboard),"btn_login_transition");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginSignUpDashboard.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else
        {
            startActivity(intent);
            finish();
        }

    }

    public void dashboardHowWeWork(View view)
    {
        Intent intent = new Intent(LoginSignUpDashboard.this, AppWorkDetails.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
