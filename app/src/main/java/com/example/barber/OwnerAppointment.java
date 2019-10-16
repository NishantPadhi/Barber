package com.example.barber;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OwnerAppointment extends Fragment
{
    String[] Customer_name={"Nishant 1","Nishant 2","Nishant 3","Nishant 4","Nishant 5"};
    String[] booking_date={"5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"};
    String[] schedule_date={"5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"};
    double[] payment_fees={500,500,650,645.57,123};
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_ownerappointment ,container,false);

        ListView customList=view.findViewById(R.id.CustomerlistOwner);
        OMyListAdapter oMyListAdapter=new OMyListAdapter(getContext(),Customer_name,booking_date,schedule_date,payment_fees);
        customList.setAdapter(oMyListAdapter);
        return view;
    }
}
