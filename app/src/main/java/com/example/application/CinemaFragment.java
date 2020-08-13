package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CinemaFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cinema, container, false);

        //display image and text
        ImageView imageView = (ImageView) rootView.findViewById(R.id.cinemaImage);
        TextView textViewName = (TextView) rootView.findViewById(R.id.cinema_name);
        TextView textViewIntro = (TextView) rootView.findViewById(R.id.intro);
        TextView textViewDetail = (TextView) rootView.findViewById(R.id.intro_details);


        textViewName.setText("Cinema Name");
        imageView.setImageResource(R.drawable.meiqi);
        return rootView;
    }

}