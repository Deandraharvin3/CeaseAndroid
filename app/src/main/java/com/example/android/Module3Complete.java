package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Module3Complete extends AppCompatActivity {

    TextView tvComplete3;
    ImageView ivNextAct;
    String value;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3_complete);

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.nav_profile:
//                    // do something here
//                    i = new Intent(Module3Complete.this, UserView.class);
//                    break;
////                case R.id.nav_path:
////                    // do something here
////                    i = new Intent(Module1.this, MyPath.class);
////                    break;
//                case R.id.nav_lesson:
//                    // do something here
//                    i = new Intent(Module3Complete.this, Module3Complete.class);
//
//                    break;
//                default: i = new Intent(Module3Complete.this, Module3Complete.class);
//                    break;
//            }
//            i.putExtra("lesson", "Mod3Complete");
//            startActivity(i);
//            return false;
//        });

        tvComplete3 = findViewById(R.id.tvComplete3);
        ivNextAct = findViewById(R.id.ivNextAct);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

            if (value.equals("activity")) {
                tvComplete3.setText("You have completed all modules CONGRATS!");
            }
        }

        ivNextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value.equals("lesson7")) {
                    Intent i = new Intent(Module3Complete.this, Main3Activity.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(Module3Complete.this, Start.class);
                    startActivity(i);
                }
            }
        });

    }
}