package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpPage1 extends AppCompatActivity {

    TextInputLayout textInputLayout_ngo;
    TextInputEditText fname, lname, emailid, password, ngo_name;
    TextView textView_title;

    Button btn_login, btn_next;
    ImageView imageView_back;


    String get_category;
    private String s_firstname, s_lname, s_emailid, s_password, s_ngoname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1);
        viewVisibility();


    }

    public void backBtnSignUpF(View view) {
        Intent intent = new Intent(this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    public void loginBtnSignUpF(View view) {
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void nextBtnSignUpF(View view) {
        Intent intent = new Intent(this, SignUpPage2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);

        //This signup page Data;
        intent.putExtra("FirstName", s_firstname);
        intent.putExtra("LastName", s_lname);
        intent.putExtra("EmailId", s_emailid);
        intent.putExtra("Password", s_password);
        intent.putExtra("ngoname", s_ngoname);

        //For Transitition Purpose
        textView_title = findViewById(R.id.text_signup_first_title);
        btn_login = findViewById(R.id.btn_signup_first_login);
        btn_next = findViewById(R.id.btn_signup_first_next);
        imageView_back = findViewById(R.id.btn_signup_first_back);

        Pair[] pair_transition = new Pair[4];

        pair_transition[0] = new Pair<View, String>(imageView_back, "create_account_back_btn");
        pair_transition[1] = new Pair<View, String>(textView_title, "create_account_titile_text");
        pair_transition[2] = new Pair<View, String>(btn_login, "create_account_Login_btn");
        pair_transition[3] = new Pair<View, String>(btn_next, "create_account_next_btn");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUpPage1.this, pair_transition);
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }


    }

    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");

        textInputLayout_ngo = findViewById(R.id.txtlayout_signup_first_ngo);


        if (get_category.equalsIgnoreCase("volunteer")) {

        } else if (get_category.equalsIgnoreCase("ngo")) {
            textInputLayout_ngo.setVisibility(View.VISIBLE);
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }

    private void fetchData() {
        fname = findViewById(R.id.txtv_signup_first_fname);
        lname = findViewById(R.id.txtv_signup_first_lname);
        emailid = findViewById(R.id.txtv_signup_first_email);
        password = findViewById(R.id.txtv_signup_first_pass);
        ngo_name = findViewById(R.id.txtv_signup_first_ngo);

        s_firstname = fname.getText().toString();
        s_lname = lname.getText().toString();
        s_emailid = emailid.getText().toString();
        s_password = password.getText().toString();
        s_ngoname = ngo_name.getText().toString();

    }

}
