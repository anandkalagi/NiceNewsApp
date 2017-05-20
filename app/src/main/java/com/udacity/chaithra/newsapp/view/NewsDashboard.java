package com.udacity.chaithra.newsapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.udacity.chaithra.newsapp.R;
import com.udacity.chaithra.newsapp.adapter.NewsAdapter;

/**
 * Created by kalagi on 5/20/2017.
 */

public class NewsDashboard extends AppCompatActivity {

    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdashboard);
        bindByViewId();
        setNewsAdapter();

    }

    private void bindByViewId() {
        mListView = (ListView) findViewById(R.id.listview_news_id);
    }

    private void setNewsAdapter() {
        NewsAdapter newsAdapter = new NewsAdapter(NewsDashboard.this);
        mListView.setAdapter(newsAdapter);
    }
}
