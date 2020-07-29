package com.example.application.util;

import android.util.Log;

import com.example.application.bean.movie.MovieData;
import com.example.application.bean.movieDetail.MovieDetailData;
import com.example.application.bean.movieDetail.MovieDetailJsonRootBean;
import com.example.application.bean.still.StillData;
import com.example.application.bean.still.StillJsonRootBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonRead {
    /**
     * JSON 解析方法
     * @param jsonData
     * @return
     */
    public StillJsonRootBean readImageImage(String jsonData){
        Log.d("TAG",jsonData);
        try {
            StillJsonRootBean jsonRootBean = new StillJsonRootBean();
            List<StillData> datas = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = new JSONArray(jsonObject.get("data").toString());
            Log.d("TAG",jsonObject.getString("result"));
            for (int i=0;i<jsonArray.length();i++){
                JSONObject data = jsonArray.getJSONObject(i);
                StillData stillData = new StillData();
                String url = data.getString("imgPath");
                Log.d("TAG",url);
                stillData.setImgPath(url);
                stillData.setMovieName(data.getString("movieName"));
                stillData.setMovie(data.getString("movie"));
                datas.add(stillData);
            }
            jsonRootBean.setData(datas);
            return jsonRootBean;
        } catch (JSONException e) {
            Log.e("JSONException错误", "readContent: "+e.toString());
            return null;
        }
    }

    /**
     * JSON 解析方法
     * @param jsonData
     * @return
     */
    public MovieDetailJsonRootBean readMovieDetail(String jsonData){
        Log.d("TAG",jsonData);
        try {
            MovieDetailJsonRootBean jsonRootBean = new MovieDetailJsonRootBean();
            List<MovieDetailData> datas = new ArrayList<>();
            List<String> actors = new ArrayList<>();
            List<String> contributors = new ArrayList<>();
            List<String> directors = new ArrayList<>();
            List<String> screenWriters = new ArrayList<>();
            List<String> distributors = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = new JSONArray(jsonObject.get("data").toString());

            for (int i=0;i<jsonArray.length();i++){
                JSONObject data = jsonArray.getJSONObject(i);
                MovieDetailData movieDetailData = new MovieDetailData();
                try {

                JSONArray arrActor = new JSONArray(data.get("actor").toString());
                    Log.d("ddd",arrActor.toString()+"length---"+arrActor.length());

                    for (int j = 0; j < arrActor.length(); j++) {
                        actors.add(arrActor.optString(0));
                    }
                    JSONArray arrcontributor = new JSONArray(data.get("contributor").toString());
                    for (int j = 0; j < arrcontributor.length(); j++) {
                        contributors.add(arrcontributor.optString(0));
                    }
                    JSONArray arrdirector = new JSONArray(data.get("director").toString());
                    for (int j = 0; j < arrdirector.length(); j++) {
                        directors.add(arrdirector.optString(0));
                    }
                    JSONArray arrscreenWriter = new JSONArray(data.get("screenWriter").toString());
                    for (int j = 0; j < arrscreenWriter.length(); j++) {
                        screenWriters.add(arrscreenWriter.optString(0));
                    }
                    JSONArray arrdistributor = new JSONArray(data.get("distributor").toString());
//                    for (int j = 0; j < arrdistributor.length(); j++) {
//                        directors.add(arrdistributor.optString(0));
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                movieDetailData.
//                movieDetailData.getActor().add();
                movieDetailData.setActor(actors);
                movieDetailData.setContributor(contributors);
                movieDetailData.setDirector(directors);
//                movieDetailData.setDistributor(distributors);
                datas.add(movieDetailData);
            }
            jsonRootBean.setData(datas);
            return jsonRootBean;
        } catch (JSONException e) {
            Log.e("JSONException错误", "readContent: "+e.toString());
            return null;
        }
    }

}
