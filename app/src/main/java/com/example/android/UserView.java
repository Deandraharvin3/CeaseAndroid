package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.concurrent.TimeUnit;

public class UserView extends AppCompatActivity {

// todo: name, badges, logout, etc.
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference users = db.collection("users");

    private Intent i;

    TextView tvName;
    Button btnLogout;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        Query query = users.whereEqualTo("email",user.getEmail());

        tvName = findViewById(R.id.tvName);
        btnLogout = findViewById(R.id.btnLogout);
        loading = findViewById(R.id.loading);

//        Showing username of current user
//        todo show progression of user

        query.get()
                .addOnCompleteListener(user -> {
                    if (user.isSuccessful()) {

                        for (QueryDocumentSnapshot document : user.getResult()) {
                            tvName.setText("Welcome \n" + document.get("username").toString());
                        }
                        loading.setVisibility(View.INVISIBLE);
                    }

                    else{
                            System.out.println("\"Error getting documents ");
                        }
                });


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
                Intent i = new Intent(UserView.this, Start.class);
                startActivity(i);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    break;
//                case R.id.nav_path:
//                    // do something here
//                    i = new Intent(UserView.this, MyPath.class);
//                    break;
                case R.id.nav_lesson:
                    // do something here
                    Bundle extras = getIntent().getExtras();
                    if (extras != null) {
                        String value = extras.getString("lesson");
                        switch (value) {
                            case "Mod1":
                                i = new Intent(UserView.this, Module1.class);
                                break;
//                            case "Mod1Complete":
//                                i = new Intent(UserView.this, Module1Complete.class);
//                                break;
                            case "Mod2":
                                i = new Intent(UserView.this, Module2.class);
                                break;
//                            case "Mod2Complete":
//                                i = new Intent(UserView.this, Module2Complete.class);
//                                break;
                            case "Mod3":
                                i = new Intent(UserView.this, Module3.class);
                                break;
//                            case "Mod3Complete":
//                                i = new Intent(UserView.this, Module3Complete.class);
//                                break;
                            default:
                                i = new Intent(UserView.this, Module1.class);
                                break;
                        }
                    }
                        break;
                default: i = new Intent(UserView.this,UserView.class);
                    break;
            }
            startActivity(i);
            return true;
        });

    }
    public void signOut() {
        // [START auth_sign_out]
        FirebaseAuth.getInstance().signOut();
        // [END auth_sign_out]
    }
}