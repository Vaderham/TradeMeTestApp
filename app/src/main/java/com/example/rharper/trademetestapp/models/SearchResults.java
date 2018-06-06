package com.example.rharper.trademetestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResults {

    @SerializedName("Page")
    @Expose
    private int page;

    @SerializedName("PageSize")
    @Expose
    private int pageSize;

    @SerializedName("Listings")
    @Expose
    private List<Listing> listings;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}
