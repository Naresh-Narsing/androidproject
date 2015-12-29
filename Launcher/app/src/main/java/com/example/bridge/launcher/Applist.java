package com.example.bridge.launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgelabz5 on 29/12/15.
 */
public class Applist extends Activity {

    //manager
    private PackageManager manager;

    //store list of apps
    private List<Appinfo> apps;
    private ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        loadApps();
        loadListview();
        addClickListener();

    }

    private void addClickListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = manager.getLaunchIntentForPackage(apps.get(position).name.toString());
                Applist.this.startActivity(i);
            }
        });
    }

    private void loadListview(){
        list = (ListView)findViewById(R.id.apps_list);

        ArrayAdapter<Appinfo> adapter = new ArrayAdapter<Appinfo>(this,R.layout.activity_list,apps){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolderitem viewHolder = null;

                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.list_item,parent,false);
                    viewHolder =new ViewHolderitem();
                    viewHolder.icon =(ImageView)convertView.findViewById(R.id.icon);
                    viewHolder.label = (TextView)convertView.findViewById(R.id.label);
                    viewHolder.name = (TextView)convertView.findViewById(R.id.name);

                    //store holder with view
                    convertView.setTag(viewHolder);

                }else {

                    //get saved holder
                    viewHolder = (ViewHolderitem)convertView.getTag();

                }

                Appinfo appinfo =apps.get(position);

                //display app info
                if(appinfo != null){
                    viewHolder.icon.setImageDrawable(appinfo.icon);
                    viewHolder.label.setText(appinfo.label);
                    viewHolder.name.setText(appinfo.name);
                }

                return convertView;
            }

            final class ViewHolderitem
            {
                ImageView icon;
                TextView label;
                TextView name;
            }
        };

        list.setAdapter(adapter);
    }




    private void loadApps(){
        manager = getPackageManager();
        apps = new ArrayList<Appinfo>();

        Intent i =new Intent(Intent.ACTION_MAIN,null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i,0);

        for (ResolveInfo r1 : availableActivities){
            Appinfo appinfo = new Appinfo();
            appinfo.label = r1.loadLabel(manager);
            appinfo.name = r1.activityInfo.packageName;
            appinfo.icon = r1.loadIcon(manager);
            apps.add(appinfo);
        }


    }
}






















