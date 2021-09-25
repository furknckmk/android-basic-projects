package com.example.flagquestionapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

public class FlagDao {

    public ArrayList<FlagConstructor> getRandom5(DataBase dataBase){
        ArrayList<FlagConstructor> flagConstructorArrayList = new ArrayList<>();
        SQLiteDatabase db= dataBase.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null);
        while (c.moveToNext()){
            FlagConstructor f= new FlagConstructor(c.getInt(c.getColumnIndex("bayrak_id")),
                    c.getString(c.getColumnIndex("bayrak_ad"))
                    ,c.getString(c.getColumnIndex("bayrak_resim")));

            flagConstructorArrayList.add(f);

        }

        return  flagConstructorArrayList;
    }
    public ArrayList<FlagConstructor> getRandom3false(DataBase dataBase, int bayrak_id){
        ArrayList<FlagConstructor> flagConstructorArrayList = new ArrayList<>();
        SQLiteDatabase db= dataBase.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id !="+bayrak_id+" ORDER BY RANDOM() LIMIT 3", null);

        while (c.moveToNext()){
            FlagConstructor f= new FlagConstructor(c.getInt(c.getColumnIndex("bayrak_id")),
                    c.getString(c.getColumnIndex("bayrak_ad"))
                    ,c.getString(c.getColumnIndex("bayrak_resim")));
            flagConstructorArrayList.add(f);
        }

        return  flagConstructorArrayList;
    }
}
