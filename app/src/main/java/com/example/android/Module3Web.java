package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

public class Module3Web extends AppCompatActivity {

    WebView wvMod3;
    ImageView ivLesson7;
    String[] results;
    Web view3 = new Web();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3_web);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            results = extras.getStringArray("key");
            view3.setStartWeb(results[0]);
            view3.setEndWeb(results[1]);
        }
        ivLesson7 = findViewById(R.id.ivLesson7);
        wvMod3 = findViewById(R.id.wvMod3);
        view3.showWeb(wvMod3);

        if (wvMod3.getUrl().equals(view3.getEndWeb())) {
            ivLesson7.setVisibility(View.VISIBLE);
        }

        ivLesson7.setOnClickListener(new View.OnClickListener() {
            String lesson;
            @Override
            public void onClick(View v) {
                if (results[2].equals("7")) {
                    lesson = "lesson4";
                }else if(results[2].equals("Act3")) {
                    lesson = "activity";
                }else {
                    lesson = "end3";
                }

                Intent i = new Intent(Module3Web.this, Module3Complete.class);
                i.putExtra("key",lesson);
                startActivity(i);
            }
        });

    }

}