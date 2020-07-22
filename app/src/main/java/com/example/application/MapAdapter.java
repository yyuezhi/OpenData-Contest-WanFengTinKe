package com.example.application;
import android.app.Activity;
import  android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import java.util.List;

public class MapAdapter extends  ArrayAdapter<MapCinnemaItem>{
    Context context;
    int resID;
    List<MapCinnemaItem> data = null;
    public MapAdapter (Context context,int resID,List<MapCinnemaItem> object){
        super(context,resID,object);
        this.context = context;
        this.resID = resID;
        this.data = object;
    }

    static class DataHolder{
        ImageView imageView;
        TextView cinemaName;
        TextView cinemaAddress;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DataHolder holder = null;
        if (convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(resID,parent,false);

            holder = new DataHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.cinnema_image_map);
            holder.cinemaName = (TextView) convertView.findViewById(R.id.cinema_name_map);
            holder.cinemaAddress = (TextView) convertView.findViewById(R.id.cinnema_addreass);

            convertView.setTag(holder);
        }
        else {
            holder = (DataHolder) convertView.getTag();
        }
        MapCinnemaItem item = data.get(position);
        holder.cinemaName.setText(item.cinnemaName);
        holder.cinemaAddress.setText(item.cinnemaAddreass);
        holder.imageView.setImageResource(item.resID);
        return  convertView;
    }
}
