package com.example.rharper.trademetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rharper.trademetestapp.models.Listing;

public class ListingViewActivity extends Activity implements OnListingRetrieveCallback {

    ListingService listingService = new ListingService(this);

    ImageView listingImageView;
    TextView titleView;
    TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_view);

        //Find Views in activity
        listingImageView = findViewById(R.id.listingImageView);
        titleView = findViewById(R.id.listingTitleTextView);
        descriptionView = findViewById(R.id.listingDescriptionTextView);

        Intent i = getIntent();
        String listingId = i.getStringExtra("listingId");

        listingService.getListingFromApi(listingId);
    }

    @Override
    public void OnListingRetrieved(Listing listing) {
        Glide.with(this).load(listing.getPictureHref()).into(listingImageView);
        titleView.setText(listing.getTitle());
        descriptionView.setText(listing.getSubtitle());
    }
}
