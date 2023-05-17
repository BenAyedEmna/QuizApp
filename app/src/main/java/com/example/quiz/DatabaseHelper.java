package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.quiz.QuizContract.*;
import com.example.quiz.QuestionsList.*;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Questions.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase MyDatabase;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.MyDatabase = db;

        final String query = "CREATE TABLE " + QuestionTable.TABLE_NAME + " (" +
                QuestionTable.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COL_QUESTION + " TEXT, " +
                QuestionTable.COL_OPTION_1 + " TEXT, " +
                QuestionTable.COL_OPTION_2 + " TEXT, " +
                QuestionTable.COL_OPTION_3 + " TEXT, " +
                QuestionTable.COL_OPTION_4 + " TEXT, " +
                QuestionTable.COL_ANSWER + " TEXT, " +
                QuestionTable.COL_TOPIC + " TEXT, " +
                QuestionTable.COL_USER_ANSWER + " TEXT)";
        db.execSQL(query);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    public void addQuestion(QuestionsList question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QuestionTable.COL_QUESTION, question.getQuestion());
        values.put(QuestionTable.COL_OPTION_1, question.getOption1());
        values.put(QuestionTable.COL_OPTION_2, question.getOption2());
        values.put(QuestionTable.COL_OPTION_3, question.getOption3());
        values.put(QuestionTable.COL_OPTION_4, question.getOption4());
        values.put(QuestionTable.COL_ANSWER, question.getAnswer());
        values.put(QuestionTable.COL_USER_ANSWER, question.getUserSelectedAnswer());
        values.put(QuestionTable.COL_TOPIC, question.getTopic());
        db.insert(QuestionTable.TABLE_NAME, null, values);
        db.close();
    }

    public void fillQuestionsTable() {
        //java questions

        QuestionsList question1 = new QuestionsList("How do you insert COMMENTS in Java code?", "// This is a comment", "/* This is a comment", "# This is a comment", "% This is a comment", "// This is a comment", "", "java");
        addQuestion(question1);

        final QuestionsList question2 = new QuestionsList("How do you create a variable with the numeric value 5?", "x = 5", "float x = 5 ", "num x = 5", "int x = 5", "int x = 5", "", "java");
        addQuestion(question2);

        final QuestionsList question3 = new QuestionsList("Which method can be used to find the length of a string?", "getLength()", "len()", "length()", "getSize()", "length()", "", "java");
        addQuestion(question3);

        final QuestionsList question4 = new QuestionsList("Which of the following data types represents a single character in Java?", "char", "int", "byte", "string", "char", "", "java");
        addQuestion(question4);

        //xml questions


        //android questions
        QuestionsList question11 = new QuestionsList("Android is what ?", "OS", "Drivers", "Hardware", "Software", "OS", "", "android");
        addQuestion(question11);

    }

   /* @SuppressLint("Range")
    public ArrayList<QuestionsList> getAllQuestions() {
        ArrayList<QuestionsList> questionsList = new ArrayList<>();
        System.out.println("test1");
         SQLiteDatabase MyData = this.getReadableDatabase();
        System.out.println("test2");
        String Projection[] = {
                QuestionTable.COL_ID,
                QuestionTable.COL_QUESTION,
                QuestionTable.COL_OPTION_1,
                QuestionTable.COL_OPTION_2,
                QuestionTable.COL_OPTION_3,
                QuestionTable.COL_OPTION_4,
                QuestionTable.COL_ANSWER,
                QuestionTable.COL_USER_ANSWER,
                QuestionTable.COL_TOPIC
        };
        System.out.println("test3");
        Cursor c = MyData.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);
        System.out.println("test4");

        if (c.moveToFirst()) {
            do {
                System.out.println("test5");
                QuestionsList questionsList1 = new QuestionsList();
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_QUESTION)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_1)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_2)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_3)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_4)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_ANSWER)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_USER_ANSWER)));
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_TOPIC)));
                questionsList.add(questionsList1);
                System.out.println(questionsList1);
                System.out.println(questionsList);
                System.out.println(questionsList.size());
            } while (c.moveToNext());
        }
        System.out.println("test6");

        c.close();//closing the cursor
        return questionsList;
    }*/

    @SuppressLint("Range")
    public ArrayList<QuestionsList> getAllQuestions() {
        ArrayList<QuestionsList> questionsList = new ArrayList<>();
        SQLiteDatabase MyData = this.getReadableDatabase();

        String Projection[] = {
                QuestionTable.COL_ID,
                QuestionTable.COL_QUESTION,
                QuestionTable.COL_OPTION_1,
                QuestionTable.COL_OPTION_2,
                QuestionTable.COL_OPTION_3,
                QuestionTable.COL_OPTION_4,
                QuestionTable.COL_ANSWER,
                QuestionTable.COL_USER_ANSWER,
                QuestionTable.COL_TOPIC
        };

        Cursor c = MyData.query(QuestionTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);

        if (c.moveToFirst()) {
            do {
                System.out.println("test1");
                QuestionsList questionsList1 = new QuestionsList();
                questionsList1.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COL_QUESTION)));
                questionsList1.setOption1(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_1)));
                questionsList1.setOption2(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_2)));
                questionsList1.setOption3(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_3)));
                questionsList1.setOption4(c.getString(c.getColumnIndex(QuestionTable.COL_OPTION_4)));
                questionsList1.setAnswer(c.getString(c.getColumnIndex(QuestionTable.COL_ANSWER)));
                questionsList1.setUserSelectedAnswer(c.getString(c.getColumnIndex(QuestionTable.COL_USER_ANSWER)));
                questionsList1.setTopic(c.getString(c.getColumnIndex(QuestionTable.COL_TOPIC)));
                questionsList.add(questionsList1);
            } while (c.moveToNext());
        }

        c.close();
        System.out.println(questionsList.size());
        return questionsList;
    }




    /*public Cursor getAllQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);
    }*/

    public Cursor getAllAndroidQuestions() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);
    }


}
