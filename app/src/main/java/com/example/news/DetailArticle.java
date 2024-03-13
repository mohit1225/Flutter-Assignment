package com.example.news;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dmax.dialog.SpotsDialog;

public class DetailArticle extends AppCompatActivity {

    AlertDialog article_diag;
    WebView wv;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        article_diag = new SpotsDialog(this);
        article_diag.show();
        //WebView
        wv = (WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebChromeClient(new WebChromeClient());
        wv.setWebViewClient(new WebViewClient(){

            //press Ctrl+O

            @Override
            public void onPageFinished(WebView view, String url) {
                article_diag.dismiss();
            }
        });

        if(getIntent() != null)
        {
            if(!getIntent().getStringExtra("webURL").isEmpty())
                wv.loadUrl(getIntent().getStringExtra("webURL"));
        }
    }
}
