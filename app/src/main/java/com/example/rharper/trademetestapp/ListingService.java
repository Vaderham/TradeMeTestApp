package com.example.rharper.trademetestapp;

import android.util.Log;

import com.example.rharper.trademetestapp.models.Listing;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListingService {

    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    ApiEndpointInterface apiEndpointInterface = retrofitBuilder.retrofit.create(ApiEndpointInterface.class);
    OnListingRetrieveCallback onListingRetrieveCallback;

    public ListingService(OnListingRetrieveCallback context) {
        onListingRetrieveCallback = context;
    }

    public void getListingFromApi(String listingId){

        Call<Listing> call = apiEndpointInterface.getListing(listingId);

        call.enqueue(new Callback<Listing>() {
            Listing returnedListing;

            @Override
            public void onResponse(Call<Listing> call, Response<Listing> response) {
                returnedListing = response.body();
                onListingRetrieveCallback.OnListingRetrieved(returnedListing);
            }

            @Override
            public void onFailure(Call<Listing> call, Throwable t) {
                Log.v("Failed: ", t.toString());
            }
        });
        }

}
