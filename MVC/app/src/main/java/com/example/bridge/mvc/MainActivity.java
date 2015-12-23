package com.example.bridge.mvc;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private static SeekBar sb1;
    private static TextView text1;
    private CheckBox c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Seebbar();
        Checkbox();
    }


    public void Seebbar()
    {
        sb1=(SeekBar)findViewById(R.id.sb);
        text1=(TextView)findViewById(R.id.tv);
        text1.setText(sb1.getProgress() + "/" + sb1.getMax());

       sb1.setOnSeekBarChangeListener(
               new OnSeekBarChangeListener() {
                   int progress_value;

                   @Override

                   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                       progress_value = progress;
                       text1.setText("volume" + progress + "/" + sb1.getMax());
                       Toast.makeText(MainActivity.this, "Seekbar in progress", Toast.LENGTH_SHORT).show();

                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {
                       Toast.makeText(MainActivity.this, "Seekbar in progress", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {
                       text1.setText("volume" + progress_value + "/" + sb1.getMax());
                       Toast.makeText(MainActivity.this, "Seekbar in progress", Toast.LENGTH_SHORT).show();
                   }
               }
       );
    }



    public void Checkbox()
    {
        c1=(CheckBox)findViewById(R.id.cb);

        c1.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked())
                        {
                            sb1.setEnabled(false);
                        }
                        else
                        {
                            sb1.setEnabled(true);
                        }
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
