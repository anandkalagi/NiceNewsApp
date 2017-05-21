package com.udacity.chaithra.newsapp.connector;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by kalagi on 5/20/2017.
 */



public class HttpHelper {
    public static final String TAG = HttpHelper.class.getName();
    private final String API_KEY = "86e4010e-154b-4443-be2a-87212886b13f";

    public String QUERY_URL = "http://content.guardianapis.com/search?q=debates&api-key="+API_KEY;


    public String  makeHttpRequest(URL url) throws IOException {
        String jsonResponse = null;
        HttpURLConnection connection = null;
        InputStream inputStrem = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.connect();
            if(connection.getResponseCode() == 200){
                inputStrem = connection.getInputStream();
                jsonResponse = readFromStream(inputStrem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStrem != null){
                inputStrem.close();
            }
            if(connection != null){
                connection.disconnect();
            }
        }
        return jsonResponse;
    }

    private String readFromStream(InputStream inputStrem) throws IOException {
        StringBuilder output = new StringBuilder();
        if(inputStrem != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStrem, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line!=null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    public URL createUrl(String strUrl){
        URL url = null;
        try {
            url = new URL(strUrl);
        } catch (MalformedURLException e) {
            Log.e(TAG,"error in create url");
            url = null;
        }
        return url;
    }
}
