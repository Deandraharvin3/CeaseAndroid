package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson5 extends AppCompatActivity {

    ImageView btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        btn5 = findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity15.html", "http://www.ceasewebsite.com/congratsafterlesson5.html", "4"};
                Intent i = new Intent(Lesson5.this, Module2Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}