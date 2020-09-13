package com.daiict.internship.Sahara.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.daiict.internship.Sahara.R;
import com.daiict.internship.Sahara.LoginSignUPDashboard.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.Objects;

public class ForgotPassword extends AppCompatActivity {

    private TextInputEditText email;
    String user_email;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.forget_pass_email);

        auth = FirebaseAuth.getInstance();

    }

    public void verifyEmail_nextbtn(View view) {
        user_email = email.getText().toString().trim();
        if (user_email.equals("")) {
            Toast.makeText(this, "Please Enter Registered E-mail ID", Toast.LENGTH_SHORT).show();
        } else {
            auth.fetchSignInMethodsForEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                @Override
                public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                    if (task.getResult().getSignInMethods().size() == 0) {
                        Toast.makeText(ForgotPassword.this, "Email is not registered. Please Sign Up First!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPassword.this, Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ForgotPassword.this, "Email existed.", Toast.LENGTH_SHORT).show();
                        auth.sendPasswordResetEmail(user_email)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            View rootView = getWindow().getDecorView().getRootView();
                                            Snackbar resetMsg = Snackbar.make(rootView, "Password Reset email sent.", Snackbar.LENGTH_LONG);
                                            resetMsg.show();
                                            finish();
                                            Intent intent = new Intent(ForgotPassword.this, LoginSignUpDashboard.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(ForgotPassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                e.printStackTrace();
                                Log.e("onFailure: ", Objects.requireNonNull(e.getMessage()));
                            }
                        });
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    e.printStackTrace();
                }
            });

        }

    }


    public void back_btn(View view) {
        Intent intent = new Intent(ForgotPassword.this, Login.class);
        startActivity(intent);
    }


}
