package com.example.vizz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class MyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    public MyFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if(i == 0) {
            fragment = new FragmentA();
        }
        if(i == 1) {
            fragment = new FragmentB();
        }
        if(i == 2) {
            fragment = new FragmentC();
        }
        if(i == 3) {
            fragment = new FragmentD();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}