package com.example.bridge.whatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bridgelabz5 on 31/12/15.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Calls();
            case 1:
                return new  Chats();
            case 2:
                return new Contacts();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}