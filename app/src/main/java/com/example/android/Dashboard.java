package com.example.android;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.mackhartley.roundedprogressbar.RoundedProgressBar;

import java.util.Objects;
import java.util.Random;

public class Dashboard extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference users = db.collection("users");
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


        RoundedProgressBar progressBar = (RoundedProgressBar) findViewById(R.id.progressBar) ;
       progressBar.setMaxWidth(width);

         progressBar.showProgressText(true);










         progressBar.setBackgroundColor(getResources().getColor(R.color.cease_tan));
        Query query = users.whereEqualTo("email",user.getEmail());

        query.get()
                .addOnCompleteListener(user -> {
                    if (user.isSuccessful()) {

                        for (QueryDocumentSnapshot document : Objects.requireNonNull(user.getResult())) {
                            tvUser.setText(Objects.requireNonNull(document.get("username")).toString());
                            progressBar.setProgressPercentage(75,false);

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