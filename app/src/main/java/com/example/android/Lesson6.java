package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Lesson6 extends AppCompatActivity {

    ImageView btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/new%20activity18%20or%20animation%20from%20pierce.html", "http://www.ceasewebsite.com/congratsafterlesson6.html", "6"};
                Intent i = new Intent(Lesson6.this, Module2Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}