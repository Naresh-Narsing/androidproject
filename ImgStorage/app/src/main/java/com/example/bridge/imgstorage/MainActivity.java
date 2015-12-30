package com.example.bridge.imgstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    ImageView imageView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        db = this.openOrCreateDatabase("test.db", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists tb (a blob)");
    }


    public void saveImage(View view) {

        try {
            FileInputStream fis = new FileInputStream("/mnt/sdcard/Pictures/messi.jpg");
            byte[] image = new byte[fis.available()];
            fis.read(image);
            ContentValues values = new ContentValues();
            values.put("a",image);
            db.insert("tb", null, values);
            Toast.makeText(this,"Insert Success",Toast.LENGTH_LONG).show();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getImage(View view) {

        Cursor c = db.rawQuery("select * from tb", null);
        if(c.moveToNext()){
            byte[] img = c.getBlob(0);
            Bitmap bitmap = BitmapFactory.decodeByteArray(img,0,img.length );
            imageView.setImageBitmap(bitmap);
            Toast.makeText(this,"Select Success",Toast.LENGTH_LONG).show();
        }
    }
}
