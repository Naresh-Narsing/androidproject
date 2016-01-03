package com.example.bridge.whatsapp;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;

/**
 * Created by bridgelabz5 on 31/12/15.
 */
public class Chats extends ListFragment {
    public static String[] names = {"Aplam", "Baplam", "Chaplam", "Dhaplam"};
    public static int[] image = {R.drawable.ic_launcher, R.drawable.sanchezx, R.drawable.messi, R.drawable.messi};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        setListAdapter(new ListviewAdapter((MainActivity) getActivity(),names,image));
        return inflater.inflate(R.layout.defaults, container, false);

    }

        /*public Bitmap getRoundedShape (Bitmap image){
            int targetWidth = 50;
            int targetHeight = 50;
            image = BitmapFactory.decodeResource(getResources(),R.drawable.messi);
            Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

            Canvas canvas = new Canvas(targetBitmap);
            Path path = new Path();
            path.addCircle(((float) targetWidth - 1) / 2, ((float) targetHeight - 1) / 2, (Math.min(((float) targetWidth),
                            ((float) targetHeight)) / 2),
                    Path.Direction.CCW);

            canvas.clipPath(path);
            Bitmap sourceBitmap = image;
            canvas.drawBitmap(sourceBitmap,
                    new Rect(0, 0, sourceBitmap.getWidth(),
                            sourceBitmap.getHeight()),
                    new Rect(0, 0, targetWidth, targetHeight), null);


            return targetBitmap;
        }*/
    }

