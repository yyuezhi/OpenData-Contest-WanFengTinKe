package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Cinema extends AppCompatActivity {

    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinema);

        //display image and text
        ImageView imageView = (ImageView) findViewById(R.id.cinemaImage);
        TextView textViewName = (TextView) findViewById(R.id.cinema_name);
        TextView textViewIntro = (TextView) findViewById(R.id.intro);
        TextView textViewDetail = (TextView) findViewById(R.id.intro_details);

        textViewName.setText(getIntent().getStringExtra("Cinema Name"));
        imageView.setImageResource(getIntent().getIntExtra("image",R.drawable.meiqi));

        //bottom navigation bar
        //bottom navigation
        bottomNav = findViewById(R.id.bottom_navigation_cinema);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(Cinema.this,MainActivity.class);
                        startActivity(intent);
                        break;
//                    case R.id.nav_cinema:
//                        Intent intent3 = new Intent(Cinema.this,MapsActivity.class);
//                        startActivity(intent3);
//                        break;
//                    case R.id.nav_actor:
//                        Intent intent2 = new Intent(Cinema.this,Actor.class);
//                        startActivity(intent2);
//                        break;
                }
                return false;
            }
        });
    }
}