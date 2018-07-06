package com.example.rharper.trademetestapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.rharper.trademetestapp.models.Listing;
import com.example.rharper.trademetestapp.models.SearchResults;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchResultsActivity extends Activity {

    private RetrofitBuilder retrobuilder = new RetrofitBuilder();
    private ApiEndpointInterface ApiInterface = retrobuilder.retrofit.create(ApiEndpointInterface.class);

    private RecyclerView searchResultsRecycler;
    private SearchResultsAdapter searchResultsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<Listing> searchResultsList = new ArrayList<>();

    public String iCatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        searchResultsRecycler = findViewById(R.id.SearchResultsRecycler);

        layoutManager = new LinearLayoutManager(this);
        searchResultsRecycler.setLayoutManager(layoutManager);

        searchResultsAdapter = new SearchResultsAdapter(searchResultsList, this);
        searchResultsRecycler.setAdapter(searchResultsAdapter);

        Intent i = getIntent();
        String catId = i.getStringExtra("CatId");
        iCatId = catId;

        getCategorySearch search = new getCategorySearch();
        search.execute();
    }

    private class getCategorySearch extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            Call<SearchResults> call = ApiInterface.getSearchResults(iCatId);
            call.enqueue(new Callback<SearchResults>() {
                @Override
                public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                    ArrayList<Listing> results = (ArrayList<Listing>) response.body().getList();
                    searchResultsList.clear();
                    searchResultsList.addAll(results);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            searchResultsAdapter.notifyDataSetChanged();

                        }
                    });
                }

                @Override
                public void onFailure(Call<SearchResults> call, Throwable t) {
                    Log.e("Failed to retrieve:", call.toString());
                }
            });



            return null;
        }
    }

}
