package com.example.bridge.whatsapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bridgelabz5 on 31/12/15.
 */
public class myfragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout=new LinearLayout(getActivity());
        TextView textView=new TextView(getActivity());
       // textView.setText("Search Is On");
        linearLayout.addView(textView);
        return linearLayout;
    }
}
