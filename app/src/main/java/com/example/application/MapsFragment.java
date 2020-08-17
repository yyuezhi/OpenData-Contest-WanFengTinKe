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

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment  {


    List<MapCinnemaItem> lstdata;
    private MarkerOptions markerOption;
    private AMap aMap;
    private MapView mapView;
    private LatLng latlng = new LatLng(39.761, 116.434);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for cinnema section display
        lstdata = new ArrayList<>();
        lstdata.add(new MapCinnemaItem(R.drawable.daxiyuan,"上海大戏院","复兴中路1186号"));
        lstdata.add(new MapCinnemaItem(R.drawable.yingyueting,"上海音乐厅","延安东路523号"));
        lstdata.add(new MapCinnemaItem(R.drawable.renming,"人民大舞台","九江路663号"));
        lstdata.add(new MapCinnemaItem(R.drawable.lanxin,"兰心大戏院","茂名南路57号"));
        lstdata.add(new MapCinnemaItem(R.drawable.daguangmin,"大光明电影院","南京西路216号"));
        lstdata.add(new MapCinnemaItem(R.drawable.xinguangyin,"新光影艺苑","复兴中路1186号"));
        lstdata.add(new MapCinnemaItem(R.drawable.meiqi,"美琪大戏院","江宁路奉贤路口"));
        lstdata.add(new MapCinnemaItem(R.drawable.changjiang,"长江剧场","黄河路35号"));
        lstdata.add(new MapCinnemaItem(R.drawable.huangpu,"黄浦剧场","北京东路780号"));
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

        /*
         * 设置离线地图存储目录，在下载离线地图或初始化地图设置; 使用过程中可自行设置, 若自行设置了离线地图存储的路径，
         * 则需要在离线地图下载和使用地图页面都进行路径设置
         */
        // Demo中为了其他界面可以使用下载的离线地图，使用默认位置存储，屏蔽了自定义设置
        // MapsInitializer.sdcardDir =OffLineMapUtils.getSdCacheDir(this);
        mapView = (MapView) rootView.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState); // 此方法必须重写
        init();
        return rootView;
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            addMarkersToMap();// 往地图上添加marker
        }
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    /**
     * 在地图上添加marker
     */
    private void addMarkersToMap() {

        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .position(latlng)
                .draggable(true);
        aMap.addMarker(markerOption);
    }
}





//    /**
//     * 初始化AMap对象
//     */
//    private void init() {
//        if (aMap == null) {
//            aMap = mapView.getMap();
//            addMarkersToMap();// 往地图上添加marker
//        }
//    }
//
//    /**
//     * 方法必须重写
//     */
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    /**
//     * 方法必须重写
//     */
//    @Override
//    protected void onPause() {
//        super.onPause();
//        mapView.onPause();
//    }
//
//    /**
//     * 方法必须重写
//     */
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        mapView.onSaveInstanceState(outState);
//    }
//
//    /**
//     * 方法必须重写
//     */
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mapView.onDestroy();
//    }
//
//    /**
//     * 在地图上添加marker
//     */
//    private void addMarkersToMap() {
//
//        markerOption = new MarkerOptions().icon(BitmapDescriptorFactory
//                .defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
//                .position(latlng)
//                .draggable(true);
//        aMap.addMarker(markerOption);
//    }
//}