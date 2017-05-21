package com.udacity.chaithra.newsapp.controler;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.Toast;

import com.udacity.chaithra.newsapp.connector.HttpHelper;
import com.udacity.chaithra.newsapp.model.ResultObject;
import com.udacity.chaithra.newsapp.utils.Permissions;
import com.udacity.chaithra.newsapp.view.NewsDashboard;

import java.io.IOException;
import java.net.URL;

/**
 * Created by kalagi on 5/21/2017.
 */

public class NewsGuardianLoader extends AsyncTaskLoader<String> {
    final String TAG = NewsGuardianLoader.class.getSimpleName();
    HttpHelper httpHelper;
    Context mContext;

    public NewsGuardianLoader(Context context) {
        super(context);
        mContext = context;
        Log.e(TAG,"constructor called");
    }

    @Override
    protected void onStartLoading() {
        Log.e(TAG,"called onStartLoading");
        httpHelper = new HttpHelper();
        if(Permissions.checkInternetConnection(mContext)){
            forceLoad();
        }else{
            Toast.makeText(mContext, "Internet connection problem", Toast.LENGTH_SHORT).show();
        }

        super.onStartLoading();
    }

    @Override
    public String loadInBackground() {
        Log.e(TAG,"loadBackground called");
        String guardianJsonStr = null;
        URL url = httpHelper.createUrl(httpHelper.QUERY_URL);
        try {
                guardianJsonStr =  httpHelper.makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guardianJsonStr;
    }

    @Override
    protected void onForceLoad() {
        Log.e(TAG,"onForceLoad called");
        super.onForceLoad();
    }

    @Override
    protected boolean onCancelLoad() {
        Log.e(TAG,"onCancelLoad called");
        return super.onCancelLoad();
    }

}
