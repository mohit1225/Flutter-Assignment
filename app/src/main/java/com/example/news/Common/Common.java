package com.example.news.Common;

import com.example.news.Interface.IconBetterIdeaService;
import com.example.news.Interface.NewsService;
import com.example.news.Model.IconBetterIdea;
import com.example.news.Remote.IconBetterIdeaClient;
import com.example.news.Interface.RemoteRetrofitClient;


public class Common {
    private static final String Base_app_url_one="https://newsapi.org/";

    public  static final String API_KEY="4185a0e9318a449e91e4283fc86681ff"; 

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(Base_app_url_one).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    
    public static String getAPIUrl(String source,String sortBy,String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }


}