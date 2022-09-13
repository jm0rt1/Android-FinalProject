package com.example.finalproject;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.model.Stats;

public class AnswerSelectedDialog extends Dialog implements
        android.view.View.OnClickListener {

    public CurrentGameActivity c;
    public Dialog d;
    public Button nextQuestionButton;
    public TextView headerTextView, answeredTextView, correctTextView;
    public ImageView imageView;
    public boolean mCorrect;
    Stats.StatItem gameStats;

    public AnswerSelectedDialog(CurrentGameActivity a, boolean correct, Stats.StatItem stats) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        mCorrect = correct;
        gameStats = stats;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.answer_selected_dialog);


        nextQuestionButton = (Button) findViewById(R.id.next_question_button);
        nextQuestionButton.setOnClickListener(this);
        imageView = findViewById(R.id.confirm_image);
        headerTextView = findViewById(R.id.header_text_view);
        answeredTextView = findViewById(R.id.answered_text_view);
        correctTextView = findViewById(R.id.correct_text_view);

        correctTextView.setText("Correct: "+ gameStats.getCorrect());
        answeredTextView.setText("Answered: " + gameStats.getAnswered());

        if (mCorrect){
            imageView.setImageResource(R.mipmap.ic_check_mark_round);
            headerTextView.setText(R.string.correct);
        } else {
            imageView.setImageResource(R.mipmap.ic_incorrect_round);
            headerTextView.setText(R.string.incorrect);


        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_question_button:
                c.currentQuestion++;
                c.displayCurrentQuestion();
                dismiss();
                break;

            default:
                break;
        }
        dismiss();
    }
}