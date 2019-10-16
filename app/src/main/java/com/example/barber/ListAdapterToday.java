package com.example.barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapterToday extends BaseAdapter {
    String[] customer_name,booking_date,scheduling_time;
    LayoutInflater inflater;
    ListAdapterToday(Context context, String[] customername, String[] booking_date, String[] scheduling_time)
    {
        this.customer_name=customername;
        this.booking_date=booking_date;
        this.scheduling_time=scheduling_time;
        inflater=(LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return customer_name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        view=inflater.inflate(R.layout.custom_listtoday,viewGroup,false);

        TextView customername=view.findViewById(R.id.customername);
        TextView booking=view.findViewById(R.id.bookdisplay);
        TextView schedule=view.findViewById(R.id.scheduledisplay);


        customername.setText(customer_name[position]);
        booking.setText(booking_date[position]);
        schedule.setText(scheduling_time[position]);

        return view;
    }
}
