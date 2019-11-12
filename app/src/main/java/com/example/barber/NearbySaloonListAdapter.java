package com.example.barber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NearbySaloonListAdapter extends BaseAdapter {

    String[] saloon_name,avg_price,star;
    LayoutInflater layoutInflater;

    NearbySaloonListAdapter(Context context, String[] saloon_name, String[] avg_price, String[] star)
    {
        this.saloon_name=saloon_name;
        this.avg_price=avg_price;
        this.star=star;
        layoutInflater=(LayoutInflater.from(context));
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

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.activity_saloon_list,viewGroup,false);

        TextView saloonName=view.findViewById(R.id.saloonname);
        TextView price=view.findViewById(R.id.paymentfees);
        TextView starText=view.findViewById(R.id.star);

        saloonName.setText(saloon_name[position]);
        price.setText(avg_price[position]);
        starText.setText(star[position]);

        return view;
    }
}
