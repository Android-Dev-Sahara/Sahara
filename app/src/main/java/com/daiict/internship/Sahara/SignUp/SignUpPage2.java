package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.Login.Login;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpPage2 extends AppCompatActivity {

    TextInputEditText add1, add2;
    DatePicker dt;
    String get_category;

    TextView textView_title;
    Button btn_next;
    ImageView imageView_back;

    private String s_firstname, s_lname, s_emailid, s_password, s_ngoname, address1, address2, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2);
        fetchData();
        viewVisibility();

    }


    public void backBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category",get_category);
        startActivity(intent);
    }

    public void nextBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        intent.putExtra("FirstName", s_firstname);
        intent.putExtra("LastName", s_lname);
        intent.putExtra("EmailId", s_emailid);
        intent.putExtra("Password", s_password);
        intent.putExtra("ngoname", s_ngoname);
        intent.putExtra("Address1", address1);
        intent.putExtra("Address2", address2);
        intent.putExtra("DOB", dob);


        textView_title = findViewById(R.id.text_signup_second_title);
        btn_next = findViewById(R.id.btn_signup_second_next);
        imageView_back = findViewById(R.id.btn_signup_second_back);

        Pair[] pair_transition = new Pair[3];

        pair_transition[0] = new Pair<View, String>(imageView_back, "create_account_back_btn");
        pair_transition[1] = new Pair<View, String>(textView_title, "create_account_titile_text");
        pair_transition[2] = new Pair<View, String>(btn_next, "create_account_next_btn");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignUpPage2.this, pair_transition);
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }


    }

    private void fetchData() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");

        s_firstname = intent.getStringExtra("FirstName");
        s_lname = intent.getStringExtra("LastName");
        s_emailid = intent.getStringExtra("EmailId");
        s_password = intent.getStringExtra("Password");
        s_ngoname = intent.getStringExtra("ngoname");
        add1 = findViewById(R.id.edtxt_signup_second_address1);
        add2 = findViewById(R.id.edtxt_signup_second_address2);

        dt = findViewById(R.id.datepi_signup_second_age_year);

        address1 = add1.getText().toString();
        address2 = add2.getText().toString();
        int dd, mm, yy;
        dd = dt.getDayOfMonth();
        mm = dt.getMonth();
        yy = dt.getYear();

        dob = Integer.toString(dd);
        dob = dob + "/";
        dob = dob + Integer.toString(mm);
        dob = dob + "/";
        dob = dob + Integer.toString(yy);

    }


    private void viewVisibility() {
        Intent intent = getIntent();
        get_category = intent.getStringExtra("category");
        TextView textView_Age;
        textView_Age = findViewById(R.id.text_signup_second_age);

        if (get_category.equalsIgnoreCase("volunteer")) {

        } else if (get_category.equalsIgnoreCase("ngo")) {
            textView_Age.setText("Established Year ");
        } else if (get_category.equalsIgnoreCase("needy")) {

        } else {

        }
    }
}
