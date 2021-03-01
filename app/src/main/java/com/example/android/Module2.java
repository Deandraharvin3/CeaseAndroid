package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
                case R.id.nav_dash:
                    // do something here
                    i = new Intent(Module2.this, Dashboard.class);
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(Module1.this, MyPath.class);
//                    break;
                case R.id.nav_main:
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