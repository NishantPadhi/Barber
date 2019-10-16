package com.example.barber;


import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentFragment extends Fragment
{
    String[] salon_name={"Special Saloon1","Special Saloon2","Special Saloon3","Special Saloon4","Special Saloon5"};
    String[] booking_date={"5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"};
    String[] schedule_date={"5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_appointment   ,container,false);

        ListView customList=view.findViewById(R.id.Customerlist);
        CMyListAdapter cMyListAdapter=new CMyListAdapter(getContext(),salon_name,booking_date,schedule_date);
        customList.setAdapter(cMyListAdapter);
        return view;
    }
}
