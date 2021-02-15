package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson7 extends AppCompatActivity {

    ImageView btn7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson7);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity19.html", "http://www.ceasewebsite.com/new%20activity20.html", "7"};
                Intent i = new Intent(Lesson7.this, Module3Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}