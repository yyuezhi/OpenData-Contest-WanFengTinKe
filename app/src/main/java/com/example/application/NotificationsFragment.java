package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import androidx.core.app.Fragment;
//mport android.arch.lifecycle.Observer;
//import android.arch.lifecycle.ViewModelProviders;


//import com.movie.moviecomment.R;
//import com.movie.moviecomment.ui.home.HomeFragment;

public class NotificationsFragment extends Fragment {


    private static NotificationsFragment fragment;
    public static NotificationsFragment newInstance() {

        Bundle args = new Bundle();
        if (fragment==null){
            fragment = new NotificationsFragment();
        }

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);

        return root;
    }
}