package com.example.bridge.swipedelete;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends Activity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    ArrayList<String> all_planets =
            new ArrayList<String>(){

                {
                    add("Mercury ");
                    add("Venus ");
                    add("Earth");
                    add("Mars");
                    add("Jupiter");
                    add("Saturn");
                    add("Uranus");
                    add("Neptune");
                    add("Pluto");
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById( R.id.mainListView );
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, all_planets);

        mainListView.setAdapter(listAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View rowView, int positon,long id) {
                Toast.makeText(rowView.getContext(), ""+positon, Toast.LENGTH_LONG).show();
                removeListItem(rowView,positon);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void removeListItem(View rowView, final int positon) {


        final Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        rowView.startAnimation(animation);
        /*Handler handle = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };*/
        mainListView.postDelayed(new Runnable() {
            @Override
            public void run() {
                all_planets.remove(positon);
                listAdapter.notifyDataSetChanged();
                animation.cancel();
            }
        },1000);
            }





}
