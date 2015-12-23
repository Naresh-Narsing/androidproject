package com.example.bridge.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap b = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        b.eraseColor(Color.RED);
        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setImageBitmap(b);

        Canvas c=new Canvas(b);
        Paint p=new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(6F);
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        c.drawLine(0F, 0F, 500F, 500F, p);

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        c.drawCircle(400F, 200F, 50F, p);

        p.setColor(Color.GREEN);
        c.drawRect(20F, 300F, 180F, 400F, p);

        p.setColor(Color.BLUE);
        p.setTextSize(50F);
        c.rotate(15F);
        c.drawText("Hello Graphics",0,14,90,80,p);







    }
}
