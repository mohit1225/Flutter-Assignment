package com.example.news.Remote;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Icon {
    private static Retrofit retrft=null;
    public static Retrofit getClient()
    {
        if(retrft == null)
        {
            retrft = new Retrofit.Builder()
                    .baseUrl("https://icons.better-idea.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrft;
    }
}