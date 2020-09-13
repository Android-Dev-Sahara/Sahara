package com.daiict.internship.Sahara.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daiict.internship.Sahara.Login.*;
import com.daiict.internship.Sahara.LoginSignUPDashboard.*;
import com.daiict.internship.Sahara.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class SignUpPage1 extends AppCompatActivity {

    // Widgets....
    TextInputLayout textInputLayout_ngo;
    TextInputEditText fname, lname, emailid, password, ngo_name;
    TextView textView_title, textView_passwordMsg;
    Button btn_login, btn_next;
    ImageView imageView_back;

    // Data Containers
    private String get_category;
    private String s_firstname, s_lname, s_emailid, s_password, s_ngoname;

    // Pattern for Validation...
    private static final Pattern ALPHABET_ONLY = Pattern.compile("^[a-zA-Z ]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1);
        viewVisibility();

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().length() > 0 && !PASSWORD_PATTERN.matcher(password.getText().toString()).matches()) {
                    textView_passwordMsg.setText(getResources().getString(R.string.password_message));
                    textView_passwordMsg.setVisibility(View.VISIBLE);
                } else {
                    textView_passwordMsg.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

        // Validate all the Fields.....
        if (validateFirstName() && validateLastName() && validateEmailID() && validatePassword() && validateNGO()) {
            // If all the things right then Fetch the data
            fetchData();
            //This signup page Data;
            SignUpSingle.getInstance().setFirstName(s_firstname);
            SignUpSingle.getInstance().setLastName(s_lname);
            SignUpSingle.getInstance().setEmailID(s_emailid);
            SignUpSingle.getInstance().setAccPass(s_password);
            SignUpSingle.getInstance().setNgoName(s_ngoname);

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
    }

    private void viewVisibility() {
        // Starting Point.....
        get_category = SignUpSingle.getInstance().getActor();
        Log.e("viewVisibility: ", get_category);
        textInputLayout_ngo = findViewById(R.id.txtlayout_signup_first_ngo);
        fname = findViewById(R.id.txtv_signup_first_fname);
        lname = findViewById(R.id.txtv_signup_first_lname);
        emailid = findViewById(R.id.txtv_signup_first_email);
        password = findViewById(R.id.txtv_signup_first_pass);
        ngo_name = findViewById(R.id.txtv_signup_first_ngo);
        textView_passwordMsg = findViewById(R.id.txtPasswordMsg);

        if (get_category.equalsIgnoreCase("ngo")) {
            textInputLayout_ngo.setVisibility(View.VISIBLE);
        } else {
            textInputLayout_ngo.setVisibility(View.GONE);
        }
        // View Visibility End......
    }

    private void fetchData() {
        // Fetch the Data
        s_firstname = fname.getText().toString().trim();
        s_lname = lname.getText().toString().trim();
        s_emailid = emailid.getText().toString().trim();
        s_password = password.getText().toString();
        s_ngoname = (get_category.equalsIgnoreCase("ngo")) ? ngo_name.getText().toString().trim() : null;
    }

    private boolean validateFirstName() {
        String firstName = fname.getText().toString().trim();
        /*
         *If First Name is Empty or First Name contains not only Alphabets then return false
         * Else Return True
         */
        if (TextUtils.isEmpty(firstName)) {
            fname.setError("Enter First Name");
            return false;
        } else if (!ALPHABET_ONLY.matcher(firstName).matches()) {
            fname.setError("First Name contains only Alphabets");
            return false;
        } else {
            fname.setError(null);
            return true;
        }
    }

    private boolean validateLastName() {
        String lastName = lname.getText().toString().trim();
        /*
         *If Last Name is Empty or First Name contains not only Alphabets then return false
         * Else Return True
         */
        if (TextUtils.isEmpty(lastName)) {
            lname.setError("Enter Last Name");
            return false;
        } else if (!ALPHABET_ONLY.matcher(lastName).matches()) {
            lname.setError("Last Name contains only Alphabets");
            return false;
        } else {
            lname.setError(null);
            return true;
        }
    }

    private boolean validateEmailID() {
        String emailAddr = emailid.getText().toString().trim();
        /*
         * If Email Address is Empty or the given String is not in a Expression of General Email Address Format
         * then return false
         * else return true
         */
        if (TextUtils.isEmpty(emailAddr)) {
            emailid.setError("Enter Email Address");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddr).matches()) {
            emailid.setError("Email Address Should be Valid");
            return false;
        } else {
            emailid.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwrd = password.getText().toString();

        /*
         * If password isn't matches the given password format or expression then return false
         * Else return true
         */

        if (TextUtils.isEmpty(passwrd)) {
            textView_passwordMsg.setText(getResources().getString(R.string.empty_password));
            textView_passwordMsg.setVisibility(View.VISIBLE);
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwrd).matches()) {
            textView_passwordMsg.setText(getResources().getString(R.string.password_message));
            textView_passwordMsg.setVisibility(View.VISIBLE);
            return false;
        } else {
            textView_passwordMsg.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean validateNGO() {
        /*
         * NGO Name shouldn't be empty
         */

        String ngoName = ngo_name.getText().toString().trim();

        if ((!get_category.isEmpty()) && get_category.equalsIgnoreCase("ngo") && TextUtils.isEmpty(ngoName)) {
            ngo_name.setError("Enter Name of Organization");
            return false;
        } else {
            ngo_name.setError(null);
            return true;
        }
    }
}
