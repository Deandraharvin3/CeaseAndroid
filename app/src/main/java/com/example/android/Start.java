package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Start extends AppCompatActivity {

    ImageView nextbtn;
    TextView tvSignup;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        tvSignup = (TextView) findViewById(R.id.tvSignup);
//        tvSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Start.this, Module1.class);
//                startActivity(i);
//            }
//        });

        nextbtn = findViewById(R.id.nextbtn);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth = FirebaseAuth.getInstance();
                try {
                    if (auth.getCurrentUser() != null) {
                        Intent i = new Intent(Start.this, UserView.class);
                        startActivity(i);
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent i = new Intent(Start.this, Login.class);
                    startActivity(i);
                }


            }
        });
    }
}