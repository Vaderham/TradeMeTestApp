package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Room;
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
        mAdapter.setRecyclerClickListener(new OnRecyclerClickListener() {
            @Override
            public void onRecyclerItemClick(int position, View view) {
                Toast.makeText(MainActivity.this, "The thing at position " + position + " was clicked on. Nice!" , Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        Button theGoButton = findViewById(R.id.DoTheThing);

        theGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUpdater.updateCategoryTreeFromApi();
                Log.v("Original Cat List: ", catList.toString());
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
            List<Category> cat = mDb.dbDao().getAllCategories();
            catList.clear();
            catList.addAll(cat);
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