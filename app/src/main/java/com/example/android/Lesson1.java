package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson1 extends AppCompatActivity {

    ImageView btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        btnStart = findViewById(R.id.btn3);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity1.html", "http://www.ceasewebsite.com/congratsafterlesson1.html", "1"};
                Intent i = new Intent(Lesson1.this, Module1Web.class);
                i.putExtra("key",urls);
                startActivity(i);
            }
        });
    }
}