/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean.still;
import com.example.application.bean.Pager;

import java.util.List;

/**
 * Auto-generated: 2020-07-04 18:31:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class StillJsonRootBean {

    private String result;
    private List<StillData> data;
    private Pager pager;
    public void setResult(String result) {
         this.result = result;
     }
     public String getResult() {
         return result;
     }

    public void setData(List<StillData> data) {
         this.data = data;
     }
     public List<StillData> getData() {
         return data;
     }

    public void setPager(Pager pager) {
         this.pager = pager;
     }
     public Pager getPager() {
         return pager;
     }

}