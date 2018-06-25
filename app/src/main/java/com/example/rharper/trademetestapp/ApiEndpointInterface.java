package com.example.rharper.trademetestapp;


import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.Listing;
import com.example.rharper.trademetestapp.models.SearchResults;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpointInterface {

    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategory(@Path("categoryId") String categoryId);

    @GET("v1/Search/General.json")
    Call<SearchResults> getSearchResults(@Query("category_id") String category);

    @GET("v1/Listings/{listingId}.json")
    Call<Listing> getListing(@Path("listingId") String listingId);
}