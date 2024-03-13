package com.example.news;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.news.Models.Articles;
import com.example.news.Models.Headlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    EditText etxt;
    Button Search,btnAbt;
    Dialog dg;
    RecyclerView recyView;
    SwipeRefreshLayout swipebttn;

    final String API_KEY = "4185a0e9318a449e91e4283fc86681ff";
    Adapter adptr;
    List<Articles>  articles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dg = new Dialog(MainActivity.this);
        swipebttn = findViewById(R.id.swipeRefresh);
        recyView = findViewById(R.id.recyclerView);
        etxt = findViewById(R.id.etQuery);
        Search = findViewById(R.id.btnSearch);
        btnAbt = findViewById(R.id.aboutUs);


        recyView.setLayoutManager(new LinearLayoutManager(this));
        final String News_cntry = getCountry();


        swipebttn.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveJson("",News_cntry,API_KEY);
            }
        });
        retrieveJson("",News_cntry,API_KEY);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etxt.getText().toString().equals("")){
                    swipebttn.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            retrieveJson(etxt.getText().toString(),News_cntry,API_KEY);
                        }
                    });
                    retrieveJson(etxt.getText().toString(),News_cntry,API_KEY);
                }else{
                    swipebttn.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            retrieveJson("",News_cntry,API_KEY);
                        }
                    });
                    retrieveJson("",News_cntry,API_KEY);
                }
            }
        });

        btnAbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    public void retrieveJson(String query ,String country, String apiKey){


        swipebttn.setRefreshing(true);
        Call<Headlines> news_call;
        if (!etxt.getText().toString().equals("")){
            news_call= ApiClient.getInstance().getApi().getSpecificData(query,apiKey);
        }else{
            news_call= ApiClient.getInstance().getApi().getHeadlines(country,apiKey);
        }

        news_call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> news_call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){
                    swipebttn.setRefreshing(false);
                    articles.clear();
                    articles = response.body().getArticles();
                    adptr = new Adapter(MainActivity.this,articles);
                    recyView.setAdapter(adptr);
                }
            }

            @Override
            public void onFailure(Call<Headlines> news_call, Throwable t) {
                swipebttn.setRefreshing(false);
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }

    public void showDialog(){
        Button clzbtn1;
        dg.setContentView(R.layout.about_us_pop_up);
        dg.show();
        clzbtn1 = dg.findViewById(R.id.close);

        clzbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dg.dismiss();
            }
        });
    }
}
