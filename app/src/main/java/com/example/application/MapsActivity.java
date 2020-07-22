package com.example.application;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<MapCinnemaItem> lstdata;
    BottomNavigationView bottomNav;


//    public static  Integer [] cinnemaImages = {
//            R.drawable.s1,R.drawable.s2,R.drawable.s3
//    };
//
//    public static String[] cinnemaName = {
//            "Testing","Testing","Meiqi"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        //for cinnema section display
        lstdata = new ArrayList<>();
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"meiqi","blur blur blur"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"meiqiAgain","blur blur Again"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"Data","blur blur Again"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"sdf","blur blur Again"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"qwetar","blur blur Again"));

        ListView listView = (ListView) findViewById(R.id.mapListView);
        MapAdapter adapter = new MapAdapter(this,R.layout.cinnemaitem,lstdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view,int position,long l){
                Intent intent = new Intent();
                intent.putExtra("Cinema Name",lstdata.get(position).cinnemaName);
                intent.putExtra("image",lstdata.get(position).resID);
                intent.setClass(MapsActivity.this,Cinema.class);
                startActivity(intent);
            }
        });


        //bottom navigation
        bottomNav = findViewById(R.id.bottom_navigation_map);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(MapsActivity.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_cinema:
                        break;
                    case R.id.nav_actor:
                        Intent intent2 = new Intent(MapsActivity.this,Actor.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}