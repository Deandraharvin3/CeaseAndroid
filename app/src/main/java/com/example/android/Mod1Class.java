package com.example.android;

import android.media.Image;

import java.util.ArrayList;

public class Mod1Class {

    private  String mQuestion, mResponse;
    private Boolean mAnswer;
    private int mImage;
    private static int[] lImage = {R.drawable.paint2, R.drawable.rooftop, R.drawable.batteries2, R.drawable.rockets2, R.drawable.handsoap2};
    private static String[] lQuestion = {"Paint", "Rooftop", "Batteries", "Rockets", "Hand Soap"};
    private  static boolean[] lAnswer = {true, true, true, true, false};
    private static String[] lResponse = {"Toluene is used to manufacture paint.", "Tar: used for paving roads and coating roofs",
            "Both Lead & Cadmium are found in batteries!", "Methanol is the main component in Rocket fluid",
            "Most soaps do not contain any toxins as cigarettes"};

    public Mod1Class(int image, String question, Boolean answer, String response) {
        mImage = image;
        mQuestion = question;
        mAnswer = answer;
        mResponse = response;
    }

    public int getImage() {
        return mImage;
    }
    public String getQuestion() {
        return mQuestion;
    }
    public Boolean getAnswer() {
        return mAnswer;
    }

    public String getResponse() {
        return mResponse;
    }

    private static int lastItem = 0;

    public static ArrayList<Mod1Class> createContactsList(int questionNum) {
        ArrayList<Mod1Class> question = new ArrayList<Mod1Class>();

        for (int i = 0; i <= questionNum; i++) {
            question.add(new Mod1Class(lImage[i], lQuestion[i], lAnswer[i], lResponse[i]));
        }

        return question;
    }
}
