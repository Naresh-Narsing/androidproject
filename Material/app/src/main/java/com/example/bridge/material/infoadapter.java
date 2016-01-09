package com.example.bridge.material;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by bridgelabz5 on 8/1/16.
 */
public class infoadapter extends RecyclerView.Adapter<infoadapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<Information> data = Collections.emptyList();
    Context context;



    public infoadapter(Context context,List<Information> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
       View view = inflater.inflate(R.layout.customrow, parent, false);
        Log.d("Hie","onCreateHolder called");
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current = data.get(position);
        Log.d("Hie","onBindViewHolder called "+position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);
       /* holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"item Clicked at "+position,Toast.LENGTH_LONG).show();

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"item Clicked at "+getPosition(),Toast.LENGTH_LONG).show();
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_out_right);
            icon.startAnimation(animation);
            delete(getPosition());

        }
    }
}
