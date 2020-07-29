/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean.still;
import com.example.application.bean.Data;

import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2020-07-04 20:1:15
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class StillData extends  Data{

    private Date date;
    private String imgFormat;
    private String img;
    private String creator;
    private String movie;
    private String type;
    private String donator;
    private String uri;
    private String movieName;
    private String personUri;
    private String imgPath;
    private List<PersonList> personList;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setImgFormat(String imgFormat) {
         this.imgFormat = imgFormat;
     }
     public String getImgFormat() {
         return imgFormat;
     }

    public void setImg(String img) {
         this.img = img;
     }
     public String getImg() {
         return img;
     }

    public void setCreator(String creator) {
         this.creator = creator;
     }
     public String getCreator() {
         return creator;
     }

    public void setMovie(String movie) {
         this.movie = movie;
     }
     public String getMovie() {
         return movie;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setDonator(String donator) {
         this.donator = donator;
     }
     public String getDonator() {
         return donator;
     }

    public void setUri(String uri) {
         this.uri = uri;
     }
     public String getUri() {
         return uri;
     }

    public void setMovieName(String movieName) {
         this.movieName = movieName;
     }
     public String getMovieName() {
         return movieName;
     }

    public void setPersonUri(String personUri) {
         this.personUri = personUri;
     }
     public String getPersonUri() {
         return personUri;
     }

    public void setImgPath(String imgPath) {
         this.imgPath = imgPath;
     }
     public String getImgPath() {
         return imgPath;
     }

    public void setPersonList(List<PersonList> personList) {
         this.personList = personList;
     }
     public List<PersonList> getPersonList() {
         return personList;
     }

}