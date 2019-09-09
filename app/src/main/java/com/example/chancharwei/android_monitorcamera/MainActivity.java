package com.example.chancharwei.android_monitorcamera;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.example.chancharwei.android_monitorcamera.adapter.AppFragmentPageAdapter;
import com.example.chancharwei.android_monitorcamera.fragments.CameraFragment;
import com.example.chancharwei.android_monitorcamera.fragments.HomeFragment;
import com.example.chancharwei.android_monitorcamera.fragments.MonitorFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = MainActivity.class.getSimpleName()+"[ByronLog]";
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private Fragment mHomeFragment,mCameraFragment,mMonitorFragment;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewPager();
        navigationView = findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        drawerToggle = setupDrawerToggle();
        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        // Tie DrawerLayout events to the ActionBarToggle
        mDrawer.addDrawerListener(drawerToggle);

        setTitle(navigationView.getMenu().getItem(0).getTitle());
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        mDrawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void setViewPager() {
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
                navigationView.getMenu().getItem(page).setChecked(true);
                bottomNavigationView.getMenu().getItem(page).setChecked(true);
                setTitle(navigationView.getMenu().getItem(page).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Byron need to add android:orderInCategory attribute in menu +++
        mViewPager.setCurrentItem(menuItem.getOrder());
        //Byron need to add android:orderInCategory attribute in menu ---
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
        return true;
    }
}
