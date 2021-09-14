package com.example.sayfalararasiveritasima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        String gelenMesaj = getIntent().getStringExtra("mesaj");
        int gelenYas = getIntent().getIntExtra("yas",0);
        double gelenBoy = getIntent().getDoubleExtra("boy",0.0);

        Kisiler gelenKisi = (Kisiler) getIntent().getSerializableExtra("nesne");

        Log.e("Gelen Mesaj",gelenMesaj);
        Log.e("Gelen Yaş",String.valueOf(gelenYas));
        Log.e("Gelen Boy",String.valueOf(gelenBoy));

        Log.e("Gelen Tcno",String.valueOf(gelenKisi.getTcno()));
        Log.e("Gelen İsim",gelenKisi.getIsim());
        Log.e("Gelen Kişi Boy",String.valueOf(gelenKisi.getBoy()));


    }
}
