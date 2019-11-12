package com.example.barber;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_home ,container,false);
        TextView saloon=(TextView)view.findViewById(R.id.saloon);
        saloon.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getContext(),Booking.class);
        startActivity(intent);
    }
}
