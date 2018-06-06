package com.example.rharper.trademetestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Listing {

    @SerializedName("ListingId")
    @Expose
    int listingId;

    @SerializedName("Title")
    @Expose
    String title;

    @SerializedName("Category")
    @Expose
    String Category;

    @SerializedName("StartPrice")
    @Expose
    String startPrice;

    @SerializedName("PictureHref")
    @Expose
    URL PictureHref;

    public int getListingId() {
        return listingId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return Category;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public URL getPictureHref() {
        return PictureHref;
    }


    @Override
    public String toString() {
        return "Listing{" +
                "listingId=" + listingId +
                ", title='" + title + '\'' +
                ", Category='" + Category + '\'' +
                ", startPrice='" + startPrice + '\'' +
                ", PictureHref='" + PictureHref + '\'' +
                '}';
    }
}
