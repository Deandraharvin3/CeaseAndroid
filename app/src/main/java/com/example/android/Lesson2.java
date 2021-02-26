package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson2 extends AppCompatActivity {
    ImageView btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);
        btn2 = findViewById(R.id.btn3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity%206.html", "http://www.ceasewebsite.com/congratsafterlesson2.html", "2"};
                Intent i = new Intent(Lesson2.this, Module1Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}