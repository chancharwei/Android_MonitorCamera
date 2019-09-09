package com.example.chancharwei.android_monitorcamera;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.chancharwei.android_monitorcamera.adapter.AppFragmentPageAdapter;
import com.example.chancharwei.android_monitorcamera.fragments.CameraFragment;
import com.example.chancharwei.android_monitorcamera.fragments.HomeFragment;
import com.example.chancharwei.android_monitorcamera.fragments.MonitorFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getSimpleName()+"[ByronLog]";
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private Fragment mHomeFragment,mCameraFragment,mMonitorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.view_pager);

        mHomeFragment = new HomeFragment();
        mCameraFragment = new CameraFragment();
        mMonitorFragment = new MonitorFragment();
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mHomeFragment);
        mFragmentList.add(mCameraFragment);
        mFragmentList.add(mMonitorFragment);

        mViewPager.setAdapter(new AppFragmentPageAdapter(getSupportFragmentManager(),mFragmentList));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int page) {
                Log.i(TAG,"onPageSelected select "+page);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }



}
