package com.example.flagquestionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Conclusion extends AppCompatActivity {
        private TextView textViewTrueConc,textViewFalseConc,textViewSucces;
        private Button buttonAgain;
        private int dogruSayac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion);

            textViewFalseConc = findViewById(R.id.textViewFalseConc);
        textViewTrueConc = findViewById(R.id.textViewTrueConc);
        textViewSucces = findViewById(R.id.textViewSuccess);
        buttonAgain = findViewById(R.id.buttonAgain);
        dogruSayac = getIntent().getIntExtra("trueCounter",0);
        textViewTrueConc.setText(dogruSayac+" : TRUE");
        textViewFalseConc.setText((5-dogruSayac)+" : FALSE");
        textViewSucces.setText((dogruSayac*20)+"% Success");
        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Conclusion.this,Questions.class));
                finish();
            }
        });
    }
}