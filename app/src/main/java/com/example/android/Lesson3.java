package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson3 extends AppCompatActivity {
    ImageView btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);
        btn2 = findViewById(R.id.btn3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity%209.html", "http://www.ceasewebsite.com/congratsafterlesson3.html", "3"};
                Intent i = new Intent(Lesson3.this, Module1Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}