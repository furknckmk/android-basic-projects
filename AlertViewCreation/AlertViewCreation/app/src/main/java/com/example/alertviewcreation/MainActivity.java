package com.example.alertviewcreation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonNormal,buttonSpecial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNormal=findViewById(R.id.buttonNormal);
        buttonSpecial=findViewById(R.id.buttonSpecial);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad= new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("Mesaj");
                ad.setTitle("Baslik");
                ad.setIcon(R.drawable.picture);

                ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Tamam Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("Iptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Iptal Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });

                ad.create().show();
            }
        });

        buttonSpecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            View design=getLayoutInflater().inflate(R.layout.alert_design,null);
           final EditText editTextAlert= design.findViewById(R.id.editTextAlert);

            AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
            ad.setTitle("Design WELCOME");
            ad.setIcon(R.drawable.picture);
            ad.setView(design);
                ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String gelenveri= editTextAlert.getText().toString();
                        Toast.makeText(getApplicationContext(),"Gelen Veri : "+gelenveri,Toast.LENGTH_SHORT).show();



                    }
                });
                ad.setNegativeButton("Iptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Iptal Tiklandi",Toast.LENGTH_SHORT).show();
                    }
                });
            ad.create().show();
            }
        });

    }
}