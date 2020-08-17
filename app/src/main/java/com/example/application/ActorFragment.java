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
        lstdata.add(new ActorItem(R.drawable.img_0,"左己","《风暴》《人心》"));
        lstdata.add(new ActorItem(R.drawable.img_2,"张瑛","《蝴蝶夫人》《战功》"));
        lstdata.add(new ActorItem(R.drawable.img_3,"白燕","《锦绣河山》《春》《寒夜》"));
        lstdata.add(new ActorItem(R.drawable.img_4,"金山","《昏狂》《夜半歌声》《屈原》"));
        lstdata.add(new ActorItem(R.drawable.img_5,"浦克","《迎春花》《真假姐妹》《松花江上》"));
        lstdata.add(new ActorItem(R.drawable.img_6,"朱文顺","《刀光虎影》、《何处不风流》、《拂晓的爆炸》"));
        lstdata.add(new ActorItem(R.drawable.img_7,"方化","《松花江上》 《赵一曼》《智取华山》"));
        lstdata.add(new ActorItem(R.drawable.img_8,"张瑞芳","《火的洗礼》《松花江上》 《南征北战》"));
        lstdata.add(new ActorItem(R.drawable.img_9,"卜万苍","《三个摩登女性》、《母性之光》、《国魂》"));
        lstdata.add(new ActorItem(R.drawable.img_10,"王元龙","《人心》《战功》《王氏四侠》"));
        lstdata.add(new ActorItem(R.drawable.img_11,"梅熹","《乞丐千金》、《木兰从军》《丰年》"));
        lstdata.add(new ActorItem(R.drawable.img_12,"白虹","《无花果》《孤岛春秋》《美人关》"));
        lstdata.add(new ActorItem(R.drawable.img_13,"王献斋","《孤儿救祖记》《歌女红牡丹》、《劫后桃花》"));
        lstdata.add(new ActorItem(R.drawable.img_14,"舒绣文","《小猫钓鱼》《李时珍》《关汉卿》"));
        lstdata.add(new ActorItem(R.drawable.img_15,"程步高","《夜来香》《保卫我们的土地》"));
        lstdata.add(new ActorItem(R.drawable.img_16,"夏萍","《倾城之恋》 《秦淮世家》"));
        lstdata.add(new ActorItem(R.drawable.img_17,"黄曼梨","《关汉卿》《王氏四侠》"));
        lstdata.add(new ActorItem(R.drawable.img_18,"姜中平","《倾城之恋》《歌舞瘅平》"));


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_actor, container, false);

        ListView lv = (ListView)rootView.findViewById(R.id.actor_list);
        lv.setAdapter(new ActorAdapter(getActivity(), R.layout.actoritem,lstdata));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int position, long l){
                Bundle bundle = new Bundle();
                bundle.putString("ACTOR", lstdata.get(position).actorName);
                Navigation.findNavController(view).navigate(R.id.action_nav_actor_to_nav_actorPage,bundle);
            }
        });
        return rootView;
    }


}