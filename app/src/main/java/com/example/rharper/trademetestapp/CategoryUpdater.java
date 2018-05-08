package com.example.rharper.trademetestapp;

import android.content.Context;
import android.os.AsyncTask;
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
    private Context mContext;

    public CategoryUpdater(AppDatabase db, Context context) {
        mDb = db;
        mContext = context;
    }

    public void updateCategoryTreeFromApi(){
        Call<Category> call = ApiInterface.getCategory("0");
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                List<Category> tree = response.body().getSubcategories();
                DbAsyncTask storeCatTree = new DbAsyncTask();
                storeCatTree.execute(tree);
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.v("Etag failed: ", t.toString());
            }
        });
    }

    public class DbAsyncTask extends AsyncTask<List<Category>, Void, Void>{

        @Override
        protected Void doInBackground(List<Category>... lists) {
            List<Category> newTree = lists[0];
            mDb.dbDao().deleteCategoryTree();
            mDb.dbDao().insertNewCategoryTree(newTree);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }
    }

}
