package com.example.depolamaislem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private EditText editTextGirdi;
    private Button buttonOku, buttonYaz, buttonSil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonOku = findViewById(R.id.buttonOku);
        buttonSil = findViewById(R.id.buttonSil);
        buttonYaz = findViewById(R.id.buttonYaz);


        buttonYaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // hariciCYaz();
                dahiliYaz();
            }
        });

        buttonOku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void hariciCYaz() {

        File dosyaYolu = Environment.getExternalStorageDirectory(); // dosyanin yolu
        File dir = new File(dosyaYolu.getAbsolutePath() + "/storage/emulator/0/dosyam.txt/"); // dosya olusturma
        // Toast.makeText(getApplicationContext(),"Loglandi",Toast.LENGTH_SHORT).show();
        if (!dir.exists()) {            // varmi yokmu kontrol ettik
            dir.mkdir();
            //Toast.makeText(getApplicationContext(),"Loglandi",Toast.LENGTH_SHORT).show();
        }

        File file = new File(dir, "dosyam.txt");
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            String data = editTextGirdi.getText().toString();
            os.write(data.getBytes(StandardCharsets.UTF_8));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        editTextGirdi.setText(""); // yazma islemi bitince en son yazdigimiz yaziyi yok etmesini istedik
        Toast.makeText(getApplicationContext(), "Loglandiee", Toast.LENGTH_SHORT).show();


    }

    public void dahiliYaz(){
        try {
            FileOutputStream fos =openFileOutput("dosyam.txt",MODE_PRIVATE);

            OutputStreamWriter yazici = new OutputStreamWriter(fos);

            yazici.write(editTextGirdi.getText().toString());


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}