package com.example.rharper.trademetestapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.rharper.trademetestapp.models.ApiEndpointInterface;
import com.example.rharper.trademetestapp.models.Category;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> catList = new ArrayList<>();

    RetrofitBuilder retroBuilder = new RetrofitBuilder();

    ApiEndpointInterface apiService =
            retroBuilder.retrofit.create(ApiEndpointInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        String catCode = "";

        Call<Category> call = apiService.getCategory(catCode);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(@NonNull Call<Category> call, @NonNull Response<Category> response) {
                List<Category> categoryList = response.body().getSubcategories();
                for (int i = 0; i < categoryList.size(); i++){
                    catList.add(categoryList.get(i).getName());
                    Log.v("The thing: ", catList.get(i));
                }
            //    mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
    }
}