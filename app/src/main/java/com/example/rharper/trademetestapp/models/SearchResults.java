package com.example.rharper.trademetestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResults {

    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("Page")
    @Expose
    private Integer page;
    @SerializedName("PageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("List")
    @Expose
    private List<Listing> list = null;
    @SerializedName("DidYouMean")
    @Expose
    private String didYouMean;


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public java.util.List<Listing> getList() {
        return list;
    }

    public void setList(java.util.List<Listing> list) {
        this.list = list;
    }

    public String getDidYouMean() {
        return didYouMean;
    }

    public void setDidYouMean(String didYouMean) {
        this.didYouMean = didYouMean;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "totalCount=" + totalCount +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", list=" + list +
                ", didYouMean='" + didYouMean + '\'' +
                '}';
    }
}
