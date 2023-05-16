package com.example.quiz;

import android.provider.BaseColumns;

public final class QuizContract {
    public QuizContract(){}
    public  static class QuestionTable implements BaseColumns{
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COL_ID = "ID";
        public static final String COL_QUESTION = "QUESTION";
        public static final String COL_OPTION_1 = "OPTION_1";
        public static final String COL_OPTION_2 = "OPTION_2";
        public static final String COL_OPTION_3 = "OPTION_3";
        public static final String COL_OPTION_4 = "OPTION_4";
        public static final String COL_ANSWER = "ANSWER";
        public static final String COL_USER_ANSWER = "USER_ANSWER";
        public static final String COL_TOPIC = "TOPIC";
    }
}
