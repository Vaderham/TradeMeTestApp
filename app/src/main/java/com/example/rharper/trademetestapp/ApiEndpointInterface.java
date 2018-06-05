package com.example.rharper.trademetestapp;


import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.Listing;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategory(@Path("categoryId") String categoryId);

    @GET("v1/Search/General.json")
    Call<SearchResults> getSearchResults

    @GET("v1/Listings/{listingId}.json")
    Call<Listing> getListing(@Path("listingId") String listingId);

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategoryCheck(@Path("categoryId") String categoryId);
}