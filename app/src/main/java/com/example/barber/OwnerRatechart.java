package com.example.barber;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OwnerRatechart extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_ratechart,container,false);
        return view;
    }
}
