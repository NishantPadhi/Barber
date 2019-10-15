package com.example.barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CMyListAdapter extends ArrayAdapter<CAppointment> {
    List<CAppointment> cAppointmentList;

    Context context;

    int resource;

    public CMyListAdapter(Context context, int resource, List<CAppointment> cAppointmentList)
    {
        super(context,resource, cAppointmentList);
        this.context=context;
        this.resource=resource;
        this.cAppointmentList = cAppointmentList;
    }
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(resource,null,false);

        TextView saloonname=view.findViewById(R.id.saloonname);
        TextView booking=view.findViewById(R.id.bookdisplay);
        TextView schedule=view.findViewById(R.id.scheduledisplay);

        CAppointment cAppointment = cAppointmentList.get(position);

        saloonname.setText(cAppointment.getSaloonname());
        booking.setText(cAppointment.getBooking_date());
        schedule.setText(cAppointment.getScheduling_date());

        return view;
    }
}
