package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.HashMap;
import java.util.Map;

public class Module1Complete extends AppCompatActivity {
    ImageView ivMod2;
    TextView tvComplete;
    String value;


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference users = db.collection("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1_complete);

//        Query query = users.whereEqualTo("email",user.getEmail());
        System.out.println(user.getUid());

        tvComplete = findViewById(R.id.textView5);
        ivMod2 = findViewById(R.id.ivMod2);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("key");

            switch (value) {
                case "lesson1":
                    tvComplete.setText("You have completed Lesson 1!\nClick next to begin Lesson 2");
                    break;
                case "lesson2":
                    tvComplete.setText("You have completed Lesson 2!\nClick next to begin Lesson 3");
                    break;
                case "lesson3":
                    tvComplete.setText("You have completed all of the lessons in Module 1!\nClick next to begin Activities");
                    break;
                default:
                    Map<String, Object> data = new HashMap<>();
                    data.put("passed", true);
// todo test
                    users.getFirestore().document(user.getUid()+"/badges".codePointAt(0)).update(data);
                    tvComplete.setText("You have completed all of the Module 1 activities! This is a big accomplishment- pat yourself on the back!\nClick next to begin Module 2");
                    break;
            }
        }

        ivMod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value.equals("lesson1")) {
                    Intent i = new Intent(Module1Complete.this, Lesson2.class);
                    startActivity(i);
                } else if(value.equals("lesson2")) {
                    Intent i = new Intent(Module1Complete.this, Lesson3.class);
                    startActivity(i);
                } else if(value.equals("lesson3")) {
                    Intent i = new Intent(Module1Complete.this, Main1Activity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(Module1Complete.this, Module2.class);
                    startActivity(i);
                }
            }
        });
    }
}