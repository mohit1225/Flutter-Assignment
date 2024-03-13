package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Thread splshthread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    Intent splash = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(splash);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });splshthread.start();
    }
}
