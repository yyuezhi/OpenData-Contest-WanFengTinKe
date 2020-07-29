/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean.movieDetail;
import com.example.application.bean.movie.MovieData;

import java.util.List;

/**
 * Auto-generated: 2020-07-05 17:5:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MovieDetailJsonRootBean {

    private String result;
    private List<MovieDetailData> data;
    public void setResult(String result) {
         this.result = result;
     }
     public String getResult() {
         return result;
     }

    public void setData(List<MovieDetailData> data) {
         this.data = data;
     }
     public List<MovieDetailData> getData() {
         return data;
     }

}