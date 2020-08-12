package com.example.application;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class ActorFragment extends Fragment {

    List<ActorItem> lstdata;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for actor section display
        lstdata = new ArrayList<>();
        lstdata.add(new ActorItem(R.drawable.s1,"Tom","blur blur blur"));
        lstdata.add(new ActorItem(R.drawable.s2,"Frederick","blur blur Again"));
        lstdata.add(new ActorItem(R.drawable.s3,"Anna","blur blur blur"));
        lstdata.add(new ActorItem(R.drawable.s4,"Charlie","blur blur Again"));
        lstdata.add(new ActorItem(R.drawable.s5,"CAT","blur blur Again"));

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick (AdapterView<?> adapterView, View view, int position, long l){
//                Intent intent = new Intent();
//                intent.putExtra("Actor Name",lstdata.get(position).actorName);
//                intent.putExtra("image",lstdata.get(position).resID);
//                intent.setClass(Actor.this,ActorPage.class);
//                startActivity(intent);
//            }
//        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_actor, container, false);

        ListView lv = (ListView)rootView.findViewById(R.id.actor_list);
        lv.setAdapter(new ActorAdapter(getActivity(), R.layout.actoritem,lstdata));

        return rootView;
    }


}