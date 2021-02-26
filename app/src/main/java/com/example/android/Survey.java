package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class Survey extends AppCompatActivity {
    private WebView wvSurvey;
    private ImageView ivStartMod;
    private Web surveyView = new Web();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        wvSurvey = findViewById(R.id.wvSurvey);
        ivStartMod = findViewById(R.id.ivStartMod);
        ivStartMod.setVisibility(View.INVISIBLE);

        surveyView.setStartWeb("http://www.ceasewebsite.com/readinesssurvey.html");
        surveyView.setEndWeb("http://www.ceasewebsite.com/module1.html");
        surveyView.showWeb(wvSurvey);

//        wvSurvey.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//                WebView.HitTestResult hr = ((WebView)v).getHitTestResult();
//                System.out.println("HR results: " + hr);
//                return false;
//            }
//        });

        ivStartMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Survey.this, Module1.class);
                startActivity(i);
            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        while (!wvSurvey.getUrl().equals(surveyView.getEndWeb())) {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println("Loading...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        ivStartMod.setVisibility(View.VISIBLE);
//
//    }


}