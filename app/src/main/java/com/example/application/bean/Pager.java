/**
  * Copyright 2020 bejson.com 
  */
package com.example.application.bean;
import java.util.List;

/**
 * Auto-generated: 2020-07-04 18:31:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Pager {

    private String iflimit;
    private int startIndex;
    private int pageSize;
    private String sort;
    private String dir;
    private int pageth;
    private List<Integer> pageths;
    private int pageCount;
    private int rowCount;
    public void setIflimit(String iflimit) {
         this.iflimit = iflimit;
     }
     public String getIflimit() {
         return iflimit;
     }

    public void setStartIndex(int startIndex) {
         this.startIndex = startIndex;
     }
     public int getStartIndex() {
         return startIndex;
     }

    public void setPageSize(int pageSize) {
         this.pageSize = pageSize;
     }
     public int getPageSize() {
         return pageSize;
     }

    public void setSort(String sort) {
         this.sort = sort;
     }
     public String getSort() {
         return sort;
     }

    public void setDir(String dir) {
         this.dir = dir;
     }
     public String getDir() {
         return dir;
     }

    public void setPageth(int pageth) {
         this.pageth = pageth;
     }
     public int getPageth() {
         return pageth;
     }

    public void setPageths(List<Integer> pageths) {
         this.pageths = pageths;
     }
     public List<Integer> getPageths() {
         return pageths;
     }

    public void setPageCount(int pageCount) {
         this.pageCount = pageCount;
     }
     public int getPageCount() {
         return pageCount;
     }

    public void setRowCount(int rowCount) {
         this.rowCount = rowCount;
     }
     public int getRowCount() {
         return rowCount;
     }

}