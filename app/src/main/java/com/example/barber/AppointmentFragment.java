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
{   List<CAppointment> cAppointments;
    CMyListAdapter adapter;
    ListView listView;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_ownerappointment   ,container,false);

        cAppointments=new ArrayList<>();
        listView=view.findViewById(R.id.Customermylist);

        cAppointments.add(new CAppointment("Special Saloon1","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"));
        cAppointments.add(new CAppointment("Special Saloo2","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"));
        cAppointments.add(new CAppointment("Special Saloo3","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"));
        cAppointments.add(new CAppointment("Special Saloo4","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"));
        cAppointments.add(new CAppointment("Special Saloo5","5 SEP 2019 at 7.30 PM","5 SEP 2019 at 7.30 PM"));

        adapter=new CMyListAdapter(getActivity(),R.layout.custom_list,cAppointments);
        listView.setAdapter(adapter);
        return view;
    }
}
