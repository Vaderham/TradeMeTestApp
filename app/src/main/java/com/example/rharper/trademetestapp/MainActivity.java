package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rharper.trademetestapp.models.Category;
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.http2.Http2Connection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> catList = new ArrayList<>();
    CategoryUpdater mUpdater;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "category.db")
                .fallbackToDestructiveMigration()
                .build();

         mUpdater = new CategoryUpdater(this, db);

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
                runTheThing();
            }
        });
        }

    public void runTheThing(){
        mUpdater.updateCategoryTree();
    }
}