package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

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

public class CurrentGameActivity extends AppCompatActivity {
    int currentQuestionNum = 0;
    TextView categoryTextView;
    TextView questionTextView;
    TextView questionCountTextView;
    ListView answerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);
        questionTextView = findViewById(R.id.question_text_view);
        categoryTextView = findViewById(R.id.category_text_view);
        answerListView = findViewById(R.id.answer_list);
        questionCountTextView = findViewById(R.id.question_counter);


        displayCurrentQuestion();

    }

    public void displayCurrentQuestion(){
        Questions.Question current = Model.getInstance().getCurrentGame().getQuestion(currentQuestionNum);
        categoryTextView.setText(Model.getInstance().getCurrentGame().getCategory().getmName());
        questionTextView.setText(Html.fromHtml(current.getQuestion()).toString());
        questionCountTextView.setText((currentQuestionNum+1)+"/10");
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
                boolean correct = answer.equals(current.getCorrectAnswer());
                gameStats.addAnswered(correct);
                AnswerSelectedDialog cdd=new AnswerSelectedDialog(CurrentGameActivity.this, correct, gameStats);

                cdd.show();
            }
        });
    }

}