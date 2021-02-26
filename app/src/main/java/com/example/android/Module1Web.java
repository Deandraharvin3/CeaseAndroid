package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;


public class Module1Web extends AppCompatActivity {
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
        setContentView(R.layout.activity_module1_web);
        myWebView = (WebView) findViewById(R.id.wvLesson2);
        ivMod1 = findViewById(R.id.ivLesson2);
        view1.showWeb(myWebView);

//       todo  ivMod1.setVisibility(View.INVISIBLE);

        myWebView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                WebView.HitTestResult hr = ((WebView)v).getHitTestResult();
                if(myWebView.getUrl().equals(view1.getEndWeb())) {
                    ivMod1.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });

        ivMod1.setOnClickListener(new View.OnClickListener() {
            String lesson;
            @Override
            public void onClick(View v) {
                switch (results[2]) {
                    case "1":
                        lesson = "lesson1";
                        break;
                    case "2":
                        lesson = "lesson2";
                        break;
                    case "3":
                        lesson = "lesson3";
                        break;
                    default:
                        lesson = "end1";
                        break;
                }

                Intent i = new Intent(Module1Web.this, Module1Complete.class);
                i.putExtra("key",lesson);
                startActivity(i);
            }
        });
    }
}