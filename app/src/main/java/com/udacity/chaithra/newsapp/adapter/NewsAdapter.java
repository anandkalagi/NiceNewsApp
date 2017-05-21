package com.udacity.chaithra.newsapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.chaithra.newsapp.R;
import com.udacity.chaithra.newsapp.connector.HttpHelper;
import com.udacity.chaithra.newsapp.model.ResultObject;
import com.udacity.chaithra.newsapp.view.NewsContentDescription;

import java.util.ArrayList;

/**
 * Created by kalagi on 5/20/2017.
 */

public class NewsAdapter extends BaseAdapter {

    Activity mContext;
    ArrayList<ResultObject> mResultObjects;
    public NewsAdapter(Activity context, ArrayList<ResultObject> resultObjects){
        mContext = context;
        mResultObjects = resultObjects;
    }

    @Override
    public int getCount() {
        return mResultObjects.size();
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
        ViewHolder holder;
        if(convertView == null){
            convertView = mContext.getLayoutInflater().inflate(R.layout.activity_newslist_item, parent, false);
            holder = new ViewHolder();
            holder.ivNewsItem = (ImageView) convertView.findViewById(R.id.img_newsitem_id);
            holder.txtNewsTitle = (TextView) convertView.findViewById(R.id.txt_news_title_id);
            holder.txtNewsSectionName = (TextView) convertView.findViewById(R.id.txt_news_sectionname_id);
            holder.txtNewsPubDate = (TextView) convertView.findViewById(R.id.txt_news_date_id);
            holder.txtNewsContent = (TextView) convertView.findViewById(R.id.txt_news_content_id);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        final ResultObject newsInfo = mResultObjects.get(position);
        holder.txtNewsTitle.setText(newsInfo.getWebTitle());
        holder.txtNewsSectionName.setText(newsInfo.getSectionName());
        holder.txtNewsPubDate.setText(newsInfo.getWebPublicationDate().toString());
        holder.txtNewsContent.setText("CLICK HERE");
        holder.txtNewsContent.setClickable(true);
        holder.txtNewsContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(newsInfo.getWebUrl())));
//                mContext.startActivity(new Intent(mContext,NewsContentDescription.class));
            }
        });

        return convertView;
    }

    class ViewHolder{
        private ImageView ivNewsItem;
        public TextView txtNewsTitle;
        public TextView txtNewsSectionName;
        public TextView txtNewsPubDate;
        public TextView txtNewsContent;
    }
}
