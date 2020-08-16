package com.daiict.internship.Sahara.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daiict.internship.Sahara.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SelectForgotPassMethod extends AppCompatActivity {

    TextView mail;
    String user_email;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_forgot_pass_method);

        auth=FirebaseAuth.getInstance();

        mail=(TextView) findViewById(R.id.mail_description);
        Intent intent=getIntent();
        user_email=intent.getStringExtra("registered_email");
        Log.e("email",user_email);
        mail.setText(user_email);
    }

    public void verifyVia_Email(View view)
    {
                auth.sendPasswordResetEmail(user_email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                       Toast.makeText(SelectForgotPassMethod.this,"Password Reset email sent.",Toast.LENGTH_SHORT).show();
                       finish();
                        Intent intent = new Intent(SelectForgotPassMethod.this, Login.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(SelectForgotPassMethod.this,"Error in sending password Reset!",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
    }
    public void otpVerify(View view)
    {
        Intent intent = new Intent(SelectForgotPassMethod.this, VerifyOTP.class);
        startActivity(intent);
    }
    public void back_btn_of_selection(View view) {
        Intent intent = new Intent(SelectForgotPassMethod.this, ForgotPassword.class);
        startActivity(intent);
    }
}