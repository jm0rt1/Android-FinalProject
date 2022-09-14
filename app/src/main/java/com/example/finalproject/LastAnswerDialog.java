package com.example.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.model.Stats;

public class LastAnswerDialog extends Dialog implements
        android.view.View.OnClickListener {

    public CurrentGameActivity c;
    public Dialog d;
    public Button nextQuestionButton;
    public TextView headerTextView, percentTextView, countTextView;
    public ImageView imageView;
    public boolean mCorrect;
    Stats.StatItem gameStats;

    public LastAnswerDialog(CurrentGameActivity a, Stats.StatItem stats) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        gameStats = stats;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.last_answer_dialog);


        nextQuestionButton = (Button) findViewById(R.id.next_question_button);
        nextQuestionButton.setOnClickListener(this);
        imageView = findViewById(R.id.confirm_image);
        headerTextView = findViewById(R.id.header_text_view);
        percentTextView = findViewById(R.id.percent_text_view);
        countTextView = findViewById(R.id.count_text_view);

        countTextView.setText("Correct: "+ gameStats.getCorrect() + "/" + gameStats.getAnswered());
        percentTextView.setText("Accuracy: " + gameStats.getPercentCorrect());
        if (c.currentQuestionNum == 9){
            nextQuestionButton.setText(R.string.end_game);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.next_question_button:
                Intent intent = new Intent(c.getApplicationContext(),MainActivity.class);
                c.startActivity(intent);
                dismiss();
                break;

            default:
                break;
        }
        dismiss();
    }
}