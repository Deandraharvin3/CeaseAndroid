package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;
import java.util.Objects;

public class Lessons extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//    CollectionReference users = db.collection("modules");
//    DocumentReference users = db.document("modules/"+user.getUid());

    Intent i;
    DocumentReference completed = db.collection("modules").document(user.getUid());

    ImageView ivBackLesson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        TextView tvM1L1 = (TextView) findViewById(R.id.tvM1L1);
        TextView tvM2L4 = (TextView) findViewById(R.id.tvM2L4);
        TextView tvM3L7 = (TextView) findViewById(R.id.tvM3L7);
        TextView tvL2 = (TextView) findViewById(R.id.tvL2);
        TextView tvL3 = (TextView) findViewById(R.id.tvL3);
        TextView tvL5 = (TextView) findViewById(R.id.tvL5);
        TextView tvL6 = (TextView) findViewById(R.id.tvL6);
        TextView tvAct1 = (TextView) findViewById(R.id.tvAct1);
        TextView tvAct2 = (TextView) findViewById(R.id.tvAct2);

        ivBackLesson = findViewById(R.id.ivBackLesson);

        ivBackLesson.setOnClickListener(v -> finish());


//        Keeping track od which modules are completed
        completed.get().addOnSuccessListener(documentSnapshot -> {
            Map<String, Object> complete = documentSnapshot.getData();
            for (Map.Entry<String, Object> entry : complete.entrySet()) {
                if (entry.getKey().equals("module_1")) {
                    Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : lesson.entrySet()) {
                        switch (e.getKey()) {
                            case "lesson_1": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvM1L1.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvM1L1.setOnClickListener(v -> {
                                                i = new Intent(Lessons.this, Lesson2.class);
                                                startActivity(i);
                                            });
                                        }
                                    }
                                }
                                break;
                            }
                            case "lesson_2": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvL2.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvL2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    i = new Intent(Lessons.this, Lesson3.class);
                                                    startActivity(i);
                                                }
                                            });

                                        }
                                    }
                                }
                                break;
                            }
                            case "lesson_3": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvL3.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvL3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    i = new Intent(Lessons.this, Main1Activity.class);
                                                    startActivity(i);
                                                }
                                            });

                                        }
                                    }
                                }
                                break;
                            }
                        }

                    }
                } else if(entry.getKey().equals("module_2")) {
                    Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : lesson.entrySet()) {
                        switch (e.getKey()) {
                            case "lesson_4": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvM2L4.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvM2L4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    i = new Intent(Lessons.this, Lesson5.class);
                                                    startActivity(i);
                                                }
                                            });

                                        }
                                    }
                                }
                                break;
                            }
                            case "lesson_5": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvL5.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvL5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    i = new Intent(Lessons.this, Lesson6.class);
                                                    startActivity(i);
                                                }
                                            });

                                        }
                                    }
                                }
                                break;
                            }
                            case "lesson_6": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            tvL6.setTextColor(getResources().getColor(R.color.cease_tan));
                                            tvL6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    i = new Intent(Lessons.this, Module3.class);
                                                    startActivity(i);
                                                }
                                            });

                                        }
                                    }
                                }
                                break;
                            }
                        }

                    }
                } else {
                    Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : lesson.entrySet()) {
                        if ("lesson_7".equals(e.getKey())) {
                            Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                            for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                if (dataEntry.getKey().equals("completed")) {
                                    if (dataEntry.getValue().equals(true)) {
                                        tvM3L7.setTextColor(getResources().getColor(R.color.cease_tan));
                                        tvM3L7.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent i = new Intent(Lessons.this, Main3Activity.class);
                                                startActivity(i);
                                            }
                                        });

                                    }
                                }
                            }
                        }

                    }
                }
            }
        });

    }
}