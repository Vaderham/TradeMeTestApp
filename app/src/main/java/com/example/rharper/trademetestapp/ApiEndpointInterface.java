package com.example.rharper.trademetestapp;

import android.support.annotation.NonNull;

import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.CategoryRequestHeader;
import com.example.rharper.trademetestapp.models.Listing;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategory(@Path("categoryId") String categoryId);


    @GET("v1/Listings/{listingId}.json")
    Call<Listing> getListing(@Path("listingId") String listingId);

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategoryCheck(@Path("categoryId") String categoryId);
}