package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;

import androidx.fragment.app.Fragment;

//import android.arch.lifecycle.Observer;
//import android.arch.lifecycle.ViewModelProviders;


public class DashboardFragment extends Fragment {

    private static DashboardFragment fragment;
    public static DashboardFragment newInstance() {

        Bundle args = new Bundle();
        if (fragment==null){
            fragment = new DashboardFragment();
        }

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);

        return root;
    }
}