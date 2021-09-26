package com.example.sqlitecalismasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBManager dm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm=new DBManager(this);

        Kelimeler kelime =new KelimelerDao().kelimeGetir(dm,5);

        Log.e("Kelime",kelime.getIngilizce()+" - "+kelime.getTurkce());

       /* new KelimelerDao().kelimeSil(dm,10);
        new KelimelerDao().kelimeGuncelle(dm,"boy","oglan",6);
        new KelimelerDao().kelimeEkle(dm,"phone","telefon");*/

      /*  int sonuc = new KelimelerDao().kayitKontrol(dm);
        Log.e("Veri Sayisi", String.valueOf(sonuc));*/
      /*  new KelimelerDao().kelimeEkle(dm,"door","kapi");
        new KelimelerDao().kelimeEkle(dm,"numara","number");
        new KelimelerDao().kelimeEkle(dm,"telefon","phone");
        new KelimelerDao().kelimeEkle(dm,"bilgisayar","computer");
        new KelimelerDao().kelimeEkle(dm,"girl","kiz");
        new KelimelerDao().kelimeEkle(dm,"boy","oglan");*/


        ArrayList<Kelimeler> gelenKelimelerListesi = new KelimelerDao().tumKelimeler(dm);

        for (Kelimeler k:gelenKelimelerListesi){

            Log.e(String.valueOf(k.getKelime_id()),k.getTurkce()+" - "+k.getIngilizce());
        }


    }
}