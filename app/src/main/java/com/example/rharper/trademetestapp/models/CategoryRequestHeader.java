package com.example.rharper.trademetestapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "category_request_header")
public class CategoryRequestHeader {

    @SerializedName("Accept-Ranges")
    @Expose
    private String AcceptRanges;

    @SerializedName("Access-Control-Allow-Origin")
    @Expose
    private String AccessControl;

    @SerializedName("Age")
    @Expose
    private int age;

    @SerializedName("Connection")
    @Expose
    private String Connection;

    @SerializedName("Content-Encoding")
    @Expose
    private String ContentEncoding;

    @SerializedName("Content-Length")
    @Expose
    private Long ContentLength;

    @SerializedName("Content-Type")
    @Expose
    private String applicationjson;

    @SerializedName("Date")
    @Expose
    private String date;

    @PrimaryKey
    @SerializedName("Etag")
    @Expose
    @NonNull
    private String etag;

    @SerializedName("Vary")
    @Expose
    private String cary;

    public String getAcceptRanges() {
        return AcceptRanges;
    }

    public String getAccessControl() {
        return AccessControl;
    }

    public int getAge() {
        return age;
    }

    public String getConnection() {
        return Connection;
    }

    public String getContentEncoding() {
        return ContentEncoding;
    }

    public Long getContentLength() {
        return ContentLength;
    }

    public String getApplicationjson() {
        return applicationjson;
    }

    public String getDate() {
        return date;
    }

    public String getEtag() {
        return etag;
    }

    public String getCary() {
        return cary;
    }

    public void setAcceptRanges(String acceptRanges) {
        AcceptRanges = acceptRanges;
    }

    public void setAccessControl(String accessControl) {
        AccessControl = accessControl;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setConnection(String connection) {
        Connection = connection;
    }

    public void setContentEncoding(String contentEncoding) {
        ContentEncoding = contentEncoding;
    }

    public void setContentLength(Long contentLength) {
        ContentLength = contentLength;
    }

    public void setApplicationjson(String applicationjson) {
        this.applicationjson = applicationjson;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setCary(String cary) {
        this.cary = cary;
    }
}
