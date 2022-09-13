package com.example.finalproject;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalproject.adapters.AnswerListAdapter;
import com.example.finalproject.model.Model;
import com.example.finalproject.model.Questions;
import com.example.finalproject.model.Stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentGameActivity extends AppCompatActivity {
    int currentQuestion= 0;
    TextView categoryTextView;
    TextView questionTextView;
    ListView answerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);
        questionTextView = findViewById(R.id.question_text_view);
        categoryTextView = findViewById(R.id.category_text_view);
        answerListView = findViewById(R.id.answer_list);


        displayCurrentQuestion();

    }

    public void displayCurrentQuestion(){
        Questions.Question current = Model.getInstance().getCurrentGame().getQuestion(currentQuestion);
        categoryTextView.setText(Model.getInstance().getCurrentGame().getCategory().getmName());
        questionTextView.setText(Html.fromHtml(current.getQuestion()).toString());
        ArrayList<String> answerList = new ArrayList<>();
        answerList.addAll(current.getIncorrectAnswers());
        answerList.add(current.getCorrectAnswer());
        Collections.shuffle(answerList);
        final Stats.StatItem gameStats = Model.getInstance().getCurrentGame().getStatItem();

        ArrayAdapter<String> adapter =  new AnswerListAdapter(CurrentGameActivity.this, answerList);
        answerListView.setAdapter(adapter);
        answerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String answer = answerList.get(position);
                boolean correct = false;
                if (answer == current.getCorrectAnswer()){
                    correct = true;
                }
                gameStats.addAnswered(correct);
                AnswerSelectedDialog cdd=new AnswerSelectedDialog(CurrentGameActivity.this, correct, gameStats);

                cdd.show();
            }
        });
    }

}