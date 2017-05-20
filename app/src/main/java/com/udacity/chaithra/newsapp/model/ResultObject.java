package com.udacity.chaithra.newsapp.model;

import java.util.Date;

/**
 * Created by kalagi on 5/20/2017.
 */

public class ResultObject
{
    private String id;

    public String getId() { return this.id; }

    public void setId(String id) { this.id = id; }

    private String type;

    public String getType() { return this.type; }

    public void setType(String type) { this.type = type; }

    private String sectionId;

    public String getSectionId() { return this.sectionId; }

    public void setSectionId(String sectionId) { this.sectionId = sectionId; }

    private String sectionName;

    public String getSectionName() { return this.sectionName; }

    public void setSectionName(String sectionName) { this.sectionName = sectionName; }

    private Date webPublicationDate;

    public Date getWebPublicationDate() { return this.webPublicationDate; }

    public void setWebPublicationDate(Date webPublicationDate) { this.webPublicationDate = webPublicationDate; }

    private String webTitle;

    public String getWebTitle() { return this.webTitle; }

    public void setWebTitle(String webTitle) { this.webTitle = webTitle; }

    private String webUrl;

    public String getWebUrl() { return this.webUrl; }

    public void setWebUrl(String webUrl) { this.webUrl = webUrl; }

    private String apiUrl;

    public String getApiUrl() { return this.apiUrl; }

    public void setApiUrl(String apiUrl) { this.apiUrl = apiUrl; }

    private boolean isHosted;

    public boolean getIsHosted() { return this.isHosted; }

    public void setIsHosted(boolean isHosted) { this.isHosted = isHosted; }
}