package com.example.bridge.whatsapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private MenuItem myActionMenuItem;
    private AutoCompleteTextView myActionEditText;
    private ArrayAdapter<String> adapter;

    ViewPager pager;
    TabsPagerAdapter madapter;
    ActionBar actionbar;
    int position;
    String name[];

    ListView lv;
    //Context context;

    //ArrayList prgmName;


    // public static String [] names = {"Aplam","Baplam","Chaplam","Dhaplam"};
    //public static Integer [] image = {R.drawable.ic_launcher,R.drawable.sanchezx,R.drawable.messi,R.drawable.messi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        madapter = new TabsPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(madapter);

        actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionbar.addTab(actionbar.newTab().setText("Calls").setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText("Chats").setTabListener(this));
        actionbar.addTab(actionbar.newTab().setText("Contacts").setTabListener(this));
        actionbar.setSelectedNavigationItem(position);

        myActionEditText = (AutoCompleteTextView) findViewById(R.id.myActionEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        myActionMenuItem = menu.findItem(R.id.action_search);
        View actionView = myActionMenuItem.getActionView();

        if (actionView != null) {
            myActionEditText = (AutoCompleteTextView) actionView.findViewById(R.id.myActionEditText);

            if (myActionEditText != null) {
                String[] named = getResources().getStringArray(R.array.Name);

                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, named);

                myActionEditText.setAdapter(adapter);

                myActionEditText.setThreshold(1);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_search:

                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setId(100);
                setContentView(linearLayout);
                myfragment frag1 = new myfragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(100, frag1);
                ft.commit();
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
                return true;


            //default:

        }

        if (item.getItemId() == R.id.share)

        {
            Intent sharingintent = new Intent(Intent.ACTION_SEND);
            sharingintent.setType("text/plain");
            String stringtoshare = "Hi How are you";
            sharingintent.putExtra(Intent.EXTRA_TEXT, stringtoshare);
            startActivity(Intent.createChooser(sharingintent, "Share via"));
            return true;
        }
        else{
            if(item.getItemId() == R.id.status){
                Intent Firstactivityintent = new Intent(getApplicationContext(),First.class);
                startActivity(Firstactivityintent);
            }
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

       /* ada adapter = new ada(MainActivity.this, names, image);
        lv = (ListView) findViewById(R.id.List_view);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(MainActivity.this, "You Clicked at ", Toast.LENGTH_SHORT).show();
            }
        });*/


        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionbar.setSelectedNavigationItem(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*setContentView(R.layout.defaults);
        context = this;
        lv = (ListView)findViewById(R.id.List_view);
        lv.setAdapter(new ListviewAdapter(this, prgmNameList, prgmImages));*/
    }


}