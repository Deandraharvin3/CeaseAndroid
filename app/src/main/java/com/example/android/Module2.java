package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.android.R.color.cease_purple;

public class Module2 extends AppCompatActivity {
    ImageView mod2btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);

        getActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(cease_purple)));
        mod2btn = findViewById(R.id.mod2btn);
        mod2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Module2.this, Lesson4.class);
                startActivity(i);
            }
        });
    }
}