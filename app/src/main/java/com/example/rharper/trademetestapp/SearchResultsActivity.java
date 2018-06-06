package com.example.rharper.trademetestapp;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;

public class SearchResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        RecyclerView searchResultsRecycler = findViewById(R.id.SearchResultsRecycler);


    }

}
