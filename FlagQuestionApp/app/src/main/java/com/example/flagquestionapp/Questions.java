package com.example.flagquestionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class Questions extends AppCompatActivity {
    private TextView textViewTrue, textViewFalse, textViewQuestion;
    private ImageView flags;
    private Button buttonA, buttonB, buttonC, buttonD;
    private ArrayList<FlagConstructor> questionsList;
    private ArrayList<FlagConstructor> falseList;
    private FlagConstructor trueQuestion;
    private DataBase db;

    private int questionCounter = 0;
    private int falseCounter = 0;
    private int trueCounter = 0;

    private HashSet<FlagConstructor> mixOptionsList = new HashSet<>();
    private ArrayList<FlagConstructor> mixList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        textViewTrue = findViewById(R.id.textViewTrue);
        textViewFalse = findViewById(R.id.textViewFalse);
        textViewQuestion = findViewById(R.id.textViewQuestionNumber);
        flags = findViewById(R.id.imageViewFlag);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        db = new DataBase(this);
        questionsList = new FlagDao().getRandom5(db);

        questionLoad();
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trueControl(buttonA);
                counterControl();

            }

        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trueControl(buttonB);
                counterControl();

            }

        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trueControl(buttonC);
                counterControl();

            }

        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trueControl(buttonD);
                counterControl();

            }

        });

    }

    public void questionLoad() {

        textViewQuestion.setText((questionCounter + 1) + ". QUESTION");


        trueQuestion = questionsList.get(questionCounter);


        falseList = new FlagDao().getRandom3false(db, trueQuestion.getBayrak_id());

        flags.setImageResource(getResources().getIdentifier(trueQuestion.getBayrak_resim(), "drawable", getPackageName()));


        mixOptionsList.clear();
        mixOptionsList.add(falseList.get(0));
        mixOptionsList.add(falseList.get(1));
        mixOptionsList.add(falseList.get(2));
        mixOptionsList.add(trueQuestion);
        mixList.clear();

        for (FlagConstructor b : mixOptionsList) {

            mixList.add(b);
        }
        buttonA.setText(mixList.get(0).getBayrak_ad());
        buttonB.setText(mixList.get(1).getBayrak_ad());
        buttonC.setText(mixList.get(2).getBayrak_ad());
        buttonD.setText(mixList.get(3).getBayrak_ad());


    }


    public void trueControl(Button button) {

        String buttonText = button.getText().toString();
        String trueReply = trueQuestion.getBayrak_ad();
        if (buttonText.equals(trueReply)) {
            trueCounter++;

        } else {
            falseCounter++;

        }
        textViewTrue.setText("True : " + trueCounter);
        textViewFalse.setText("False : " + falseCounter);


    }

    public void counterControl() {
        questionCounter++;

        if (questionCounter == 5) {
            Intent intent = new Intent(Questions.this, Conclusion.class);
            intent.putExtra("trueCounter", trueCounter);
            startActivity(intent);
            finish();

        } else {
            questionLoad();
        }
    }
}