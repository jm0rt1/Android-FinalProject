package com.example.finalproject;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class AnswerSelectedDialog extends Dialog implements
        android.view.View.OnClickListener {

    public CurrentGameActivity c;
    public Dialog d;
    public Button nextQuestionButton;
    public ImageView imageView;
    public boolean mCorrect;

    public AnswerSelectedDialog(CurrentGameActivity a, boolean correct) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        mCorrect = correct;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.answer_selected_dialog);


        nextQuestionButton = (Button) findViewById(R.id.next_question_button);
        nextQuestionButton.setOnClickListener(this);
        imageView = findViewById(R.id.confirm_image);

        if (mCorrect){
            imageView.setImageResource(R.mipmap.ic_check_mark_round);
        } else {
            imageView.setImageResource(R.mipmap.ic_incorrect_round);

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