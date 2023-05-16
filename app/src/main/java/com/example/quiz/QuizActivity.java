package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.example.quiz.QuizContract.*;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private AppCompatButton option1,option2,option3,option4;
    private Button nextBtn;

    private ImageView backBtn ;
    private AppCompatButton quitBtn ;
    private List<QuestionsList> questionsLists ;
    private int currentQuestionPosition = 0  ;
    private String selectedOptionByUser ="";
    private Cursor questionList;
    private int questionCounter ;
    private int questionTotalCount;
    private QuestionsList currentQuestions;
    private boolean answered ;

    private void fetchDB(){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        questionList = dbHelper.getAllQuestions();
        int columnIndex = questionList.getColumnIndex(QuestionTable.COL_QUESTION);
        if (questionList.moveToFirst()) {
            do {
                if (columnIndex != -1) {
                    String question = questionList.getString(columnIndex);
                }
                System.out.println("Question: " + question);
            } while (questionList.moveToNext());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView selectedTopic = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);

        nextBtn=findViewById(R.id.nextBtn);
        quitBtn=findViewById(R.id.quitBtn);

        //fetchDB();

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        selectedTopic.setText(getSelectedTopicName);

        questionsLists = QuestionsBank.getQuestions(getSelectedTopicName);
        questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.round_back_red);
                    option1.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.round_back_red);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.round_back_red);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.round_back_red);
                    option4.setTextColor(Color.WHITE);
                    revealAnswer();
                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(QuizActivity.this, "Please select an option ", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        quitBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,QuizResults.class));
                finish();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;
        if((currentQuestionPosition+1)== questionsLists.size()){
            nextBtn.setText("submit Quiz");
        }
        if(currentQuestionPosition < questionsLists.size()){
            selectedOptionByUser = "";
            option1.setBackgroundResource(R.drawable.round_back_stroke);
            option1.setTextColor(Color.parseColor("#000000"));

            option2.setBackgroundResource(R.drawable.round_back_stroke);
            option2.setTextColor(Color.parseColor("#000000"));

            option3.setBackgroundResource(R.drawable.round_back_stroke);
            option3.setTextColor(Color.parseColor("#000000"));

            option4.setBackgroundResource(R.drawable.round_back_stroke);
            option4.setTextColor(Color.parseColor("#000000"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());
        }
        else{
            Intent intent = new Intent(QuizActivity.this,QuizResults.class);
            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("incorrect",getInCorrectAnswers());
            startActivity(intent);
            finish();

        }
    }

    private int getCorrectAnswers(){
        int correctAnswers=0;
        for (int i=0;i<questionsLists.size();i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(getAnswer.equals(getUserSelectedAnswer)){
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswers(){
        int inCorrectAnswers=0;
        for (int i=0;i<questionsLists.size();i++){
            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if(!getAnswer.equals(getUserSelectedAnswer)){
                inCorrectAnswers++;
            }

        }
        return inCorrectAnswers;
    }

    public void onBackPressed(){
        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();
        if(option1.getText().toString().equals(getAnswer)){
            Toast.makeText(QuizActivity.this, "option1", Toast.LENGTH_SHORT).show();
            option1.setBackgroundResource(R.drawable.round_back_green);
            option1.setTextColor(Color.WHITE);

        }
        else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
            option2.setTextColor(Color.WHITE);
            Toast.makeText(QuizActivity.this, "option2", Toast.LENGTH_SHORT).show();

        }
        else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green);
            option3.setTextColor(Color.WHITE);
            Toast.makeText(QuizActivity.this, "option3", Toast.LENGTH_SHORT).show();

        }
        else if(option4.getText().toString().equals(getAnswer)){
            option4.setBackgroundResource(R.drawable.round_back_green);
            option4.setTextColor(Color.WHITE);
            Toast.makeText(QuizActivity.this, "option4", Toast.LENGTH_SHORT).show();

        }

    }



}