package com.infowithvijay.triviaquizapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.infowithvijay.triviaquizapp2.TriviaQuizContract.*;

import java.util.ArrayList;

public class TriviaQuizHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "TriviaQuiz.db";
    private static final int DATBASE_VERSION = 14;

    private SQLiteDatabase db;


    TriviaQuizHelper(Context context) {
        super(context, DATABASE_NAME,null, DATBASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }


    private void fillQuestionsTable()
    {

        TriviaQuestion q1 = new TriviaQuestion("Category : Java Android is what ?","OS","Drivers","Software","Hardware","OS",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q1);

        TriviaQuestion q2 = new TriviaQuestion("Category : Java Full form of PC is ?","Personal Computer","PIPO","TIPU","XXXIV","Personal Computer",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q2);

        TriviaQuestion q3= new TriviaQuestion("Category : Java The father of computer is  ?","Charles Babbage","Oliver twist","Love lice","lice","Charles Babbage",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q3);

        TriviaQuestion q4= new TriviaQuestion("Category : Java Which of the following is not a computer language?","BASIC","FORTRAN","LOUTS","COBOL","LOUTS",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q4);

        TriviaQuestion q5= new TriviaQuestion("Category : Java The third generation computers were made with ?","Bio Chips ","Transistors","Integrated Circuits","Vacuum Tubes ","Integrated Circuits",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q5);

        TriviaQuestion q6= new TriviaQuestion("Category : Java The first page displayed by Web browser after opening a Web site is called ?","Home page","Browser page","Search page  ","Bookmark","Home page",TriviaQuestion.CATEGORY_JAVA);
        addQuestions(q6);


        TriviaQuestion q7= new TriviaQuestion("Category : Kotlin DuckDuck Go is what ?","Search Engine","Browser page","Search page  ","Bookmark","Search Engine",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q7);

        TriviaQuestion q8= new TriviaQuestion("Category : Kotlin What is Norton?","Anitivirus","Browser page","Vaccine","Program","Anitivirus",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q8);

        TriviaQuestion q9= new TriviaQuestion("Category : Kotlin Who is the inventor of www?","Bill Gates","Tim Berners-Lee","Timothy Bil","Ray Tomlinson","Tim Berners-Lee",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q9);

        TriviaQuestion q10= new TriviaQuestion("Category : Kotlin Ethernet is an example of ","MAN","LAN","WAN","Wi-Fi","LAN",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q10);

        TriviaQuestion q11= new TriviaQuestion("Category : Kotlin HTML is used to create","Operating System","High Level Program","Web-Server","Web Page","Web Page",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q11);

        TriviaQuestion q12= new TriviaQuestion("Category : Kotlin Speed of internet connection is measured in","GHz","dpi","ppm","Gbps","Gbps",TriviaQuestion.CATEGORY_KOTLIN);
        addQuestions(q12);


    }

    private void addQuestions(TriviaQuestion question){

        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_CATEGORY,question.getCategory());
        db.insert(QuestionTable.TABLE_NAME,null,cv);

    }

    public ArrayList<TriviaQuestion> getAllQuestions() {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR
        };



            Cursor c = db.query(QuestionTable.TABLE_NAME,
                    Projection,
                    null,
                    null,
                    null,
                    null,
                    null);


            if (c.moveToFirst()) {
                do {

                    TriviaQuestion question = new TriviaQuestion();
                    question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                    question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                    question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                    question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                    questionList.add(question);

                } while (c.moveToNext());

            }
            c.close();
            return questionList;
        }

    public ArrayList<TriviaQuestion> getQuestionsWithCategory(String Category) {

        ArrayList<TriviaQuestion> questionList = new ArrayList<>();
        db = getReadableDatabase();



        String Projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {Category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                Projection,
                selection,
                selectionArgs,
                null,
                null,
                null);


        if (c.moveToFirst()) {
            do {

                TriviaQuestion question = new TriviaQuestion();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionList.add(question);

            } while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

}


