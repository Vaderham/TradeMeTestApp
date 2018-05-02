package com.example.rharper.trademetestapp.models;

public class Listing {

    int listingId;
    String title;
    String Category;
    String startPrice;
    int PhotoId;
    String ShortDescription;

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

    public int getPhotoId() {
        return PhotoId;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingId=" + listingId +
                ", title='" + title + '\'' +
                ", Category='" + Category + '\'' +
                ", startPrice='" + startPrice + '\'' +
                ", PhotoId=" + PhotoId +
                ", ShortDescription='" + ShortDescription + '\'' +
                '}';
    }
}
