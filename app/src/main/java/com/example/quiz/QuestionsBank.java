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
        final QuestionsList question4 = new QuestionsList("What is the purpose of an AsyncTask in Android?", "To handle background tasks and operations", "To manage the app's user interface", "To handle network communication", "To define app permissions", "To handle background tasks and operations", "", "java");
        final QuestionsList question5 = new QuestionsList("What is the lifecycle method called when an activity is first created?", "onCreate()", "onStart()", "onResume()", "onPause()", "onCreate()", "", "java");
        final QuestionsList question6 = new QuestionsList("What is the primary database management system used in Android?", "SQLite", "MySQL", "Oracle", "PostgreSQL", "SQLite", "", "java");
        final QuestionsList question7 = new QuestionsList("Which component is responsible for handling user interactions in Android?", "Activity", "Fragment", "Service", "BroadcastReceiver", "Activity", "", "java");
        final QuestionsList question8 = new QuestionsList("What is the purpose of the Gradle build system in Android development?", "To manage project dependencies and build configurations", "To design user interfaces", "To handle database operations", "To write unit tests", "To manage project dependencies and build configurations", "", "java");
        final QuestionsList question9 = new QuestionsList("What is the file extension for an Android layout file?", ".xml", ".java", ".txt", ".html", ".xml", "", "java");
        final QuestionsList question10 = new QuestionsList("What is the main purpose of an IntentFilter in Android?", "To declare the capabilities and requirements of a component", "To define app permissions", "To handle network communication", "To manage background tasks", "To declare the capabilities and requirements of a component", "", "java");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

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
            case "android studio":
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
