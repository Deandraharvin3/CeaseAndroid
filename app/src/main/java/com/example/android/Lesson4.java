package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson4 extends AppCompatActivity {

    ImageView btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity12.html", "http://www.ceasewebsite.com/congratsafterlesson4.html", "4"};
                Intent i = new Intent(Lesson4.this, Module2Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });

    }
}