package com.example.news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static ApiClient api_clnt;
    private static Retrofit api_retro;

    private ApiClient(){
        api_retro = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if (api_clnt == null){
            api_clnt = new ApiClient();
        }
        return api_clnt;
    }


    public ApiInterface getApi(){
        return api_retro.create(ApiInterface.class);
    }
}
