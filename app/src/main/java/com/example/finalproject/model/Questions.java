package com.example.finalproject.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Questions {
    public static class Question{
        public String getCategory() {
            return mCategory;
        }

        public String getType() {
            return mType;
        }

        public String getDifficulty() {
            return mDifficulty;
        }

        public String getQuestion() {
            return mQuestion;
        }

        public String getCorrectAnswer() {
            return mCorrectAnswer;
        }

        public ArrayList<String> getIncorrectAnswers() {
            return mIncorrectAnswers;
        }

        @SerializedName(value = "mCategory", alternate = "category")
        String mCategory;
        @SerializedName(value = "mType", alternate = "type")
        String mType;
        @SerializedName(value = "mDifficulty", alternate = "difficulty")
        String mDifficulty;
        @SerializedName(value = "mQuestion", alternate = "question")
        String mQuestion;
        @SerializedName(value = "mCorrectAnswer", alternate = "correct_answer")
        String mCorrectAnswer;
        @SerializedName(value = "mIncorrectAnswers", alternate = "incorrect_answers")
        ArrayList<String> mIncorrectAnswers;
    }

    @SerializedName(value = "mQuestions", alternate = "results")
    ArrayList<Question> mQuestions = new ArrayList<>();
    public ArrayList<Question> getQuestions() {
        return mQuestions;
    }
}
