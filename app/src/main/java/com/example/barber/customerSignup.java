package com.example.barber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class customerSignup extends AppCompatActivity {
    EditText First_Name,Last_Name,number,email,password,gender,referral;
    Button btn_Register;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;
    private final String LOG_TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        Toolbar mToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setTitle("Barber");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        firebaseAuth=FirebaseAuth.getInstance();
        final FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference("Customer");

        First_Name=(EditText)findViewById(R.id.Fname);
        Last_Name=(EditText)findViewById(R.id.Lname);
        number=(EditText)findViewById(R.id.number);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        gender=(EditText)findViewById(R.id.gender);
        referral=(EditText)findViewById(R.id.referral);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        btn_Register=(Button)findViewById(R.id.Register);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstname=First_Name.getText().toString().trim();
                final String lastname=Last_Name.getText().toString().trim();
                final String mnumber=number.getText().toString().trim();
                final String emailid=email.getText().toString().trim();
                String Password=password.getText().toString().trim();
                final String Gender=gender.getText().toString().trim();
                final String Referral=referral.getText().toString().trim();

                if (TextUtils.isEmpty(firstname)) {
                    Toast.makeText(getApplicationContext(), "Please enter your first name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(lastname)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Last name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mnumber)) {
                    Toast.makeText(getApplicationContext(), "Please enter your mobile number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(emailid)) {
                    Toast.makeText(getApplicationContext(), "Please enter your first name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(firstname)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Email-id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Gender)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Gender!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Referral)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Referral code!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(emailid.indexOf('@')<0)
                {
                    Toast.makeText(getApplicationContext(), "Please enter a valid Email-id!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mnumber.length()<10 || mnumber.length()>10)
                {
                    Toast.makeText(getApplicationContext(), "Please enter a valid Mobile Number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(int i=0;i<mnumber.length();i++)
                {
                    char ch=mnumber.charAt(i);
                    if(ch<'0'|| ch>'9')
                    {
                        Toast.makeText(getApplicationContext(), "Please enter a valid Mobile Number!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(emailid,Password)
                        .addOnCompleteListener(customerSignup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful())
                                {
                                    Customer information=new Customer(firstname,lastname,mnumber,emailid,Gender,Referral);
                                    FirebaseDatabase.getInstance().getReference("Customer")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(customerSignup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(),UserHomePage.class));
                                                }
                                            });
                                }
                                else
                                {
                                    //Toast.makeText(customerSignup.this,"Registration Failed"+task.getException(),Toast.LENGTH_LONG).show();
                                    Toast.makeText(customerSignup.this,"Registration failed!!! Try again",Toast.LENGTH_SHORT).show();
                                    Log.i(LOG_TAG, task.getException().toString());
                                }
                            }
                        });
            }
        });
    }

    public void backToSignup(View view) {
        Intent i=new Intent(this,Signup_activity.class);
        startActivity(i);
    }

    public void homepage(View view) {
        Intent i=new Intent(this,UserHomePage.class);
        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
