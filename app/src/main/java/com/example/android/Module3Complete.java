package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Module3Complete extends AppCompatActivity {

    TextView tvComplete3;
    ImageView ivNextAct;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module3_complete);

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
                    Intent i = new Intent(Module3Complete.this, Login.class);
                    startActivity(i);
                }
            }
        });

    }
}