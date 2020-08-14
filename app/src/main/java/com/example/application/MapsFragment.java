package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class MapsFragment extends Fragment implements OnMapReadyCallback {

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for cinnema section display
        lstdata = new ArrayList<>();
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"上海大戏院","复兴中路1186号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"上海音乐厅","延安东路523号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"人民大舞台","九江路663号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"兰心大戏院","茂名南路57号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"大光明电影院","南京西路216号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"新光影艺苑","复兴中路1186号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"美琪大戏院","江宁路奉贤路口"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"长江剧场","黄河路35号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"黄浦剧场","北京东路780号"));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.mapListView);
        MapAdapter adapter = new MapAdapter(getActivity(),R.layout.cinnemaitem,lstdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view,int position,long l){
                Bundle bundle = new Bundle();
                bundle.putInt("CINEMA", position);
                Navigation.findNavController(view).navigate(R.id.action_nav_cinema_to_nav_cinema_detail, bundle);
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootView;
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