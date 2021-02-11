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
    Web view1 = new Web();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            results = extras.getStringArray("key");
            view1.setStartWeb(results[0]);
            view1.setEndWeb(results[1]);
        }
        setContentView(R.layout.activity_lesson1_web);
        myWebView = (WebView) findViewById(R.id.wvLesson2);
        ivMod1 = findViewById(R.id.ivLesson2);
        view1.showWeb(myWebView);

        if (myWebView.getUrl().equals(view1.getEndWeb())) {
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
                }else {
                    lesson = "end1";
                }

                Intent i = new Intent(Lesson1Web.this, Lesson1Complete.class);
                i.putExtra("key",lesson);
                startActivity(i);
            }
        });
    }
}