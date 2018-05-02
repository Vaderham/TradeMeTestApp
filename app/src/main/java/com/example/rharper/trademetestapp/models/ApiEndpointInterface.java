package com.example.rharper.trademetestapp.models;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategory(@Path("categoryId") String categoryId);


    @GET("v1/Listings/{listingId}.json")
    Call<Listing> getListing(@Path("listingId") String listingId);

}
