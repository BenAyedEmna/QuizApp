package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicName="" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout android = findViewById(R.id.androidLayout);
        final LinearLayout xml = findViewById(R.id.xmlLayout);
        final LinearLayout java = findViewById(R.id.javaLayout);
        final LinearLayout random = findViewById(R.id.randomLayout);

        final AppCompatButton startBtn = findViewById(R.id.startQuizBtn);

        android.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedTopicName="android studio";

                android.setBackgroundResource(R.drawable.round_back_stroke);
                java.setBackgroundResource(R.drawable.round_back);
                xml.setBackgroundResource(R.drawable.round_back);
                random.setBackgroundResource(R.drawable.round_back);
            }
        });

        xml.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedTopicName="xml";
                xml.setBackgroundResource(R.drawable.round_back_stroke);
                java.setBackgroundResource(R.drawable.round_back);
                android.setBackgroundResource(R.drawable.round_back);
                random.setBackgroundResource(R.drawable.round_back);
            }
        });

        java.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedTopicName="java";

                java.setBackgroundResource(R.drawable.round_back_stroke);
                android.setBackgroundResource(R.drawable.round_back);
                xml.setBackgroundResource(R.drawable.round_back);
                random.setBackgroundResource(R.drawable.round_back);
            }
        });

        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                selectedTopicName="random";

                random.setBackgroundResource(R.drawable.round_back_stroke);
                android.setBackgroundResource(R.drawable.round_back);
                xml.setBackgroundResource(R.drawable.round_back);
                java.setBackgroundResource(R.drawable.round_back);

            }
        });

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(selectedTopicName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please select the topic", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(),QuizActivity.class);
                    intent.putExtra("selectedTopic",selectedTopicName);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}