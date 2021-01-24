package com.infowithvijay.triviaquizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    Button btJava,btKotlin,btDart,btFlutter,btJavaScript;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btDart = findViewById(R.id.bt_Dart);
        btJava = findViewById(R.id.bt_Java);
        btKotlin = findViewById(R.id.bt_Kotlin);
        btFlutter = findViewById(R.id.bt_Flutter);
        btJavaScript = findViewById(R.id.bt_JavaScript);


        btDart.setOnClickListener(this);
        btJava.setOnClickListener(this);
        btKotlin.setOnClickListener(this);
        btFlutter.setOnClickListener(this);
        btJavaScript.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_Dart:

                Intent intentDart = new Intent(CategoryActivity.this,QuizActivity.class);
                intentDart.putExtra("Category",TriviaQuestion.CATEGORY_DART);
                startActivity(intentDart);
                finish();
                break;

            case R.id.bt_Java:

                Intent intentJava = new Intent(CategoryActivity.this,QuizActivity.class);
                intentJava.putExtra("Category",TriviaQuestion.CATEGORY_JAVA);
                startActivity(intentJava);
                finish();
                break;


            case R.id.bt_Kotlin:

                Intent intentKotlin = new Intent(CategoryActivity.this,QuizActivity.class);
                intentKotlin.putExtra("Category",TriviaQuestion.CATEGORY_KOTLIN);
                startActivity(intentKotlin);
                finish();
                break;


            case R.id.bt_Flutter:

                Intent intentFlutter = new Intent(CategoryActivity.this,QuizActivity.class);
                intentFlutter.putExtra("Category",TriviaQuestion.CATEGORY_FLUTTER);
                startActivity(intentFlutter);
                finish();
                break;

            case R.id.bt_JavaScript:
                Intent intenJavaScript = new Intent(CategoryActivity.this,QuizActivity.class);
                intenJavaScript.putExtra("Category",TriviaQuestion.CATEGORY_JAVASCRIPT);
                startActivity(intenJavaScript);
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoryActivity.this,PlayScreen.class);
        startActivity(intent);
        finish();
    }

}