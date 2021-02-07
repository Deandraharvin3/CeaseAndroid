package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Mod1Question2 extends AppCompatActivity {

    TextView tvResponse;
    Button btnTrue, btnFalse, btnQuestion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod1_question2);
        tvResponse = findViewById(R.id.tvResponse);
        btnQuestion3 = findViewById(R.id.btnQuestion3);
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
                tvResponse.setText("Correct! \n Tar: used for paving roads and coating roofs");
                btnQuestion3.setVisibility(View.VISIBLE);
                btnQuestion3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Mod1Question2.this, Mod1Question3.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}