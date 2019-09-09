package com.example.chancharwei.android_monitorcamera.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.List;

public class AppFragmentPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = AppFragmentPageAdapter.class.getSimpleName()+"[ByronLog]";
    private List<Fragment> mFragmentList;
    public AppFragmentPageAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);
        mFragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        Log.i(TAG,"getItem position is "+position);
        return mFragmentList==null? null:mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        Log.i(TAG,"getCount is "+(mFragmentList==null? 0:mFragmentList.size()));
        return mFragmentList==null? 0:mFragmentList.size();
    }
}
