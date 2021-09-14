package com.example.sayfalararasiveritasima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonGotoB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGotoB = findViewById(R.id.buttonGotoB);

        buttonGotoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Kisiler kisi = new Kisiler(9999,"Ahmet",1.87);

                Intent yeniIntent = new Intent(MainActivity.this,ActivityB.class);

                yeniIntent.putExtra("mesaj","merhaba");
                yeniIntent.putExtra("yas",18);
                yeniIntent.putExtra("boy",1.78);

                yeniIntent.putExtra("nesne",kisi);

                startActivity(yeniIntent);


            }
        });
    }
}
