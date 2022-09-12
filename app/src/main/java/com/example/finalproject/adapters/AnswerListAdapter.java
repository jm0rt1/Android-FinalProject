package com.example.finalproject.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.finalproject.R;

import java.util.ArrayList;

public class AnswerListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> mAnswers;

    public AnswerListAdapter(@NonNull Activity context, ArrayList<String> answers) {
        super(context, R.layout.answer_list_item, answers);
        this.context = context;
        mAnswers = answers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linear_layout;
        //convertView is a linearlayout that is offscreen that we can reuse
        if (convertView == null) {
            LayoutInflater inflater =context.getLayoutInflater();
            linear_layout = inflater.inflate(R.layout.answer_list_item, null, true);
        } else {
            linear_layout = convertView;
        }
        TextView answer = (TextView) linear_layout.findViewById(R.id.answer_text_view);
        answer.setText(mAnswers.get(position));

        return linear_layout;

    }

}
