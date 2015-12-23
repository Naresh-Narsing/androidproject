package com.example.bridge.timepicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    TimePicker timePicker;
    Button b1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Showtime();
    }

    public void Showtime()
    {
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        b1=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        //timePicker.setIs24HourView(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),timePicker.getCurrentHour()+":"+
                               timePicker.getCurrentMinute(),
                                Toast.LENGTH_SHORT).show();
                textView.setText(timePicker.getCurrentHour().toString()+":"+timePicker.getCurrentMinute().toString());

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
}
