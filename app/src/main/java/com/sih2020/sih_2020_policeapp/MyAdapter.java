package com.sih2020.sih_2020_policeapp;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                NearbySOS nearbySOS = new NearbySOS();
                return nearbySOS;
            case 1:
                MarkPosition markPosition = new MarkPosition();
                return markPosition;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}