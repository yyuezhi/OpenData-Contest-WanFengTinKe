package com.example.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.bean.still.StillData;
import com.example.application.view.MyGridViewView;
//import com.example.application.moviecomment.R;
import com.example.application.util.DownloadImageUtil;

public class GridViewAdapter extends BaseAdapter {
  private String TAG = "GridViewAdapter";
  private Activity activity;
  private DownloadImageUtil downloadImageUtil;
  private List<StillData> listitem;

  public GridViewAdapter(Activity activity, List<StillData> listitem) {
    this.activity = activity;
    this.listitem = listitem;
    downloadImageUtil = new DownloadImageUtil(activity);
  }
  @Override
  public int getCount() {
    return listitem.size();
  }
  @Override
  public Object getItem(int position) {
    return listitem.get(position);
  }
  @Override
  public long getItemId(int position) {
    return position;
  }
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder=null;
    if (convertView == null) {
      convertView = LayoutInflater.from(activity).inflate(R.layout.gridview_item, null);
      holder= new ViewHolder();
      holder.imageView = (ImageView) convertView.findViewById(R.id.image);
      holder.textView = (TextView) convertView.findViewById(R.id.textView);
      convertView.setTag(holder);
    }else{ // 否则进行重用
      holder = (ViewHolder)convertView.getTag();
    }
      Log.d("ssss",position+"          sss");
      ViewHolder finalHolder = holder;
      downloadImageUtil.downloadImage(listitem.get(position).getImgPath(), finalHolder.imageView);
      finalHolder.textView.setText(listitem.get(position).getMovieName() + "");
    return convertView;
  }

  /** 创建 ViewHolder */
  class ViewHolder{
    TextView textView;
    ImageView imageView;
  }
}