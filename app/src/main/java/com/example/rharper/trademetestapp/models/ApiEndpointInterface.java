package com.example.rharper.trademetestapp.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpointInterface {
    @GET("v1/Categories/{categoryId}.json")
    Call<Category> getCategory(@Path("categoryId") String categoryId);

}
