package com.udacity.chaithra.newsapp.controler;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.udacity.chaithra.newsapp.model.ResultObject;
import com.udacity.chaithra.newsapp.view.NewsDashboard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kalagi on 5/21/2017.
 */

public class NewsJsonStringParser {

    ArrayList<ResultObject> guardianDataList;

    public ArrayList<ResultObject> parseJsonStr(String guardianJsonStr){
        guardianDataList = new ArrayList<>();
        try {
            JSONObject guardianNewsResponse = new JSONObject(guardianJsonStr).getJSONObject("response");
            JSONArray guardianNewsResults = guardianNewsResponse.getJSONArray("results");

            for (int i = 0; i < guardianNewsResults.length();i++) {
                JSONObject jsonObject = (JSONObject) guardianNewsResults.get(i);
                ResultObject resultObject = new ResultObject();
                resultObject.setId(jsonObject.getString("id"));
                resultObject.setType(jsonObject.getString("type"));
                resultObject.setSectionId(jsonObject.getString("sectionId"));
                SimpleDateFormat dateFormat = new SimpleDateFormat();
                resultObject.setWebPublicationDate(new Date());//jsonObject.getString("webPublicationDate")
                resultObject.setSectionName(jsonObject.getString("sectionName"));
                resultObject.setWebTitle(jsonObject.getString("webTitle"));
                resultObject.setWebUrl(jsonObject.getString("webUrl"));
                resultObject.setApiUrl(jsonObject.getString("apiUrl"));
                resultObject.setIsHosted(jsonObject.getBoolean("isHosted"));
                guardianDataList.add(resultObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return guardianDataList;
    }

}
