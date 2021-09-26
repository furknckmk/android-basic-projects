package com.example.sqlitecalismasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.*;

import java.util.ArrayList;

public class KelimelerDao {

    public void kelimeEkle(DBManager dm,String ingilizce,String turkce){

        SQLiteDatabase dbx=dm.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce",ingilizce);
        degerler.put("turkce",turkce);

        dbx.insertOrThrow("kelimeler",null,degerler);
        dbx.close();
    }
    public ArrayList<Kelimeler> tumKelimeler(DBManager dm){
        ArrayList<Kelimeler> kelimelerArrayList =new ArrayList<>();
        SQLiteDatabase dbx= dm.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler",null);

        while(c.moveToNext()){
            Kelimeler kelime =new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("turkce")),c.getString(c.getColumnIndex("ingilizce")));

        kelimelerArrayList.add(kelime);
        }
 return kelimelerArrayList;
    }
    public void kelimeSil(DBManager dm,int kelime_id){
        SQLiteDatabase dbx=dm.getWritableDatabase();
        dbx.delete("kelimeler","kelime_id=?",new String[]{String.valueOf(kelime_id)});
        dbx.close();

    }
    public void kelimeGuncelle(DBManager dm,String ingilizce,String turkce,int kelime_id){

        SQLiteDatabase dbx=dm.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("ingilizce",ingilizce);
        degerler.put("turkce",turkce);

        dbx.update("kelimeler",degerler,"kelime_id=?",new String[]{String.valueOf(kelime_id)});
        dbx.close();
    }

    public int kayitKontrol(DBManager dm){
        int sonuc = 0;
        SQLiteDatabase dbx=dm.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT count(*) as sonuc FROM kelimeler",null);

        while (c.moveToNext()){

            sonuc = c.getInt(c.getColumnIndex("sonuc"));
        }
        return sonuc;
    }
        public Kelimeler kelimeGetir(DBManager dm,int kelime_id){
            Kelimeler kelime =new Kelimeler();
            SQLiteDatabase dbx=dm.getWritableDatabase();

            Cursor c = dbx.rawQuery("SELECT * FROM kelimeler WHERE kelime_id="+kelime_id,null);
            while (c.moveToNext()){
                Kelimeler k =new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                        ,c.getString(c.getColumnIndex("turkce")),c.getString(c.getColumnIndex("ingilizce")));

                kelime =k;
            }
            return kelime;
        }
}
