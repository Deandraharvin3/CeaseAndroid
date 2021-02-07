package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Mod1Questions extends AppCompatActivity {

    ArrayList<Mod1Class> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod1_questions);

        //initialize the adapter -- movies array cannot be reinitialized after this point
        //todo adapter = new Mod1Adapter();


        // resolve the recycler view and connect a layout manager and the adapter
        RecyclerView rvMod1Questions = (RecyclerView) findViewById(R.id.rvMod1Questions);

        questions = Mod1Class.createContactsList(4);
        // Create adapter passing in the sample user data
        Mod1Adapter adapter = new Mod1Adapter(questions);
        // Attach the adapter to the recyclerview to populate items
        rvMod1Questions.setAdapter(adapter);
        // Set layout manager to position the items
        rvMod1Questions.setLayoutManager(new LinearLayoutManager(this));
        // get the configuration on app creation
        //todo getConfiguration();
    }
}