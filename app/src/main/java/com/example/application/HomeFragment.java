package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.widget.TextView;


import com.example.application.bean.still.StillData;
import com.example.application.data.Constant;
import com.example.application.util.JsonRead;
import com.example.application.view.IconCenterEditText;
import com.example.application.view.MyGridViewView;

//import com.movie.moviecomment.R;
import com.example.application.bean.still.StillJsonRootBean;
import com.example.application.util.DownloadImageUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment implements OnBannerListener , AdapterView.OnItemClickListener , View.OnFocusChangeListener ,TextWatcher, TextView.OnEditorActionListener , View.OnClickListener {



    private Banner banner;
    ListView listView;
    private ImageView search_button;
    private IconCenterEditText searchView;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    private boolean isKeyUp = false;
    private ArrayAdapter arrayAdapter;
    private MyGridViewView gridView;
    private GridViewAdapter gridViewAdapter;
    private List<StillData> listitem;
    private List<StillData> bannerItem;
    private String[] mStrings = new String[]{"秦淮世家", "松花江上", "潇湘夜雨","新旧上海","满江红","血泪黄花"};
    private ListAdapter adapter;
    android.widget.Filter filter;
    DownloadImageUtil downloadImageUtil;
    private static HomeFragment fragment;
    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        if (fragment==null){
            fragment = new HomeFragment();
        }

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        downloadImageUtil = new DownloadImageUtil(getActivity());
        listitem = new ArrayList<>();
        bannerItem = new ArrayList<>();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        banner = (Banner) root.findViewById(R.id.banner);
        try {
            initView(root);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        getBannrt();
        getRecommendData();
        initListener();
        return root;
    }

    private void initView(View view) throws NoSuchFieldException, IllegalAccessException {
        listView = view.findViewById(R.id.listview);
        gridView = (MyGridViewView) view.findViewById(R.id.gridView);
        arrayAdapter =new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mStrings);
        filter = arrayAdapter.getFilter();
        listView.setAdapter(arrayAdapter);
        //设置ListView启用过滤
        listView.setTextFilterEnabled(true);
        searchView = view.findViewById(R.id.searchview);
        listView.setVisibility(View.GONE);
        search_button = view.findViewById(R.id.search_button);
    }

    private void updateBannerData(StillJsonRootBean stillJsonRootBean){

        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        for (int i = 0; i < stillJsonRootBean.getData().size() ; i++) {
            bannerItem.add(stillJsonRootBean.getData().get(i));
            list_path.add(stillJsonRootBean.getData().get(i).getImgPath());
            list_title.add(stillJsonRootBean.getData().get(i).getMovieName());
    }
//
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();

    }

    private void initListener(){
        listView.setOnItemClickListener(this);
        gridView.setOnItemClickListener(this);
        searchView.setOnFocusChangeListener(this);
        searchView.addTextChangedListener(this);
        searchView.setOnEditorActionListener(this);
        search_button.setOnClickListener(this);
    }

    private void updateRecommendData(StillJsonRootBean stillJsonRootBean) {

        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        listitem.clear();
        for (int i = 0; i < stillJsonRootBean.getData().size(); i++) {
            listitem.add(stillJsonRootBean.getData().get(i));
        }
        gridViewAdapter = new GridViewAdapter(getActivity(), listitem);
        gridView.setAdapter(gridViewAdapter);
    }

    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        gotoMovieDetail(bannerItem.get(position).getMovieName(),bannerItem.get(position).getImgPath(),bannerItem.get(position).getMovie());
        Log.i("tag", "你点了第"+position+"张轮播图");

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            switch (parent.getId()){
                case R.id.listview:
                    Adapter adpter=parent.getAdapter();
                    String data = (String) adpter.getItem(position);
                    searchData(data,view);
                    break;
                case R.id.gridView:
                    gotoMovieDetail(listitem.get(position).getMovieName(),listitem.get(position).getImgPath(),listitem.get(position).getMovie());
                    break;
                default:
                    break;
            }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            listView.setVisibility(View.VISIBLE);
        }else{
            listView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
        // When user change the text
        arrayAdapter.getFilter().filter(cs);
        arrayAdapter.notifyDataSetChanged();
        Log.i("tag", ""+cs.toString());
    }

    @Override
    public void beforeTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
        //
    }

    @Override
    public void afterTextChanged(Editable arg0) {
        //
    }

    @Override
    public boolean onEditorAction(TextView v,int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH){
            searchData(searchView.getText().toString()+"",v);
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                searchData(searchView.getText().toString()+"",v);
                break;

        }
    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            downloadImageUtil.downloadImage((String)path,imageView);
        }
    }

    private void gotoMovieDetail(String name,String path,String url){
        Intent intent = new Intent();
        intent.setClass(getActivity(),MovieDetailActivity.class);
        intent.putExtra("NAME",name);
        intent.putExtra("PATH",path);
        intent.putExtra("URL",url);
        getActivity().startActivity(intent);
    }
    private void getBannrt(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.BANNER_URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               JsonRead jsonRead =  new JsonRead();
//                Log.d("TAG",response.body().string());
                final StillJsonRootBean stillJsonRootBean = jsonRead.readImageImage(response.body().string());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateBannerData(stillJsonRootBean);
                    }
                });
            }

        });
    }

    private void getRecommendData(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.RECOMMEND_URL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                JsonRead jsonRead =  new JsonRead();
//                Log.d("TAG",response.body().string());
                final StillJsonRootBean stillJsonRootBean = jsonRead.readImageImage(response.body().string());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateRecommendData(stillJsonRootBean);
                    }
                });
            }

        });
    }



    private void searchData(String data,View view){
        clearFocuse();
        Bundle bundle = new Bundle();
        bundle.putString("DATA", data);
        Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_search, bundle);
    }

    private void clearFocuse(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(getView(),InputMethodManager.SHOW_FORCED);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0); //强制隐藏键盘
        listView.setVisibility(View.GONE);
        searchView.clearFocus();
    }
}