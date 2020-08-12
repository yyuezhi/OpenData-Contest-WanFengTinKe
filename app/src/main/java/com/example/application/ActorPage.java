package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActorPage extends AppCompatActivity {
    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_page);
        //Text view
        TextView title = (TextView) findViewById(R.id.actor_text);
        title.setText("This is individual actor page");

        //bottom navigation
//        bottomNav = findViewById(R.id.bottom_navigation_actorPage);
//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
////                    case R.id.nav_home:
////                        Intent intent = new Intent(ActorPage.this, MainActivity.class);
////                        startActivity(intent);
////                        break;
////                    case R.id.nav_cinema:
////                        Intent intent2 = new Intent(ActorPage.this, MapsActivity.class);
////                        startActivity(intent2);
////                        break;
////                    case R.id.nav_actor:
////                        Intent intent3 = new Intent(ActorPage.this, Actor.class);
////                        startActivity(intent3);
////                        break;
//                }
//                return false;
//            }
//        });
    }
}