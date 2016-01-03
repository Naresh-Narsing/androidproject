package com.example.bridge.whatsapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bridgelabz5 on 3/1/16.
 */
public class First extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        submit();
    }

    private void submit() {
        Button sub = (Button)findViewById(R.id.submits);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent submits = new Intent(getApplicationContext(),submts.class);
                startActivity(submits);
            }
        });
    }
}
