package com.example.bridge.numberpick;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

    NumberPicker numberPicker=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker=(NumberPicker)findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        numberPicker.setWrapSelectorWheel(false);




        NumberPicker.OnValueChangeListener onValueChanged
                = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                NumberPicker[] np=new NumberPicker[3];
                np[0]=(NumberPicker)findViewById(R.id.numberPicker5);
                np[1]=(NumberPicker)findViewById(R.id.numberPicker4);
                np[2]=(NumberPicker)findViewById(R.id.numberPicker3);

                String temp="";
                for(int i=0;i<3;i++){
                    String[] values=np[i].getDisplayedValues();
                    temp=values[np[i].getValue()]+temp;
                }
                TextView tv=
                        (TextView) findViewById(R.id.textView);
                tv.setText(temp);
            }
        };


        String[] values=new String[10];
        for(int i=0;i<values.length;i++){
            values[i]=Integer.toString(i);
        }

        NumberPicker[] np=new NumberPicker[3];
        np[0]= (NumberPicker)
                findViewById(R.id.numberPicker5);
        np[1]= (NumberPicker)
                findViewById(R.id.numberPicker4);
        np[2]= (NumberPicker)
                findViewById(R.id.numberPicker3);
        for(int i=0;i<3;i++){
            np[i].setMaxValue(values.length-1);
            np[i].setMinValue(0);
            np[i].setDisplayedValues(values);
            np[i].setOnValueChangedListener(onValueChanged);
        }
    }
}






