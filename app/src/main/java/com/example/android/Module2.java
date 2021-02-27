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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.android.R.color.cease_purple;

public class Module2 extends AppCompatActivity {
    ImageView mod2btn;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    // do something here
                    i = new Intent(Module2.this, UserView.class);
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(Module1.this, MyPath.class);
//                    break;
                case R.id.nav_lesson:
                    // do something here
                    i = new Intent(Module2.this, Module2.class);

                    break;
                default: i = new Intent(Module2.this,Module2.class);
                    break;
            }
            i.putExtra("lesson", "Mod2");
            startActivity(i);
            return false;
        });

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