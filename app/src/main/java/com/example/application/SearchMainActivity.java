package com.example.application;


import android.os.Bundle;
//import android.support.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.application.DashboardFragment;
import com.example.application.HomeFragment;
import com.example.application.NotificationsFragment;

public class SearchMainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private static final String TAG_HOME_FRAGMENT = "HomeFragment";
    private static final String TAG_DASHBARD_FRAGMENT = "DashboardFragment";
    private static final String TAG_NOTIFICATION_FRAGMENT = "NotificationsFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        fragmentManager = getSupportFragmentManager();
        BottomNavigationView navView = findViewById(R.id.bottom_navigation_search_main);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }



}