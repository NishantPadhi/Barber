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
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_ownerappointment   ,container,false);


        String[] menuitems={"Hello World","Hello India","Hello Odisha","Hello Udala","Hello Nishanr"};

        ListView listView=(ListView) view.findViewById(R.id.Ownermylist);

        ArrayAdapter<String> listviewadapter= new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuitems
        );

        listView.setAdapter(listviewadapter);
        return view;
    }
}
