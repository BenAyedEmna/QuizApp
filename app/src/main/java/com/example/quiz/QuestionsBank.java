package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {
    private static List<QuestionsList> javaQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("How do you insert COMMENTS in Java code?","// This is a comment","/* This is a comment","# This is a comment","% This is a comment","// This is a comment","","android");
        final QuestionsList question2 = new QuestionsList("Which layout in Android Studio arranges its child views in a grid-like structure with fixed row and column sizes?","LinearLayout","RelativeLayout","FrameLayout","GridLayout","GridLayout","","android");
        final QuestionsList question3 = new QuestionsList("Which Android Studio component is used to create and manage virtual devices for testing your app?"," Android Device Manager","Android Virtual Device Manager","Android SDK Manager"," Android Emulator Manager","Android Virtual Device Manager","","android");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);

        return questionsLists;

    }

    private static List<QuestionsList> androidQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What programming language is used to develop Android apps?","C++","Python","Java","Swift","Java","","java");
        final QuestionsList question2 = new QuestionsList("Which layout in Android Studio arranges its child views in a grid-like structure with fixed row and column sizes?","LinearLayout","RelativeLayout","FrameLayout","GridLayout","GridLayout","","java");
        final QuestionsList question3 = new QuestionsList("Which Android Studio component is used to create and manage virtual devices for testing your app?"," Android Device Manager","Android Virtual Device Manager","Android SDK Manager"," Android Emulator Manager","Android Virtual Device Manager","","java");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);

        return questionsLists;
    }

    private static List<QuestionsList> xmlQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("How do you insert COMMENTS in Java code?","// This is a comment","/* This is a comment","# This is a comment","% This is a comment","// This is a comment","","java");
        final QuestionsList question2 = new QuestionsList("How do you create a variable with the numeric value 5?","x = 5","float x = 5 ","num x = 5","int x = 5","int x = 5","","java");
        final QuestionsList question3 = new QuestionsList("Which method can be used to find the length of a string?","getLength()","len()","length()","getSize()","length()","","java");
        final QuestionsList question4 = new QuestionsList("Which of the following data types represents a single character in Java?","char","int","byte", "string","char","","java");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);

        return questionsLists;

    }

    private static List<QuestionsList> randomQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What programming language is used to develop Android apps?","C++","Python","Java","Swift","Java","","android");
        final QuestionsList question2 = new QuestionsList("Which layout in Android Studio arranges its child views in a grid-like structure with fixed row and column sizes?","LinearLayout","RelativeLayout","FrameLayout","GridLayout","GridLayout","","android");
        final QuestionsList question3 = new QuestionsList("Which Android Studio component is used to create and manage virtual devices for testing your app?"," Android Device Manager","Android Virtual Device Manager","Android SDK Manager"," Android Emulator Manager","Android Virtual Device Manager","","android");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "androidStudio":
                return androidQuestions();
            case "java":
                return javaQuestions();
            case "xml":
                return xmlQuestions();
            default:
                return randomQuestions();
        }
    }
}
