package com.example.bridge.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz5 on 16/12/15.
 */
public class playeradapter extends ArrayAdapter {

    List list=new ArrayList();


    public playeradapter(Context context,int resource)

    {
        super(context,resource);
    }

    static class DataHandler{
        ImageView poster;
        TextView title;
        TextView rating;
    }



    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    public int getCount(){

        return this.list.size();
    }

    public Object getItem(int position){

        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        DataHandler handler;
        row=convertView;
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row =inflater.inflate(R.layout.model,parent,false);
            handler=new DataHandler();
            handler.poster=(ImageView)row.findViewById(R.id.imageview1);
            handler.title=(TextView)row.findViewById(R.id.teamtv);
            handler.rating=(TextView)row.findViewById(R.id.goalstv);
            row.setTag(handler);
            }
        else{
            handler=(DataHandler)row.getTag();
        }
        playerpicker dat;
        dat=(playerpicker)this.getItem(position);
        handler.poster.setImageResource(dat.getImages());
        handler.title.setText(dat.getTop_3_players());
        handler.rating.setText(dat.getGoals());
        return row;
    }
}
