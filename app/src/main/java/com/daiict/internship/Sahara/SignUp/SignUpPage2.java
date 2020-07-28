package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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

import java.util.Calendar;
import java.util.Date;

public class SignUpPage2 extends AppCompatActivity {

    TextInputEditText add1, add2;
    DatePicker dt;
    String get_category;

    TextView textView_title, textView_invalidDate;
    Button btn_next;
    ImageView imageView_back;

    private String address1, address2, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2);
        viewVisibility();
    }


    public void backBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("category", get_category);
        startActivity(intent);
    }

    public void nextBtnSignUpS(View view) {
        Intent intent = new Intent(this, SignUpPage3.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        if (validateAddress() && validateDate()) {
            fetchData();
            // Store in Singleton Class....
            SignUpSingle.getInstance().setAddressLine1(address1);
            SignUpSingle.getInstance().setAddressLine2(address2);
            SignUpSingle.getInstance().setDateOfBirth_Establishment(dob);

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
    }

    private void fetchData() {
        address1 = add1.getText().toString();
        address2 = add2.getText().toString();
        int dd, mm, yy;
        dd = dt.getDayOfMonth();
        mm = dt.getMonth();
        yy = dt.getYear();

        dob = Integer.toString(dd);
        dob = dob + "/";
        dob = dob + mm;
        dob = dob + "/";
        dob = dob + yy;
    }

    private void viewVisibility() {
        get_category = SignUpSingle.getInstance().getActor();
        TextView textView_Age;
        textView_Age = findViewById(R.id.text_signup_second_age);
        add1 = findViewById(R.id.edtxt_signup_second_address1);
        add2 = findViewById(R.id.edtxt_signup_second_address2);
        dt = findViewById(R.id.datepi_signup_second_age_year);
        textView_invalidDate = findViewById(R.id.invalid_date);

        if (get_category.equalsIgnoreCase("ngo")) {
            textView_Age.setText(getResources().getString(R.string.estalbished_year));
        } else {
            textView_Age.setText(getResources().getString(R.string.birthdate_selection));
        }
    }

    private boolean validateAddress() {
        // Till We get the Address from User, Afterwards we can get Fetch the Location Automatically
        String addressLine1 = add1.getText().toString().trim();
        String addressLine2 = add2.getText().toString().trim();

        if (addressLine1.isEmpty() && addressLine2.isEmpty()) {
            add1.setError("Please Enter Address");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateDate() {
        /*
        * Validate Date whether the input date is above than Current Date or year
        * (Not Yet Decided) Volunteer Age Validation: 18 Above
        * */
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int date = Calendar.getInstance().get(Calendar.DATE);

        int inputDate, inputMonth, inputYear;
        inputDate = dt.getDayOfMonth();
        inputMonth = dt.getMonth();
        inputYear = dt.getYear();

        if (inputYear > year) {
            textView_invalidDate.setVisibility(View.VISIBLE);
            return false;
        } else if (inputYear == year && inputMonth > month) {
            textView_invalidDate.setVisibility(View.VISIBLE);
            return false;
        } else if (inputYear == year && inputMonth == month && inputDate > date) {
            textView_invalidDate.setVisibility(View.VISIBLE);
            return false;
        } else {
            textView_invalidDate.setVisibility(View.GONE);
            return true;
        }

    }
}
