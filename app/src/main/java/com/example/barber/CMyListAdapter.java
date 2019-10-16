package com.example.barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CMyListAdapter extends BaseAdapter {
    String[] saloon_name,booking_date,scheduling_date;

    LayoutInflater inflater;
    public CMyListAdapter(Context context,String[] saloonname,String[] booking_date,String[] scheduling_date)
    {
        this.saloon_name=saloonname;
        this.booking_date=booking_date;
        this.scheduling_date=scheduling_date;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return saloon_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position,View view,ViewGroup viewGroup)
    {

        view=inflater.inflate(R.layout.custom_list,viewGroup,false);

        TextView saloonname=view.findViewById(R.id.saloonname);
        TextView booking=view.findViewById(R.id.bookdisplay);
        TextView schedule=view.findViewById(R.id.scheduledisplay);

        saloonname.setText(saloon_name[position]);
        booking.setText(booking_date[position]);
        schedule.setText(scheduling_date[position]);

        return view;
    }
}
