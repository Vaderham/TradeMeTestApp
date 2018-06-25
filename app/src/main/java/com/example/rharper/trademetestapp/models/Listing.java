package com.example.rharper.trademetestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;

public class Listing {

    @SerializedName("ListingId")
    @Expose
    private Integer listingId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("StartPrice")
    @Expose
    private Double startPrice;
    @SerializedName("BuyNowPrice")
    @Expose
    private Double buyNowPrice;
    @SerializedName("StartDate")
    @Expose
    private String startDate;
    @SerializedName("EndDate")
    @Expose
    private String endDate;
    @SerializedName("ListingLength")
    @Expose
    private Object listingLength;
    @SerializedName("IsFeatured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("HasGallery")
    @Expose
    private Boolean hasGallery;
    @SerializedName("IsBold")
    @Expose
    private Boolean isBold;
    @SerializedName("AsAt")
    @Expose
    private String asAt;
    @SerializedName("CategoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("PictureHref")
    @Expose
    private String pictureHref;
    @SerializedName("IsNew")
    @Expose
    private Boolean isNew;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("Suburb")
    @Expose
    private String suburb;
    @SerializedName("HasBuyNow")
    @Expose
    private Boolean hasBuyNow;
    @SerializedName("NoteDate")
    @Expose
    private String noteDate;
    @SerializedName("Subtitle")
    @Expose
    private String subtitle;
    @SerializedName("PriceDisplay")
    @Expose
    private String priceDisplay;
    @SerializedName("PromotionId")
    @Expose
    private Integer promotionId;

    @SerializedName("MemberId")
    @Expose
    private Integer memberId;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Object getListingLength() {
        return listingLength;
    }

    public void setListingLength(Object listingLength) {
        this.listingLength = listingLength;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Boolean getHasGallery() {
        return hasGallery;
    }

    public void setHasGallery(Boolean hasGallery) {
        this.hasGallery = hasGallery;
    }

    public Boolean getIsBold() {
        return isBold;
    }

    public void setIsBold(Boolean isBold) {
        this.isBold = isBold;
    }

    public String getAsAt() {
        return asAt;
    }

    public void setAsAt(String asAt) {
        this.asAt = asAt;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Boolean getHasBuyNow() {
        return hasBuyNow;
    }

    public void setHasBuyNow(Boolean hasBuyNow) {
        this.hasBuyNow = hasBuyNow;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingId=" + listingId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", startPrice=" + startPrice +
                ", buyNowPrice=" + buyNowPrice +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", listingLength=" + listingLength +
                ", isFeatured=" + isFeatured +
                ", hasGallery=" + hasGallery +
                ", isBold=" + isBold +
                ", asAt='" + asAt + '\'' +
                ", categoryPath='" + categoryPath + '\'' +
                ", pictureHref='" + pictureHref + '\'' +
                ", isNew=" + isNew +
                ", region='" + region + '\'' +
                ", suburb='" + suburb + '\'' +
                ", hasBuyNow=" + hasBuyNow +
                ", noteDate='" + noteDate + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", priceDisplay='" + priceDisplay + '\'' +
                ", promotionId=" + promotionId +
                ", memberId=" + memberId +
                '}';
    }
}
