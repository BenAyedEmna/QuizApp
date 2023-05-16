package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final Button startBtn = findViewById(R.id.startNewQuizBtn);
        final TextView correctAnswers = findViewById(R.id.correctAnswers);
        final TextView wrongAnswers = findViewById(R.id.wrongAnswers);

        final int getCorectAnswers = getIntent().getIntExtra("correct",0);
        final int getWrongAnswers = getIntent().getIntExtra("incorrect",0);

        correctAnswers.setText(String.valueOf(getCorectAnswers));
        wrongAnswers.setText(String.valueOf(getWrongAnswers));

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this,MainActivity.class));
                finish();
            }
        });
    }
    public void onBackPressed(){
        startActivity(new Intent(QuizResults.this,MainActivity.class));
        finish();
    }


}