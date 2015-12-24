package com.example.bridge.downloadnotificatn;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displaynotification(View view)
    {
        final NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        final int notify_id=1;
        final NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        builder.setSmallIcon(R.drawable.down);
        builder.setContentTitle("Download Status...");
        builder.setContentText("Download in progress");



        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for(i=0; i<=100; i+=5){

                    builder.setProgress(100,i,false);
                    nm.notify(notify_id, builder.build());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                    builder.setProgress(0,0,false);
                builder.setContentText("Download Complete...");
                nm.notify(notify_id,builder.build());

            }
        }).start();
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
}
