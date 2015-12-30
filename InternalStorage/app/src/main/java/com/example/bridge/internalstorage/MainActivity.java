package com.example.bridge.internalstorage;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends ActionBarActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
    }


    public void WriteStorage(View view) {
        String Message = editText.getText().toString();
        String file_name = "hello_file";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            try {
                fileOutputStream.write(Message.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),"Message Saved",Toast.LENGTH_LONG).show();
                editText.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void ReadStorage(View view) {

        try {
            String Message;
            FileInputStream fileInputStream = openFileInput("hello_file");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            while ((Message = bufferedReader.readLine()) != null)
            {
                buffer.append(Message +"\n");
            }

            textView.setText(buffer.toString());
            textView.setVisibility(View.VISIBLE);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
