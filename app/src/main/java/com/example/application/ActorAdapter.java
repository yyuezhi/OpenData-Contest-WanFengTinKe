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

public class ActorAdapter extends  ArrayAdapter<ActorItem>{
    Context context;
    int resID;
    List<ActorItem> data = null;
    public ActorAdapter (Context context,int resID,List<ActorItem> object){
        super(context,resID,object);
        this.context = context;
        this.resID = resID;
        this.data = object;
    }

    static class ActorDataHolder{
        ImageView imageView;
        TextView actorName;
        TextView actorInfo;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ActorDataHolder holder = null;
        if (convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(resID,parent,false);

            holder = new ActorDataHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.actor_image);
            holder.actorName = (TextView) convertView.findViewById(R.id.actor_name);
            holder.actorInfo = (TextView) convertView.findViewById(R.id.actor_info);

            convertView.setTag(holder);
        }
        else {
            holder = (ActorDataHolder) convertView.getTag();
        }
        ActorItem item = data.get(position);
        holder.actorName.setText(item.actorName);
        holder.actorInfo.setText(item.actorInfo);
        holder.imageView.setImageResource(item.resID);
        return  convertView;
    }
}
