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
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.application.GridViewAdapter;
import com.example.application.bean.still.StillData;
import com.example.application.bean.still.StillJsonRootBean;
import com.example.application.data.Constant;
import com.example.application.util.JsonRead;
import com.example.application.view.IconCenterEditText;
import com.example.application.view.MyGridViewView;
import com.google.android.gms.maps.SupportMapFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SearchDataFragment extends Fragment implements   AdapterView.OnItemClickListener , View.OnFocusChangeListener , TextWatcher, TextView.OnEditorActionListener , View.OnClickListener{
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private List<StillData> listitem;
    private MyGridViewView gridView;
    ListView listView;
    private ArrayAdapter arrayAdapter;
    private GridViewAdapter gridViewAdapter;
    private IconCenterEditText searchView;
    private ImageView search_button;
    android.widget.Filter filter;
    private String[] mStrings = new String[]{"秦淮世家", "松花江上", "潇湘夜雨","新旧上海","满江红","血泪黄花"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String ll = "";
        listitem = new ArrayList<>();
        try {
            ll = getArguments().getString("DATA");
        }
        catch (java.lang.NullPointerException e){
            ll = "秦淮世家";
        }

        getSearchData(ll);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(ll);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_data, container, false);
        try {
            initView(rootView);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        initListener();
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick (AdapterView<?> adapterView, View view,int position,long l){
//                Navigation.findNavController(view).navigate(R.id.action_nav_cinema_to_nav_cinema_detail);
//            }
//        });
        return rootView;
    }

    private void initView(View view) throws NoSuchFieldException, IllegalAccessException {
        listView = view.findViewById(R.id.listview_search);
        arrayAdapter =new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mStrings);
        filter = arrayAdapter.getFilter();
        gridView = (MyGridViewView) view.findViewById(R.id.gridView_search);
        listView.setAdapter(arrayAdapter);
        //设置ListView启用过滤
        listView.setTextFilterEnabled(true);
        searchView = view.findViewById(R.id.searchUI);
        listView.setVisibility(View.GONE);
        search_button = view.findViewById(R.id.search_button_search);
    }

    private void initListener(){
        listView.setOnItemClickListener(this);
        gridView.setOnItemClickListener(this);
        searchView.setOnFocusChangeListener(this);
        searchView.addTextChangedListener(this);
        searchView.setOnEditorActionListener(this);
        search_button.setOnClickListener(this);
    }

    public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
        // When user change the text
        arrayAdapter.getFilter().filter(cs);
        arrayAdapter.notifyDataSetChanged();
        Log.i("tag", ""+cs.toString());
    }

    private void gotoMovieDetail(String name,String path,String url,View v){
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        bundle.putString("IMAGE",path);
        bundle.putString("URL",url);
        Navigation.findNavController(v).navigate(R.id.action_nav_search_to_movie, bundle);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.listview_search:
                Adapter adpter=parent.getAdapter();
                String data = (String) adpter.getItem(position);
                searchData(data,view);
                break;
            case R.id.gridView_search:
                gotoMovieDetail(listitem.get(position).getMovieName(),listitem.get(position).getImgPath(),listitem.get(position).getMovie(),view);
                break;
            default:
                break;
        }
    }

    private void clearFocuse(){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(getView(),InputMethodManager.SHOW_FORCED);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0); //强制隐藏键盘
        searchView.clearFocus();
    }

    private void searchData(String data,View view){
        clearFocuse();
        getSearchData(data);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(data);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                searchData(searchView.getText().toString()+"",v);
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v,int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH){
            searchData(searchView.getText().toString()+"",v);
            return true;
        }
        return false;
    }


    private void updateSearchData(StillJsonRootBean stillJsonRootBean) {

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

    @Override
    public void beforeTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
        //
    }

    @Override
    public void afterTextChanged(Editable arg0) {
        //
    }


    private void getSearchData(String data){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.SEARCH_IMAGE(data)).build();
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
                        updateSearchData(stillJsonRootBean);

                    }
                });
            }

        });
    }
}