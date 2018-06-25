package com.example.rharper.trademetestapp;

import android.util.Log;

import com.example.rharper.trademetestapp.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryUpdater {

    private RetrofitBuilder retroBuilder = new RetrofitBuilder();
    private ApiEndpointInterface ApiInterface = retroBuilder.retrofit.create(ApiEndpointInterface.class);
    private AppDatabase mDb;
    public OnDbTaskCompleted mContext;

    public CategoryUpdater(AppDatabase db, OnDbTaskCompleted context) {
        mDb = db;
        mContext = context;
    }

    public void updateCategoryTreeFromApi(){
            Call<Category> call = ApiInterface.getCategory("0");
            call.enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Call<Category> call, Response<Category> response) {
                        List<Category> tree = response.body().getSubcategories();
                        DbAsyncTask storeCatTree = new DbAsyncTask(mDb, mContext);
                        storeCatTree.execute(tree);

                }

                @Override
                public void onFailure(Call<Category> call, Throwable t) {
                    Log.v("Etag failed: ", t.toString());
                }
            });
    }



}
