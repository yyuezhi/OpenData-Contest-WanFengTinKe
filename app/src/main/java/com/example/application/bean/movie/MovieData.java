/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean.movie;
import com.example.application.bean.ActorList;
import com.example.application.bean.Data;
import com.example.application.bean.DirectorList;
import com.example.application.bean.ScreenWriterList;

import java.util.List;

/**
 * Auto-generated: 2020-07-04 18:31:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class MovieData extends Data {

    private String date;
    private String actor;
    private String director;
    private String name;
    private String abbreviateName;
    private String screenWriter;
    private String type;
    private String uri;
    private List<DirectorList> directorList;
    private List<ActorList> actorList;
    private List<ScreenWriterList> screenWriterList;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setActor(String actor) {
         this.actor = actor;
     }
     public String getActor() {
         return actor;
     }

    public void setDirector(String director) {
         this.director = director;
     }
     public String getDirector() {
         return director;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setAbbreviateName(String abbreviateName) {
         this.abbreviateName = abbreviateName;
     }
     public String getAbbreviateName() {
         return abbreviateName;
     }

    public void setScreenWriter(String screenWriter) {
         this.screenWriter = screenWriter;
     }
     public String getScreenWriter() {
         return screenWriter;
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

    public void setDirectorList(List<DirectorList> directorList) {
         this.directorList = directorList;
     }
     public List<DirectorList> getDirectorList() {
         return directorList;
     }

    public void setActorList(List<ActorList> actorList) {
         this.actorList = actorList;
     }
     public List<ActorList> getActorList() {
         return actorList;
     }

    public void setScreenWriterList(List<ScreenWriterList> screenWriterList) {
         this.screenWriterList = screenWriterList;
     }
     public List<ScreenWriterList> getScreenWriterList() {
         return screenWriterList;
     }

}