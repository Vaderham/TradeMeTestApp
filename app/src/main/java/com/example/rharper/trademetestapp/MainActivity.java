package com.example.rharper.trademetestapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rharper.trademetestapp.models.ApiEndpointInterface;
import com.example.rharper.trademetestapp.models.Category;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://api.tmsandbox.co.nz/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiEndpointInterface apiService =
            retrofit.create(ApiEndpointInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button theGoButton = findViewById(R.id.DoTheThing);

        theGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runTheThing();
            }
        });
    }

    public void runTheThing(){
        String catCode = "8739";
        Call<Category> call = apiService.getCategory(catCode);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                int statusCode = response.code();
                Category category = response.body();
                Log.v("Response: ", Integer.toString(statusCode));
                Log.v("Body: ", category.toString());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.e("This fucked up: ", t.toString());
            }
        });
    }
}