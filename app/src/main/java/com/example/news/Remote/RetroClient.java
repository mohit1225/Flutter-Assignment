package com.example.news.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrft=null;
    public static Retrofit getClient(String baseUrl)
    {
        if(retrft == null)
        {
            retrft = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrft;
    }
}