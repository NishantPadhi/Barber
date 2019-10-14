package com.example.barber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Shop_details extends AppCompatActivity {
    static final int TIME_DIALOG_ID = 1111;
    public TextView view1,view2;
    private int ohr,chr,omin,cmin;
    String ampm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);
        Toolbar mToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setTitle("Barber");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        view1=(TextView)findViewById(R.id.openingtime);
        view2=(TextView)findViewById(R.id.closingtime);
        view1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Shop_details.this,R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay>=12)
                        {
                            hourOfDay-=12;
                            ampm="PM";
                        }
                        else
                        {
                            ampm="AM";
                        }
                        view1.setText(String.format("%02d:%02d",hourOfDay,minutes)+ampm);
                        //view1.setText(hourOfDay+":"+minutes);
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
        view2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Shop_details.this,R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if(hourOfDay>=12)
                        {
                            ampm="PM";
                            hourOfDay-=12;
                        }
                        else
                        {
                            ampm="AM";
                        }
                        view2.setText(String.format("%02d:%02d",hourOfDay,minutes)+ampm);
                        //view2.setText(hourOfDay+":"+minutes);
                    }
                }, 0, 0, true);
                timePickerDialog.show();
            }
        });
    }

    public void backToSignup(View view) {
        Intent i=new Intent(this,Signup_activity.class);
        startActivity(i);
    }

    public void homepage(View view) {
        Intent i=new Intent(this,Owner.class);
        startActivity(i);
    }
}
