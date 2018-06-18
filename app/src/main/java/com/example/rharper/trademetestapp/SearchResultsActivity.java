package com.example.rharper.trademetestapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.example.rharper.trademetestapp.models.SearchResults;

import retrofit2.Call;

public class SearchResultsActivity extends Activity {

    private RetrofitBuilder retrobuilder = new RetrofitBuilder();
    private ApiEndpointInterface ApiInterface = retrobuilder.retrofit.create(ApiEndpointInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        RecyclerView searchResultsRecycler = findViewById(R.id.SearchResultsRecycler);


    }


    private class getCategorySearch extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
    //        Call<SearchResults> call = ApiInterface.getSearchResults()

            return null;
        }
    }

}
