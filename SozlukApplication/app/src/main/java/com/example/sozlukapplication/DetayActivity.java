package com.example.sozlukapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewIngilizce,textViewTurkce;
    private Kelimeler kelime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        textViewIngilizce = findViewById(R.id.textViewIngilizce2);
        textViewTurkce = findViewById(R.id.textViewTurkcee);

        kelime =(Kelimeler) getIntent().getSerializableExtra("nesnee");
        textViewIngilizce.setText(kelime.getIngilizce());
       textViewTurkce.setText(kelime.getTurkce());




    }
}