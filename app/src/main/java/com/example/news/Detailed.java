package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
public class Detailed extends AppCompatActivity {

    TextView tytl,source1,tvTime,destv;
    ImageView imgvw;
    WebView webv;
    ProgressBar ploader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
//        getSupportActionBar().setTitle("Bulletin Details");
//     getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvTime = findViewById(R.id.tvDate);
        destv = findViewById(R.id.tvDesc);
        tytl = findViewById(R.id.tvTitle);
        source1 = findViewById(R.id.tvSource);

        imgvw = findViewById(R.id.imageView);

        webv = findViewById(R.id.webView);

        ploader = findViewById(R.id.webViewLoader);
        ploader.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String titleart = intent.getStringExtra("title");
        String sourceart = intent.getStringExtra("source");
        String arttym = intent.getStringExtra("time");
        String dysart = intent.getStringExtra("desc");
        String imgurl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");


        tytl.setText(titleart);
        source1.setText(sourceart);
        tvTime.setText(arttym);
        destv.setText(dysart);

        Picasso.with(Detailed.this).load(imgurl).into(imgvw);

        webv.getSettings().setDomStorageEnabled(true);
        webv.getSettings().setJavaScriptEnabled(true);
        webv.getSettings().setLoadsImagesAutomatically(true);
        webv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webv.setWebViewClient(new WebViewClient());
        webv.loadUrl(url);
        if (webv.isShown()){
            ploader.setVisibility(View.INVISIBLE);
        }
    }
}
