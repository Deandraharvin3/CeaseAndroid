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
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_complete);

        tvComplete = findViewById(R.id.textView5);
        ivMod2 = findViewById(R.id.ivMod2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

            switch (value) {
                case "lesson1":
                    tvComplete.setText("You have completed Lesson 1!\nClick next to begin Lesson 2");
                    break;
                case "lesson2":
                    tvComplete.setText("You have completed Lesson 2!\nClick next to begin Lesson 3");
                    break;
                case "lesson3":
                    tvComplete.setText("You have completed all of the lessons in Module 1!\nClick next to begin Activities");
                    break;
                default:
                    tvComplete.setText("You have completed all of the Module 1 activities! This is a big accomplishment- pat yourself on the back!\nClick next to begin Module 2");
                    break;
            }
        }

        ivMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value.equals("lesson1")) {
                    Intent i = new Intent(Lesson1Complete.this, Lesson2.class);
                    startActivity(i);
                } else if(value.equals("lesson2")) {
                    Intent i = new Intent(Lesson1Complete.this, Lesson3.class);
                    startActivity(i);
                } else if(value.equals("lesson3")) {
                    Intent i = new Intent(Lesson1Complete.this, Main1Activity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Lesson1Complete.this, Module2.class);
                    startActivity(i);
                }
            }
        });
    }
}