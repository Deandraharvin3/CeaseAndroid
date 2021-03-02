package com.example.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.content.Intent;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mackhartley.roundedprogressbar.RoundedProgressBar;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Dashboard extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference users = db.collection("users");
    DocumentReference modules = db.collection("modules").document(user.getUid());
    int width = Resources.getSystem().getDisplayMetrics().widthPixels;

    Intent i;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ImageView ivMessage = (ImageView) findViewById(R.id.ivMessage);
        ImageView ivLesson = (ImageView) findViewById(R.id.ivLesson);
        ImageView ivMaterials = (ImageView) findViewById(R.id.ivMaterials);
        ImageView ivPath = (ImageView) findViewById(R.id.ivPath);
        ImageView ivNotification = (ImageView) findViewById(R.id.ivNotification);
        ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);
        TextView tvUser = (TextView) findViewById(R.id.tvUser);
        TextView tvModule = (TextView) findViewById((R.id.tvModule));

        RoundedProgressBar progressBar = (RoundedProgressBar) findViewById(R.id.progressBar) ;
        progressBar.setMaxWidth(width);

         progressBar.showProgressText(true);

         progressBar.setBackgroundColor(getResources().getColor(R.color.cease_tan));
        Query query = users.whereEqualTo("email",user.getEmail());

        modules.get().addOnSuccessListener(documentSnapshot -> {
            Map<String, Object> complete = documentSnapshot.getData();
            for (Map.Entry<String, Object> entry : complete.entrySet()) {
                if (entry.getKey().equals("module_1")) {
                    progressBar.setProgressPercentage(0, true);
                    Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : lesson.entrySet()) {
                        if(lesson.get("completed").equals(true)){
                            progressBar.setProgressPercentage(44, true);
//                            tvModule.setText("Activity 1");
                        }
                        switch (e.getKey()) {
                            case "lesson_1": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            progressBar.setProgressPercentage(11, true);
//                                            tvModule.setText("Lesson 1");
                                        }
                                    }
                                }
                            }
                            break;
                            case "lesson_2": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
                                            progressBar.setProgressPercentage(22, true);
//                                            tvModule.setText("Lesson 2");

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
//                                           todo update progress bar
                                            progressBar.setProgressPercentage(33, true);
//                                            tvModule.setText("Lesson 3");
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (entry.getKey().equals("module_2")) {
//                    tvModule.setText(R..mod2_name);
                    Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                    for (Map.Entry<String, Object> e : lesson.entrySet()) {
                        if(lesson.get("completed").equals(true)){
                            progressBar.setProgressPercentage(77, true);
                        }
                        switch (e.getKey()) {
                            case "lesson_4": {
                                Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                                for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                    if (dataEntry.getKey().equals("completed")) {
                                        if (dataEntry.getValue().equals(true)) {
//                                           todo update progress bar
                                            progressBar.setProgressPercentage(55, true);
//                                            tvModule.setText("Lesson 4");

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

//                                           todo update progress bar
                                            progressBar.setProgressPercentage(66, true);
//                                            tvModule.setText("Lesson 5");

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
//                                           todo update progress bar
//                                            progressBar.setProgressPercentage(75, true);
//                                            tvModule.setText("lesson 6");
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
                        if(lesson.get("completed").equals(true)){
                            progressBar.setProgressPercentage(100, true);
//                            tvModule.setText("Avtivity 2");
                        }
                        if ("lesson_7".equals(e.getKey())) {
                            Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();
                            for (Map.Entry<String, Object> dataEntry : fNameMap.entrySet()) {
                                if (dataEntry.getKey().equals("completed")) {
                                    if (dataEntry.getValue().equals(true)) {
//                                           todo update progress bar
                                        progressBar.setProgressPercentage(88, true);
//                                        tvModule.setText("Lesson 7");
                                    }
                                }
                            }
                        }

                    }
                }
            }
        });


//        modules.get().addOnSuccessListener(documentSnapshot -> {
//                    Map<String, Object> complete = documentSnapshot.getData();
//                    for (Map.Entry<String, Object> entry : complete.entrySet()) {
//                        if (entry.getKey().equals("module_1")) {
//                            Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
//                            for(int i = 0; i < lesson.size();i++){
//                                lesson.forEach((key,value) -> System.out.println("key: " + key+" Value: "+ value));
//                                if(lesson.containsKey("completed")) {
//                                    System.out.println("lesson " + lesson.get("lesson1"));
//                                }

//                            }
//                            for (Map.Entry<String, Object> e : lesson.entrySet()) {
//
//                            }
//                        }
//                    }
//                });
//        modules.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Object completed = documentSnapshot.get("completed");
//                System.out.println(completed.toString());
//            }
//        });
//        mod_1.whereEqualTo("completed", true);
//        mod_1.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                task.getResult().getDocuments();
//            }
//        });

        query.get()
                .addOnCompleteListener(user -> {
                    if (user.isSuccessful()) {

                        for (QueryDocumentSnapshot document : Objects.requireNonNull(user.getResult())) {
                            tvUser.setText(Objects.requireNonNull(document.get("username")).toString());
//                            progressBar.setProgressPercentage(75,true);

                        }
                    }

                    else{
                        System.out.println("\"Error getting documents ");
                    }
                });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_dash:
                    // do something here
                    i = new Intent(Dashboard.this, Dashboard.class);
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(Module1.this, MyPath.class);
//                    break;
                case R.id.nav_main:
                    // do something here
                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {
                        String value = extras.getString("lesson");
                        switch (value) {
                            case "Mod1":
                                i = new Intent(Dashboard.this, Module1.class);
                                break;
                            case "Mod2":
                                i = new Intent(Dashboard.this, Module2.class);
                                break;
                            case "Mod3":
                                i = new Intent(Dashboard.this, Module3.class);
                                break;
                            default:
                                i = new Intent(Dashboard.this, Module1.class);
                                break;
                        }
                    }
                    break;
                default: i = new Intent(Dashboard.this,Dashboard.class);
                    break;
            }
            i.putExtra("lesson", "Mod1");
            startActivity(i);
            return false;
        });

        ivLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Dashboard.this, Lessons.class);
                startActivity(i);
            }
        });
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Dashboard.this, UserView.class);
                startActivity(i);
            }
        });
        ivPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Dashboard.this, UserPath.class);
                startActivity(i);
            }
        });
    }
}