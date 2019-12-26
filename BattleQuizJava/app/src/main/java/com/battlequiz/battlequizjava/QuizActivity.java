package com.battlequiz.battlequizjava;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView question = (TextView) findViewById(R.id.questionText);
        QuestionAnswers firstQuestion = QuestionAnswers.initialiseQuestion();
        question.setText(firstQuestion.getQuestion());

        final Button aButton = (Button) findViewById(R.id.aButton);
        final Button bButton = (Button) findViewById(R.id.bButton);
        final Button cButton = (Button) findViewById(R.id.cButton);
        final Button dButton = (Button) findViewById(R.id.dButton);

        aButton.setText(firstQuestion.getAnswerA());
        bButton.setText(firstQuestion.getAnswerB());
        cButton.setText(firstQuestion.getAnswerC());
        dButton.setText(firstQuestion.getAnswerD());

        final String answer = firstQuestion.getCorrectAnswer();


        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonSelected = "A";
                if(answer.equals(buttonSelected)){
                    correctAnswer(aButton);
                }else{
                    wrongAnswer(aButton);
                }
            }
        });

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonSelected = "B";
                if(answer.equals(buttonSelected)){
                    correctAnswer(bButton);
                }else{
                    wrongAnswer(bButton);
                }
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonSelected = "C";
                if(answer.equals(buttonSelected)){
                    correctAnswer(cButton);
                }else{
                    wrongAnswer(cButton);
                }
            }
        });

        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonSelected = "D";
                if(answer.equals(buttonSelected)){
                    correctAnswer(dButton);
                }else{
                    wrongAnswer(dButton);
                }
            }
        });


    }

    private void correctAnswer(Button button){
        button.setBackgroundColor(Color.GREEN);
    }

    private void wrongAnswer(Button button){
        button.setBackgroundColor(Color.RED);

    }

    private void loadQuestion(){

    }

    private static void loadAnswers(){

    }

    private static void selectedAnswer(){

    }




}
