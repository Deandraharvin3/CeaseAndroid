package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class Module2Web extends AppCompatActivity {

    WebView wvMod2;
    ImageView ivLesson4;
    String[] results;
    Web view2 = new Web();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2_web);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            results = extras.getStringArray("key");
            view2.setStartWeb(results[0]);
            view2.setEndWeb(results[1]);
        }

        ivLesson4 = findViewById(R.id.ivLesson4);
        wvMod2 = findViewById(R.id.wvMod2);
        view2.showWeb(wvMod2);

//        todo ivLesson4.setVisibility(View.INVISIBLE);

        wvMod2.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                WebView.HitTestResult hr = ((WebView)v).getHitTestResult();
                if(wvMod2.getUrl().equals(view2.getEndWeb())) {
                    ivLesson4.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });

        ivLesson4.setOnClickListener(new View.OnClickListener() {
            String lesson;
            @Override
            public void onClick(View v) {
                switch (results[2]) {
                    case "4":
                        lesson = "lesson4";
                        break;
                    case "5":
                        lesson = "lesson5";
                        break;
                    case "6":
                        lesson = "lesson6";
                        break;
                    default:
                        lesson = "end2";
                        break;
                }

                Intent i = new Intent(Module2Web.this, Module2Complete.class);
                i.putExtra("key",lesson);
                startActivity(i);
            }
        });
    }
}