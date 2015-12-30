package com.example.bridge.readwrite;

import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
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
        String state;
        state = Environment.getExternalStorageState();

        if(Environment.MEDIA_MOUNTED.equals(state)){

            File root = Environment.getExternalStorageDirectory();
            File dir = new File(root.getAbsolutePath()+"/My App File");

            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir,"My Msg.txt");
            String Message = editText.getText().toString();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(Message.getBytes());
                fileOutputStream.close();
                editText.setText("");
                Toast.makeText(getApplicationContext(),"Msg Saved",Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else{
            Toast.makeText(getApplicationContext(),"External Storage Not Found",Toast.LENGTH_LONG).show();

        }


    }

    public void ReadStorage(View view) {
        File root = Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath()+"/My App File");
        File file = new File(dir,"My Msg.txt");
        String Message;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            while ((Message = bufferedReader.readLine()) != null)
            {
                buffer.append(Message + "\n");

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
