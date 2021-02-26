package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main1Activity extends AppCompatActivity {
    ImageView btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        btn2 = findViewById(R.id.btn3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/pathi.html", "http://www.ceasewebsite.com/progress%20module%201.html", "done"};
                Intent i = new Intent(Main1Activity.this, Module1Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}