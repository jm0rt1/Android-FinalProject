package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.finalproject.model.Model;

public class CurrentGameActivity extends AppCompatActivity {
    int currentQuestion= 0;
    TextView categoryTextView;
    TextView questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);
        Model m = Model.getInstance();
        categoryTextView = findViewById(R.id.category_text_view);
        categoryTextView.setText(Model.getInstance().getCurrentGame().getCategory().getmName());
        questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(Html.fromHtml(Model.getInstance().getCurrentGame().getQuestion(currentQuestion).getQuestion()).toString());

    }


}