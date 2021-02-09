package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class Lesson1Web extends AppCompatActivity {
    private WebView myWebView;
    ImageView ivMod1;
    String[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            results = extras.getStringArray("key");
        }
        setContentView(R.layout.activity_lesson1_web);
        myWebView = (WebView) findViewById(R.id.wvLesson2);
        ivMod1 = findViewById(R.id.ivLesson2);
        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView.setWebViewClient(new WebViewClient());
        // Load the initial URL
        myWebView.loadUrl(results[0]);
        // Enable responsive layout
        myWebView.getSettings().setUseWideViewPort(true);
// Zoom out if the content width is greater than the width of the viewport
        myWebView.getSettings().setLoadWithOverviewMode(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.getSettings().setBuiltInZoomControls(true); // allow pinch to zooom
        myWebView.getSettings().setDisplayZoomControls(false);

        if (myWebView.getUrl().equals(results[1])) {
            ivMod1.setVisibility(View.VISIBLE);
        }
        ivMod1.setOnClickListener(new View.OnClickListener() {
            String lesson;
            @Override
            public void onClick(View v) {
                if (results[2].equals("1")) {
                    lesson = "lesson1";
                } else if(results[2].equals("2")) {
                    lesson = "lesson2";
                }else if(results[2].equals("3")) {
                    lesson = "lesson3";
                }else if(results[2].equals("end1")) {
                    lesson = "end1";
                }

                Intent i = new Intent(Lesson1Web.this, Lesson1Complete.class);
                i.putExtra("key",lesson);
                startActivity(i);
            }
        });
    }
}