package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application.GridViewAdapter;
import com.example.application.bean.still.StillData;
import com.example.application.bean.still.StillJsonRootBean;
import com.example.application.data.Constant;
import com.example.application.util.JsonRead;
import com.example.application.view.MyGridViewView;

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

public class SearchDataActivity extends AppCompatActivity {
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private List<StillData> listitem;
    private MyGridViewView gridView;
    private GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        Intent getIntent = getIntent();
        String ll = getIntent.getStringExtra("DATA");
        listitem = new ArrayList<>();
        initView();
        getSearchData(ll);
        getSupportActionBar().setTitle(ll);
    }

    private void initView(){
        gridView = (MyGridViewView) findViewById(R.id.gridView);
    }

    private void updateSearchData(StillJsonRootBean stillJsonRootBean) {

        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        listitem.clear();
        for (int i = 0; i < stillJsonRootBean.getData().size(); i++) {
            listitem.add(stillJsonRootBean.getData().get(i));
        }
        gridViewAdapter = new GridViewAdapter(this, listitem);
        gridView.setAdapter(gridViewAdapter);
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

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateSearchData(stillJsonRootBean);

                    }
                });
            }

        });
    }
}