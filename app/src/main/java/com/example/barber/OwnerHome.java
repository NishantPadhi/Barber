package com.example.barber;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OwnerHome extends Fragment implements View.OnClickListener {
    String[] Customer_name={"Nishant 1","Nishant 2","Nishant 3","Nishant 4","Nishant 5"};
    String[] booking_date={"5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"};
    String[] schedule_time={"5.30 PM","10.30 AM","7.30 PM","2.30 PM","3.30 PM"};
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_ownerhome ,container,false);

        ListView customList=view.findViewById(R.id.CustomerlistToday);
        ListAdapterToday listAdapterToday=new ListAdapterToday(getContext(),Customer_name,booking_date,schedule_time);
        customList.setAdapter(listAdapterToday);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
