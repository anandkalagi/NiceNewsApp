package com.udacity.chaithra.newsapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by kalagi on 5/20/2017.
 */

public class Permissions {
    //check internet enabled or not

    public static boolean checkInternetConnection(Context context){
        boolean isConnectWifi = false;
        boolean isConnectMobile = false;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfo = manager.getAllNetworkInfo();
        for (NetworkInfo info:networkInfo) {
            if(info.getTypeName().equalsIgnoreCase("WIFI")){
                if (info.isConnected()){
                    isConnectWifi = true;
                }
            }
            if(info.getTypeName().equalsIgnoreCase("MOBILE")){
                if (info.isConnected()){
                    isConnectMobile = true;
                }
            }
        }
        return isConnectWifi ||isConnectMobile;
    }

}
