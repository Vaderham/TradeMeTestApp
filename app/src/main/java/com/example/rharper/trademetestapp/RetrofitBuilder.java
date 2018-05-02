package com.example.rharper.trademetestapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class RetrofitBuilder {

    private static final String BASE_URL = "http://api.tmsandbox.co.nz/";
    private static final String CONSUMER_KEY = "A1AC63F0332A131A78FAC304D007E7D1";
    private static final String CONSUMER_SECRET = "EC7F18B17A062962C6930A8AE88B16C7";
    private static final String CONSUMER_TOKEN = "13238ED1501A8A80DB8062A0CDFC14DB";
    private static final String CONSUMER_TOKEN_SECRET = "A4B286D8F7849F5E30F6D2B1F4745A0B";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(buildClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public OkHttpClient buildClient() {
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(CONSUMER_TOKEN, CONSUMER_TOKEN_SECRET);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer)).build();
        return client;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getConsumerKey() {
        return CONSUMER_KEY;
    }

    public static String getConsumerSecret() {
        return CONSUMER_SECRET;
    }
}