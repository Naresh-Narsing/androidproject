package com.example.bridge.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    ListView lv;
    String[] Top_3_players;
    String[] goals;
    int[] images={R.drawable.messi,R.drawable.neymar,R.drawable.sanchezx};
    playeradapter play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(android.R.id.list);
        Top_3_players=getResources().getStringArray(R.array.Top_3_players);
        goals=getResources().getStringArray(R.array.goals);
        lv.setAdapter(play);
        int i=0;
        play=new playeradapter(getApplicationContext(),R.layout.model);

        for(String titles:Top_3_players)
        {
            playerpicker dd=new playerpicker(images[i],goals[i],titles);
            play.add(dd);
            i++;

        }

    }




}
