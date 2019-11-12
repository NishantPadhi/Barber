package com.example.barber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaloonDeatils extends AppCompatActivity {

    Button booking;
    TextView saloon;
    String saloonName,AMPM;
    int date,month,year,minute,hour;
    DatabaseReference databaseReferenceshop;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saloon_deatils);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        date=NearbySaloonList.day_book;
        month=NearbySaloonList.Month_book;
        year=NearbySaloonList.Year_book;
        minute=NearbySaloonList.minute_book;
        hour=NearbySaloonList.hour_book;
        AMPM=Booking.ampm;

        databaseReferenceshop= FirebaseDatabase.getInstance().getReference().child("Booking");

        booking=findViewById(R.id.BookSlot);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
