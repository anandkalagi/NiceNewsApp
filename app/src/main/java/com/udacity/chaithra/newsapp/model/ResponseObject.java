package com.udacity.chaithra.newsapp.model;

import java.util.ArrayList;

/**
 * Created by kalagi on 5/20/2017.
 */

public class ResponseObject
{
    private String status;

    public String getStatus() { return this.status; }

    public void setStatus(String status) { this.status = status; }

    private String userTier;

    public String getUserTier() { return this.userTier; }

    public void setUserTier(String userTier) { this.userTier = userTier; }

    private int total;

    public int getTotal() { return this.total; }

    public void setTotal(int total) { this.total = total; }

    private int startIndex;

    public int getStartIndex() { return this.startIndex; }

    public void setStartIndex(int startIndex) { this.startIndex = startIndex; }

    private int pageSize;

    public int getPageSize() { return this.pageSize; }

    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    private int currentPage;

    public int getCurrentPage() { return this.currentPage; }

    public void setCurrentPage(int currentPage) { this.currentPage = currentPage; }

    private int pages;

    public int getPages() { return this.pages; }

    public void setPages(int pages) { this.pages = pages; }

    private String orderBy;

    public String getOrderBy() { return this.orderBy; }

    public void setOrderBy(String orderBy) { this.orderBy = orderBy; }

    private ArrayList<ResultObject> results;

    public ArrayList<ResultObject> getResults() { return this.results; }

    public void setResults(ArrayList<ResultObject> results) { this.results = results; }
}


