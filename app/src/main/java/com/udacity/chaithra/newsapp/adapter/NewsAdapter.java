package com.udacity.chaithra.newsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.udacity.chaithra.newsapp.R;

/**
 * Created by kalagi on 5/20/2017.
 */

public class NewsAdapter extends BaseAdapter {

    Activity mContext;
    public NewsAdapter(Activity context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mContext.getLayoutInflater().inflate(R.layout.activity_newslist_item, parent, false);
            ViewHolder holder = new ViewHolder();

            convertView.setTag(holder);
        }else{
            return convertView;
        }
        return null;
    }

    class ViewHolder{

    }
}
