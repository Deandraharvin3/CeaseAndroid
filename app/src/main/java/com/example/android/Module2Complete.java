package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Module2Complete extends AppCompatActivity {

    TextView tvComplete;
    ImageView ivNextLesson;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2_complete);

        tvComplete = findViewById(R.id.tvComplete);
        ivNextLesson = findViewById(R.id.ivNextLesson);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

            switch (value) {
                case "lesson4":
                    tvComplete.setText("You have completed Lesson 4!\n Click next to begin Lesson 5");
                    break;
                case "lesson5":
                    tvComplete.setText("You have completed Lesson 5!\n Click next to begin Lesson 6");
                    break;
                default:
                    tvComplete.setText("You have completed all of the Module 2 activities! This is a big accomplishment- pat yourself on the back!\n Click next to begin Module 3");
                    break;
            }
        }

        ivNextLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value.equals("lesson4")) {
                    Intent i = new Intent(Module2Complete.this, Lesson5.class);
                    startActivity(i);
                } else if(value.equals("lesson5")) {
                    Intent i = new Intent(Module2Complete.this, Lesson6.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Module2Complete.this, Module3.class);
                    startActivity(i);
                }
            }
        });

    }
}