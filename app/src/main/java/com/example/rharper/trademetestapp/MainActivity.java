package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.rharper.trademetestapp.models.Category;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDbTaskCompleted{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Category> catList = new ArrayList<>();
    CategoryUpdater mUpdater;
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
        mRecyclerView.setAdapter(mAdapter);

        Button theGoButton = findViewById(R.id.DoTheThing);

        theGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUpdater.updateCategoryTreeFromApi();
            }
        });

        }

    @Override
    public void categoryReadyCallback() {
        getCategoryFromDb getCategoryFromDb = new getCategoryFromDb();
        getCategoryFromDb.execute();
    }

    class getCategoryFromDb extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            catList = mDb.dbDao().getAllCategories();
            mAdapter.notifyDataSetChanged();
            return null;
        }
    }

}