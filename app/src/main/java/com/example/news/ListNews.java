package com.example.news;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import dmax.dialog.SpotsDialog;
import edmt.dev.androidnewsapp.Adapter.ListNewsAdapter;
import edmt.dev.androidnewsapp.Common.Common;
import edmt.dev.androidnewsapp.Interface.NewsService;
import edmt.dev.androidnewsapp.Model.Article;
import edmt.dev.androidnewsapp.Model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNews extends AppCompatActivity {

    KenBurnsView kenburn;
    DiagonalLayout diag;
    AlertDialog dg;
    NewsService mServ;
    TextView author,title;
    SwipeRefreshLayout swipe;

    String source="",sortBy="",webHotURL="";

    ListNewsAdapter adapter;
    RecyclerView lstNews;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);

        //Service
        mServ = Common.getNewsService();

        diag = new SpotsDialog(this);

        //View
        swipe = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadNews(source,true);
            }
        });

        diag = (DiagonalLayout)findViewById(R.id.diagonalLayout);
        diag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(getBaseContext(),DetailArticle.class);
                detail.putExtra("webURL",webHotURL);
                startActivity(detail);
            }
        });
        kenburn = (KenBurnsView)findViewById(R.id.top_image);
        author = (TextView)findViewById(R.id.top_author);
        title = (TextView)findViewById(R.id.top_title);

        lstNews = (RecyclerView)findViewById(R.id.lstNews);
        lstNews.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstNews.setLayoutManager(layoutManager);

        //Intent
        if(getIntent() != null)
        {
            source = getIntent().getStringExtra("source");
            if(!source.isEmpty())
            {
                loadNews(source,false);
            }
        }
    }

    private void loadNews(String source, boolean isRefreshed) {
        if(!isRefreshed)
        {
            dialog.show();
            mServ.getNewestArticles(Common.getAPIUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //Get first article
                            Picasso.get()
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kenburn);

                            top_title.setText(response.body().getArticles().get(0).getTitle());
                            top_author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //Load remain articles
                            List<Article> removeFristItem = response.body().getArticles();
                            //Because we already load first item to show on Diagonal Layout
                            //So we need remove it
                            removeFristItem.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
        }
        else
        {
            dialog.show();
            mServ.getNewestArticles(Common.getAPIUrl(source,sortBy,Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            //Get first article
                            Picasso.get()
                                    .load(response.body().getArticles().get(0).getUrlToImage())
                                    .into(kbv);

                            title.setText(response.body().getArticles().get(0).getTitle());
                            author.setText(response.body().getArticles().get(0).getAuthor());

                            webHotURL = response.body().getArticles().get(0).getUrl();

                            //Load remain articles
                            List<Article> remove = response.body().getArticles();
                            //Because we already load first item to show on Diagonal Layout
                            //So we need remove it
                            remove.remove(0);
                            adapter = new ListNewsAdapter(removeFristItem,getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);

                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
            swipe.setRefreshing(false);
        }
    }
}
