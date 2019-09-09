package com.example.chancharwei.android_monitorcamera.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chancharwei.android_monitorcamera.R;

public class MonitorFragment extends Fragment {
    private static final String TAG = MonitorFragment.class.getSimpleName()+"[ByronLog]";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView");
        View root = inflater.inflate(R.layout.fragment_monitor, container, false);
        return root;
    }
}
