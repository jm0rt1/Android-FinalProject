package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalproject.model.Model;

public class CurrentGameActivity extends AppCompatActivity {
    int currentQuestion= 0;
    TextView categoryTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_game);
        Model m = Model.getInstance();
        categoryTextView = findViewById(R.id.category_text_view);
        categoryTextView.setText(Model.getInstance().getCurrentGame().getCategory().getmName());



    }


}