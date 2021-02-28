package com.example.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Signup extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private FirebaseFunctions mFunctions;

    // [START declare_auth]
    public FirebaseAuth mAuth;
    // [END declare_auth]

//    final FirebaseDatabase database = FirebaseDatabase.getInstance();

    EditText tvUsername, tvCode, tvEmail, pwd, pwd2;
    ImageView ivSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        DatabaseReference myRef = database.getReference("codes").push();

        mAuth = FirebaseAuth.getInstance();

        tvUsername = findViewById(R.id.tvUsername);
        tvCode = findViewById(R.id.tvCode);
        tvEmail = findViewById(R.id.tvEmail);
        pwd = findViewById(R.id.pwd);
        pwd2 = findViewById(R.id.pwd2);
        ivSignup = findViewById(R.id.ivSignup);
        mFunctions = FirebaseFunctions.getInstance();


        ivSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = tvEmail.getText().toString();
                if(pwd.getText().toString().equals(pwd2.getText().toString())){
                    String password = pwd.getText().toString();

                    validCode().addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {
                            if(s.equals("false")) {
                                createUser(email, password);
                            }
                            else {
                                Toast.makeText(Signup.this, "Code is INVALID", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    Toast.makeText(Signup.this, "Passwords do not Match!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private Task<String> validCode() {
        Map<String, Object> verifyCode = new HashMap<>();
        verifyCode.put("codes", tvCode.getText().toString());
        System.out.println( verifyCode.get("codes"));

        return mFunctions.getHttpsCallable("verifyUnusedCode").call(verifyCode)
            .continueWith(task -> (Boolean) Objects.requireNonNull(task.getResult()).getData() ? "true": "false");

    }

    private void createUser(String newEmail, String newPassword) {
        if (TextUtils.isEmpty(newEmail)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(newPassword)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(newEmail, newPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
                            CollectionReference doc = db.collection("users");
                            Map<String, Object> data = new HashMap<>();
                            data.put("username", tvUsername.getText().toString());
                            data.put("code", tvCode.getText().toString());

                            assert user != null;
                            db.collection("users").document(user.getUid())
                                    .set(data, SetOptions.merge());

//                            updateUI(user);
                            Intent i = new Intent(Signup.this, Survey.class);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Signup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}