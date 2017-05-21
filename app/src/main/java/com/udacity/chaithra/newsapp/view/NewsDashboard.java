package com.udacity.chaithra.newsapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.udacity.chaithra.newsapp.R;
import com.udacity.chaithra.newsapp.adapter.NewsAdapter;
import com.udacity.chaithra.newsapp.controler.NewsGuardianLoader;
import com.udacity.chaithra.newsapp.controler.NewsJsonStringParser;
import com.udacity.chaithra.newsapp.model.ResultObject;

import java.util.ArrayList;

/**
 * Created by kalagi on 5/20/2017.
 */

public class NewsDashboard extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    ListView mListView;
    private static final String TAG = NewsDashboard.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdashboard);
        bindByViewId();
        getSupportLoaderManager().initLoader(0,null,this);
    }

    private void bindByViewId() {
        mListView = (ListView) findViewById(R.id.listview_news_id);
    }


    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        Log.e(TAG,"onCreateLoader called");
        return new NewsGuardianLoader(this);
    }

    @Override
    public void onLoadFinished(Loader loader, String data) {
        Log.d(TAG,"onLoadFinished : "+data);
        String guardianJsonStr = data;
        ArrayList<ResultObject> parseJsonResultList = null;
        if(guardianJsonStr != null){
            parseJsonResultList = new NewsJsonStringParser().parseJsonStr(guardianJsonStr);
        }
        NewsAdapter newsAdapter = new NewsAdapter(NewsDashboard.this,parseJsonResultList);
        mListView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(0, null, this);
        super.onResume();
    }

}
