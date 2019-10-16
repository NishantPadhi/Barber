package com.example.barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OMyListAdapter extends BaseAdapter {
    String[] customer_name,booking_date,scheduling_date;
    double[] payment_fees;
    LayoutInflater inflater;
    public OMyListAdapter(Context context, String[] customername, String[] booking_date, String[] scheduling_date,double[] paymentfees)
    {
        this.customer_name=customername;
        this.booking_date=booking_date;
        this.scheduling_date=scheduling_date;
        this.payment_fees=paymentfees;
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

    public View getView(int position, View view, ViewGroup viewGroup)
    {

        view=inflater.inflate(R.layout.custom_listowner,viewGroup,false);

        TextView customername=view.findViewById(R.id.customername);
        TextView booking=view.findViewById(R.id.bookdisplay);
        TextView schedule=view.findViewById(R.id.scheduledisplay);
        TextView payment=view.findViewById(R.id.paymentfees);

        customername.setText(customer_name[position]);
        booking.setText(booking_date[position]);
        schedule.setText(scheduling_date[position]);
        payment.setText(Double.toString(payment_fees[position])+" Rs.");
        return view;
    }
}
