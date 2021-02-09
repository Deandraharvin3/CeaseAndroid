package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Lesson1Complete extends AppCompatActivity {
    ImageView ivMod2;
    TextView tvComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_complete);

        tvComplete = findViewById(R.id.textView5);
        ivMod2 = findViewById(R.id.ivMod2);
        ivMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lesson1Complete.this, Lesson2.class);
                startActivity(i);
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            if(value.equals("lesson2")) {
                tvComplete.setText("Congratulations, you have completed Lesson 2!");
            }
        }
    }
}