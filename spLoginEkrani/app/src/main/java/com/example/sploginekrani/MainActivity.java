package com.example.sploginekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername,editTextPassword;
    private Button buttonGiris;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    private int girissorgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword=findViewById(R.id.editTextTextPassword);
        editTextUsername=findViewById(R.id.editTextTextPersonName);
        buttonGiris=findViewById(R.id.buttonGiris);

        sp= getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor= sp.edit();

        username=sp.getString("username","kullanici adi yok");
        password = sp.getString("password","Sifre yok");
        girissorgu =sp.getInt("girissorgu",0);
        if (girissorgu==1){

            startActivity(new Intent(MainActivity.this,AnaEkraActivity.class));
            finish();
        }

        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUsername.getText().toString().equals("admin") &&
                        editTextPassword.getText().toString().equals("123")){

                    editor.putString("username",editTextUsername.getText().toString());
                    editor.putString("password",editTextPassword.getText().toString());

                    editor.commit();
                    startActivity(new Intent(MainActivity.this,AnaEkraActivity.class));
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(),"Giris Hatali",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}