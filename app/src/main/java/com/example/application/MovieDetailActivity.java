package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.GridViewAdapter;
import com.example.application.bean.movieDetail.MovieDetailData;
import com.example.application.bean.movieDetail.MovieDetailJsonRootBean;
import com.example.application.bean.still.StillJsonRootBean;
import com.example.application.data.Constant;
import com.example.application.util.DownloadImageUtil;
import com.example.application.util.JsonRead;

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

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    private DownloadImageUtil downloadImageUtil;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        downloadImageUtil = new DownloadImageUtil(this);
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("NAME");
        String path = getIntent.getStringExtra("PATH");
        String url = getIntent.getStringExtra("URL");
        initView();
        initData(path,url);
        getSupportActionBar().setTitle(name);
    }



    private void initView(){
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView2);
    }

    private void initData(String path, String url){
        downloadImageUtil.downloadImage(path,imageView);
        getMovieDetailData(url);
    }

    private void getMovieDetailData(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.MOVIE_DETAIL(url)).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                JsonRead jsonRead =  new JsonRead();
//                Log.d("TAG",response.body().string());
                final MovieDetailJsonRootBean movieDetailJsonRootBean = jsonRead.readMovieDetail(response.body().string());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateMovieDetailData(movieDetailJsonRootBean);

                    }
                });
            }

        });
    }

    private void updateMovieDetailData(MovieDetailJsonRootBean movieDetailJsonRootBean) {
        StringBuffer str = new StringBuffer();
        try {
            List<MovieDetailData> datas= movieDetailJsonRootBean.getData();
            if (datas == null) {
                return;
            }
            for (MovieDetailData data:datas) {
                List<String> actors =data.getActor();
                str.append("actor");

                for (String actor: actors) {
                    str.append(actor);
                }
                List<String> contributors    =data.getContributor();
                str.append("contributor");
                for (String contributor: contributors) {
                    str.append(contributor);
                }
                List<String> directors =data.getDirector();
                str.append("director");
                for (String director: directors) {
                    str.append(director);
                }
                List<String> screenWriters =data.getScreenWriter();
                str.append("screenWriter");
                //            for (String screenWriter: screenWriters) {
                //                str.append(screenWriter);
                //            }
            }
        } catch (Exception e) {

            e.printStackTrace();
            return;
        }
        textView.setText(str);

    }

}