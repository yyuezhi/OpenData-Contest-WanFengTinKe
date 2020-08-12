package com.example.application.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Constant {
    private static String key = "ac55669606af89333c79296def567d4b48059d4b";
    public static String BANNER_URL = "https://data1.library.sh.cn/shnh/dydata/webapi/photo/getPhotoList?type=%E5%89%A7%E7%85%A7&date=1935&key=" + key;
    public static String RECOMMEND_URL = "https://data1.library.sh.cn/shnh/dydata/webapi/photo/getPhotoList?type=%E5%89%A7%E7%85%A7&key=" + key;
    private static String SEARCH_IMAGE = "https://data1.library.sh.cn/shnh/dydata/webapi/photo/getPhotoList?freetext=";
    private static String MOVIE_DETAIL = "https://data1.library.sh.cn/shnh/dydata/webapi/movie/movieDetail?uri=";
    public static String SEARCH_IMAGE(String data){
        return SEARCH_IMAGE+data+"&key="+ key;
    }

    public static String MOVIE_DETAIL(String url){
        return MOVIE_DETAIL+url+"&key="+ key;
    }
}
