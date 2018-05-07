package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.CategoryRequestHeader;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryUpdater implements HeaderResponseListener{

    /*
    query TM API for category header
    Compare to data in db

    if headers are new
        - Update the current list to the DB
        - Store new header to db

      if the same, leave as is.

    */

    private Context appContext;
    private RetrofitBuilder retroBuilder = new RetrofitBuilder();
    private ApiEndpointInterface ApiInterface = retroBuilder.retrofit.create(ApiEndpointInterface.class);
    private AppDatabase mDb;

    public CategoryUpdater(Context context, AppDatabase db) {
        appContext = context;
        mDb = db;
    }

    public void updateCategoryTree(){
        updateLatestHeader();
    }

    @Override
    public void headerResponseCallback(List<Category> tree) {
            DbAsyncTask updateTree = new DbAsyncTask();
            updateTree.execute(tree);
    }

    private void updateLatestHeader(){
        Call<Category> call = ApiInterface.getCategory("0");
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                List<Category> tree = response.body().getSubcategories();
                headerResponseCallback(tree);
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.v("Etag failed: ", t.toString());
            }
        });
    }

    public class DbAsyncTask extends AsyncTask<List<Category>, Void, Void> {

        @Override
        protected Void doInBackground(List<Category>... lists) {
            List<Category> newTree = lists[0];
            mDb.dbDao().deleteCategoryTree();
            mDb.dbDao().insertNewCategoryTree(newTree);
            Log.v("Tag: ", "Done?");
            return null;
        }
    }

}
