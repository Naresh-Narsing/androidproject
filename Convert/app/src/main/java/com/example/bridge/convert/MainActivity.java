package com.example.bridge.convert;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    ImageView bitmapIV;
    ImageView drawableIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bitmapIV = (ImageView)findViewById(R.id.bitmap_iv);
        drawableIV = (ImageView)findViewById(R.id.drawable_iv);

        Drawable drawable = (this).getResources().getDrawable(R.drawable.ic_launcher);

        Bitmap bitmap =((BitmapDrawable)drawable).getBitmap();
        bitmapIV.setImageBitmap(bitmap);

        Drawable d = new BitmapDrawable(this.getResources(),bitmap);
        drawableIV.setImageDrawable(d);
    }


}
