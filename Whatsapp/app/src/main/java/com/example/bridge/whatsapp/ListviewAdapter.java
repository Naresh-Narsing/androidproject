package com.example.bridge.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bridgelabz5 on 3/1/16.
 */
public class ListviewAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;

    private static LayoutInflater inflater = null;
    public ListviewAdapter(MainActivity mainActivity,String[] prgmNameList, int[] prgmImages){
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {



        Holder holder=new Holder();

        View rowView;
        rowView = inflater.inflate(R.layout.custom,null);
        holder.tv=(TextView) rowView.findViewById(R.id.textview);
        holder.img=(ImageView) rowView.findViewById(R.id.image);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
