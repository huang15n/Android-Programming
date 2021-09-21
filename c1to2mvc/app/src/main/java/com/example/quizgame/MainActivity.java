package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.app.PendingIntent.getActivity;
import static android.widget.Toast.LENGTH_LONG;
import static com.example.quizgame.R.string.hello;

public class MainActivity extends AppCompatActivity {

    private Button buttonFalse;
    private Button buttonTrue;
    private Button buttonNext;
    private TextView mTextView;
    private TextView mScore;

    private int randonLeft;
    private int randonRight;

    private int currentQuestionIndex;
    private Questions [] mQuestions;
    private int questionResourceId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentQuestionIndex = 0;
        mQuestions = new Questions[]{
                new Questions(R.string.question_one, true),
                new Questions(R.string.question_two, false),
                        new Questions(R.string.question_three, true),
                        new Questions(R.string.question_four, false),
        };

        setContentView(R.layout.activity_main);
        buttonTrue = findViewById(R.id.buttonLeft);
        buttonFalse = findViewById(R.id.buttonRight);
        buttonNext = findViewById(R.id.next);
        mTextView = findViewById(R.id.questions);
        mTextView.setText(mQuestions[currentQuestionIndex].getQuestionResId());
        mScore = findViewById(R.id.score);



        buttonTrue.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                checkAnser(true);


            }
        });

        buttonFalse.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {
                checkAnser(false);



            }
        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionIndex = (currentQuestionIndex + 1) % mQuestions.length ;
                mTextView.setText(mQuestions[currentQuestionIndex].getQuestionResId());

            }
        });






    }

    public void checkAnser(boolean result){
        boolean correctAnser = mQuestions[currentQuestionIndex].isResultTrueOrFalse();
        int toastMessageId;
        if(correctAnser == result){
            toastMessageId = R.string.trueToast;
            mScore.setText("!!!!!!!!!");

        }else{
            toastMessageId = R.string.falseToast;
            mScore.setText("xxxxxxxxxx");
        }

        Toast.makeText(this, toastMessageId,
                Toast.LENGTH_SHORT).show();




    }








}