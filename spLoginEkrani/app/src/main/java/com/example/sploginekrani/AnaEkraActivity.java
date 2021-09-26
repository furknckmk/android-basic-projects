package com.example.sploginekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnaEkraActivity extends AppCompatActivity {
    private Button buttonCikisYap;
    private TextView textViewCikti;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private int girissorgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekra);

        buttonCikisYap= findViewById(R.id.buttonCikisyap);
        textViewCikti = findViewById(R.id.textView2);
        sp= getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor= sp.edit();

        username=sp.getString("username","kullanici adi yok");
        password = sp.getString("password","Sifre yok");
        girissorgu =sp.getInt("girissorgu",0);
        editor.putInt("girissorgu",1);
        editor.commit();
        textViewCikti.setText("Username : "+username+" Password : "+password);

        buttonCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("username");
                editor.remove("password");
                editor.putInt("girissorgu",0);
                editor.commit();

                startActivity(new Intent(AnaEkraActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}