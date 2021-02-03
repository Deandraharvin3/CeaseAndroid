package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mod1Question1 extends AppCompatActivity {
    TextView tvResponse;
    Button btnTrue, btnFalse, btnQuestion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod1_question1);

        tvResponse = findViewById(R.id.tvResponse);
        btnQuestion2 = findViewById(R.id.btnQuestion2);
        btnFalse = findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResponse.setText("Try again!");

            }
        });
        btnTrue = findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResponse.setText("Correct! \n Toluene is used to manufacture paint.");
                btnQuestion2.setVisibility(View.VISIBLE);
                btnQuestion2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Mod1Question1.this, Mod1Question2.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}