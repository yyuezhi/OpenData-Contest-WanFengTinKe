package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Actor extends AppCompatActivity {

    BottomNavigationView bottomNav;
    List<ActorItem> lstdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor);


        //for actor section display
        lstdata = new ArrayList<>();
        lstdata.add(new ActorItem(R.drawable.s1,"Tom","blur blur blur"));
        lstdata.add(new ActorItem(R.drawable.s2,"Frederick","blur blur Again"));
        lstdata.add(new ActorItem(R.drawable.s3,"Anna","blur blur blur"));
        lstdata.add(new ActorItem(R.drawable.s4,"Charlie","blur blur Again"));
        lstdata.add(new ActorItem(R.drawable.s5,"CAT","blur blur Again"));

        ListView listView = (ListView) findViewById(R.id.actor_list);
        ActorAdapter adapter = new ActorAdapter(this,R.layout.actoritem,lstdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long l){
                Intent intent = new Intent();
                intent.putExtra("Actor Name",lstdata.get(position).actorName);
                intent.putExtra("image",lstdata.get(position).resID);
                intent.setClass(Actor.this,ActorPage.class);
                startActivity(intent);
            }
        });


        //bottom navigation
        bottomNav = findViewById(R.id.bottom_navigation_actor);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(Actor.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_cinema:
                        Intent intent2 = new Intent(Actor.this, MapsActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_actor:
                        break;
                }
                return false;
            }
        });
    }


}