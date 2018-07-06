package com.example.rharper.trademetestapp;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

public class ListingViewActivity extends Activity {

    RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
    ApiEndpointInterface apiEndpointInterface = retrofitBuilder.retrofit.create(ApiEndpointInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_view);

        //Find Views in activity
        ImageView listingImageView = findViewById(R.id.listingImageView);
        TextView titleView = findViewById(R.id.listingTitleTextView);
        TextView descriptionView = findViewById(R.id.listingDescriptionTextView);


    }



}
