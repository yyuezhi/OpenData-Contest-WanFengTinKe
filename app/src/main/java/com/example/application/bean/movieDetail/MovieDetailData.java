/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean.movieDetail;
import com.example.application.bean.Data;

import java.util.List;

/**
 * Auto-generated: 2020-07-05 17:5:12
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MovieDetailData extends Data {

    private String date;
    private List<String> actor;
    private List<String> contributor;
    private List<String> director;
    private String name;
    private String source;
    private List<String> screenWriter;
    private String title;
    private String type;
    private String uri;
    private List<Distributor> distributor;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setActor(List<String> actor) {
         this.actor = actor;
     }
     public List<String> getActor() {
         return actor;
     }

    public void setContributor(List<String> contributor) {
         this.contributor = contributor;
     }
     public List<String> getContributor() {
         return contributor;
     }

    public void setDirector(List<String> director) {
         this.director = director;
     }
     public List<String> getDirector() {
         return director;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

    public void setScreenWriter(List<String> screenWriter) {
         this.screenWriter = screenWriter;
     }
     public List<String> getScreenWriter() {
         return screenWriter;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setUri(String uri) {
         this.uri = uri;
     }
     public String getUri() {
         return uri;
     }

    public void setDistributor(List<Distributor> distributor) {
         this.distributor = distributor;
     }
     public List<Distributor> getDistributor() {
         return distributor;
     }

}