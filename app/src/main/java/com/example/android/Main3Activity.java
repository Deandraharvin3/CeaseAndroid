package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    ImageView ivMod3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ivMod3 = findViewById(R.id.ivMod3);

        ivMod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] urls = {"http://www.ceasewebsite.com/dealing%20with%20cravings%20worksheet%20(activity7.0).html", "http://www.ceasewebsite.com/whatsnext.html", "Act3"};
                Intent i = new Intent(Main3Activity.this, Module3Web.class);
                i.putExtra("key", urls);
                startActivity(i);
            }
        });
    }
}