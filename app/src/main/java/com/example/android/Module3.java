package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Module3 extends AppCompatActivity {

    ImageView btnMod3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);

        btnMod3 = findViewById(R.id.mod3btn);
        btnMod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Module3.this, Lesson7.class);
                startActivity(i);
            }
        });
    }
}