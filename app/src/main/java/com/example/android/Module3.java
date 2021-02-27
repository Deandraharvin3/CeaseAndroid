package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Module3 extends AppCompatActivity {

    ImageView btnMod3;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    // do something here
                    i = new Intent(Module3.this, UserView.class);
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(Module1.this, MyPath.class);
//                    break;
                case R.id.nav_lesson:
                    // do something here
                    i = new Intent(Module3.this, Module3.class);

                    break;
                default: i = new Intent(Module3.this,Module3.class);
                    break;
            }
            i.putExtra("lesson", "Mod3");
            startActivity(i);
            return false;
        });

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