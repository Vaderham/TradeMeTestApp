package com.example.rharper.trademetestapp;

import android.os.AsyncTask;

import com.example.rharper.trademetestapp.models.Category;

import java.util.List;

public class DbAsyncTask extends AsyncTask<List<Category>, Void, Void> {

    AppDatabase mDb;
    OnDbTaskCompleted taskCompleted;

    public DbAsyncTask(AppDatabase mDb, OnDbTaskCompleted taskCompleted) {
        this.mDb = mDb;
        this.taskCompleted = taskCompleted;
    }

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
        taskCompleted.categoryReadyCallback();
    }
}
