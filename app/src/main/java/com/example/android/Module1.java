package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Module1 extends AppCompatActivity {

    ImageView mod1btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);

        mod1btn = findViewById(R.id.mod1btn);
        mod1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Module1.this, Lesson1.class);
                startActivity(i);
            }
        });
    }
}