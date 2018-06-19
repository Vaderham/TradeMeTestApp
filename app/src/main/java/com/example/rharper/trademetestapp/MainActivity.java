package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rharper.trademetestapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDbTaskCompleted{

    private RecyclerView mRecyclerView;
    private CategoryListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Category> catList = new ArrayList<>();
    CategoryUpdater mUpdater;
    CategoryNavigator categoryNavigator;
    AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "category.db")
                .fallbackToDestructiveMigration()
                .build();

        mUpdater = new CategoryUpdater(mDb, this);

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new CategoryListAdapter(catList);
        mAdapter.setRecyclerClickListener(new OnRecyclerClickListener() {
            @Override
            public void onRecyclerItemClick(int position, View view) {
                ArrayList<Category> newList = (ArrayList<Category>) categoryNavigator.moveUp(position);
                catList.clear();
                catList.addAll(newList);
                mAdapter.notifyDataSetChanged();
                mRecyclerView.scrollToPosition(0);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        Button theGoButton = findViewById(R.id.DoTheThing);
        Button searchButton = findViewById(R.id.search);

        theGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUpdater.updateCategoryTreeFromApi();
                Log.v("Original Cat List: ", catList.toString());
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SearchResultsActivity.class);
                i.putExtra("CatId", categoryNavigator.getCurrentCategoryId());
                startActivity(i);
            }
        });

        getCategoryFromDb getCategoryFromDb = new getCategoryFromDb();
        getCategoryFromDb.execute();
        }

    @Override
    public void onBackPressed() {
        if(categoryNavigator.getHistorySize() > 1){
            Toast.makeText(this, "Back button pressed. > 0.", Toast.LENGTH_SHORT).show();
            ArrayList<Category> newList = (ArrayList<Category>) categoryNavigator.moveDown();
            catList.clear();
            catList.addAll(newList);
            mAdapter.notifyDataSetChanged();
            mRecyclerView.scrollToPosition(0);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void categoryReadyCallback() {
        getCategoryFromDb getCategoryFromDb = new getCategoryFromDb();
        getCategoryFromDb.execute();
    }

    class getCategoryFromDb extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            List<Category> cat = mDb.dbDao().getAllCategories();
            catList.clear();
            catList.addAll(cat);
            categoryNavigator = new CategoryNavigator(catList);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mAdapter.notifyDataSetChanged();
                }
            });
            return null;
        }
    }
}