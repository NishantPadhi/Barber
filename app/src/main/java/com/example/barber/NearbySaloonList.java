package com.example.barber;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NearbySaloonList extends AppCompatActivity {
    String[] saloon_name;
    String[] avg_price;
    String[] rate;
    ArrayList<String> s_name,price,user_rating;
    double currentLongitude,currentLatitude;

    DatabaseReference databaseReferenceshop;
    FirebaseAuth firebaseAuth;

    TextView Nodata;
    public static int day_book,Month_book,Year_book,minute_book,hour_book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_saloon_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        firebaseAuth=firebaseAuth.getInstance();
        databaseReferenceshop= FirebaseDatabase.getInstance().getReference().child("Shopdetails");

        s_name=new ArrayList<>();
        price=new ArrayList<>();
        user_rating=new ArrayList<>();

        currentLatitude=getIntent().getDoubleExtra("latitude",25.6193885);
        currentLongitude=getIntent().getDoubleExtra("longitude",85.171428);
        day_book=getIntent().getIntExtra("date",0);
        Month_book=getIntent().getIntExtra("month",0);
        Year_book=getIntent().getIntExtra("year",0);
        minute_book=getIntent().getIntExtra("month",0);
        hour_book=getIntent().getIntExtra("year",0);

        databaseReferenceshop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren())
                {
                    double lat=Double.parseDouble(postSnapshot.child("latitude").getValue().toString().trim());
                    double lon=Double.parseDouble(postSnapshot.child("longitude").getValue().toString().trim());

                    float[] results=new float[1];

                    android.location.Location.distanceBetween(lat,lon,currentLatitude,currentLongitude,results);
                    float distance=results[0];

                    Log.e("Distance",Float.toString(distance));

                    if(distance<2000)
                    {

                        s_name.add(postSnapshot.child("name").getValue().toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        saloon_name=s_name.toArray(new String[s_name.size()]);

        for(int i=0;i<saloon_name.length;i++)
        {
            avg_price[i] = "80 Rs.";
            rate[i]="3.5 star";
        }
        Nodata=findViewById(R.id.Nodata);
        ListView saloonList = findViewById(R.id.NearbySaloonList);

        if(s_name.size()==0)
        {
            NearbySaloonListAdapter nearbySaloonListAdapter = new NearbySaloonListAdapter(getApplicationContext(), saloon_name, avg_price, rate);
            saloonList.setAdapter(nearbySaloonListAdapter);
            saloonList.setVisibility(View.GONE);
        }
        else
            {
                Nodata.setVisibility(View.GONE);
                saloonList.setVisibility(View.VISIBLE);

            NearbySaloonListAdapter nearbySaloonListAdapter = new NearbySaloonListAdapter(getApplicationContext(), saloon_name, avg_price, rate);
            saloonList.setAdapter(nearbySaloonListAdapter);
        }
    }

}
