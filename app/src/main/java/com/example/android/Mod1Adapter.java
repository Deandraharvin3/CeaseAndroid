package com.example.android;

import android.content.Context;
import android.content.Intent;
import android.util.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mod1Adapter extends RecyclerView.Adapter<Mod1Adapter.ViewHolder> {

    private ArrayList<Mod1Class> questions;
    Context context;

    public Mod1Adapter(ArrayList<Mod1Class> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public Mod1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View questionView = inflater.inflate(R.layout.item_mod1question, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(questionView);
        return viewHolder;
    }
    int answerCount = 0;

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mod1Class mQuestions = questions.get(position);

        // Set item views based on your views and data model
        TextView item = holder.tvItem;
        item.setText(mQuestions.getQuestion().toString());

        TextView response = holder.tvResponse;

        Button next = holder.btnNext;
        ImageView image = holder.ivImage;
        int current = mQuestions.getImage();
        image.setImageResource(current);
        Button rtrue = holder.btnTrue;
        Button rfalse = holder.btnFalse;
        rtrue.setText("True");
        rtrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestions.getAnswer()) {
                    response.setText("Correct!\n" + mQuestions.getResponse() + " Scroll down");
                    answerCount += 1;

                } else {
                    response.setText("Incorrect!\n" + mQuestions.getResponse());
                }
            }
        });
        rfalse.setText("False");
        rfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mQuestions.getAnswer()) {
                    response.setText("Correct!\n" + mQuestions.getResponse() + " Scroll down");
                    answerCount += 1;

                } else {
                    response.setText("Incorrect!\n" + mQuestions.getResponse());
                }
            }
        });
        if (answerCount >= questions.size()) {
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, Module1.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvItem, tvResponse;
        public Button btnNext, btnTrue, btnFalse;
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tvItem);
            tvResponse = itemView.findViewById(R.id.tvResponse);
            btnNext = itemView.findViewById(R.id.btnNext);
            btnTrue = itemView.findViewById(R.id.btnTrue);
            btnFalse = itemView.findViewById(R.id.btnFalse);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }
}
