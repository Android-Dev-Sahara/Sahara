package com.daiict.internship.Sahara.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daiict.internship.Sahara.LoginSignUPDashboard.AppWorkDetails;
import com.daiict.internship.Sahara.LoginSignUPDashboard.LoginSignUpDashboard;
import com.daiict.internship.Sahara.ModelData.VolunteerModelData;
import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.SignUp.SelectionCategory;
import com.daiict.internship.Sahara.UserDashboard.BottomNavigationUsers;

import com.daiict.internship.Sahara.SignUp.SignUpSingle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    TextInputEditText email;
    TextInputEditText pass;
    Button loginBtn;
    String get_category;

    private FirebaseAuth mAuth;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        get_category = SignUpSingle.getInstance().getActor();
        Log.d("category",get_category);
        if(get_category.equalsIgnoreCase("volunteer")){
            ref= FirebaseDatabase.getInstance().getReference("Volunteer");
        }
        else if(get_category.equalsIgnoreCase("ngo"))
        {
            ref= FirebaseDatabase.getInstance().getReference("Ngo");
        }
        else if(get_category.equalsIgnoreCase("donar"))
        {
            ref= FirebaseDatabase.getInstance().getReference("Donar");
        }
        else if(get_category.equalsIgnoreCase("needy"))
        {
            ref= FirebaseDatabase.getInstance().getReference("Needy");
        }
    }

    public void loginBack(View view)
    {
        Intent intent = new Intent(Login.this, LoginSignUpDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
    public void loginForgotPassword(View view)
    {
        Intent intent = new Intent(Login.this, ForgotPassword.class);
        startActivity(intent);

    }
    public void loginLoginButton(View view)
    {
        email=findViewById(R.id.login_edit_username);
        pass=findViewById(R.id.login_edit_password);

        mAuth.signInWithEmailAndPassword(email.getText().toString(),pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    if(mAuth.getCurrentUser().isEmailVerified())
                    {
                        ref.child(mAuth.getUid()).child("userIsVerified").setValue("Yes");
                        //Go to the profile page of respective role...
                        Toast.makeText(Login.this,"Login Successful!!",Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(Login.this, BottomNavigationUsers.class);
                         startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Login.this,"Please verify your email address !",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {

                }
            }
        });


    }
    public void loginCreateAccount(View view)
    {
        Intent intent = new Intent(Login.this, SelectionCategory.class);
        startActivity(intent);
        finish();
    }
}
