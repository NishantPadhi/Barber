package com.example.barber;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ownerSignup extends AppCompatActivity {
    EditText first_name,last_name,number,Email,Password,Gender,Link;
    Button btn_next;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;
    private final String LOG_TAG = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_signup);
        Toolbar mToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setTitle("Barber");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        firebaseAuth=firebaseAuth.getInstance();
        final FirebaseUser currentUser=firebaseAuth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference("Owner");

        first_name=(EditText)findViewById(R.id.fname);
        last_name=(EditText)findViewById(R.id.lname);
        number=(EditText)findViewById(R.id.Mnumber);
        Email=(EditText)findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.password);
        Gender=(EditText)findViewById(R.id.gender);
        Link=(EditText)findViewById(R.id.Website_link);
        btn_next=(Button)findViewById(R.id.next);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                final String fname=first_name.getText().toString().trim();
                final String lname=last_name.getText().toString().trim();
                final String mnumber=number.getText().toString().trim();
                final String email=Email.getText().toString().trim();
                final String password=Password.getText().toString().trim();
                final String gender=Gender.getText().toString().trim();
                final String link=Link.getText().toString().trim();

                if (TextUtils.isEmpty(fname)) {
                    Toast.makeText(getApplicationContext(), "Please enter your first name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(lname)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Last name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mnumber)) {
                    Toast.makeText(getApplicationContext(), "Please enter your mobile number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter your first name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Email-id", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Gender!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(link)) {
                    Toast.makeText(getApplicationContext(), "Please enter your Website!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (Password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.indexOf('@')<0)
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
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(ownerSignup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if(task.isSuccessful())
                                {
                                    ownerSingupFB info=new ownerSingupFB(fname,lname,mnumber,email,gender,link);
                                    FirebaseDatabase.getInstance().getReference("Owner")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(info)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    Toast.makeText(ownerSignup.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(),Shop_details.class));
                                                }
                                            });
                                }
                                else
                                {
                                    Toast.makeText(ownerSignup.this,"Registration failed!!! Try again",Toast.LENGTH_SHORT).show();
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

    public void shopdetails(View view) {
        Intent i=new Intent(this,Shop_details.class);
        startActivity(i);
    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
