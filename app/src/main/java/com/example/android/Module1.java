package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Module1 extends AppCompatActivity {

    ImageView mod1btn;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_module1);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    // do something here
                    i = new Intent(Module1.this, UserView.class);
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(Module1.this, MyPath.class);
//                    break;
                case R.id.nav_lesson:
                    // do something here
                    i = new Intent(Module1.this, Module1.class);

                    break;
                default: i = new Intent(Module1.this,Module1.class);
                break;
            }
            i.putExtra("lesson", "Mod1");
            startActivity(i);
            return false;
        });

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