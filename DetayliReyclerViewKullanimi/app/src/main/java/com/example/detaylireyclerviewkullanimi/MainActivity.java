package com.example.detaylireyclerviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList filmsArraylist;
    private FilmAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        Films f1=new Films(1,"After","after",12.99);
        Films f2=new Films(2,"365 Days","days365",15.99);
        Films f3=new Films(3,"Game Of Thrones","gameofthrones",19.99);
        Films f4=new Films(4,"Sifir Bir","sifirbir",9.99);
        Films f5=new Films(5,"The Tomorrow","thetomorrow",11.99);
        Films f6=new Films(6,"Vikings","vikings",13.99);
        Films f7=new Films(7,"Wonder Woman","wonderwoman",18.99);
        filmsArraylist = new ArrayList<>();
        filmsArraylist.add(f1);
        filmsArraylist.add(f2);
        filmsArraylist.add(f3);
        filmsArraylist.add(f4);
        filmsArraylist.add(f5);
        filmsArraylist.add(f6);
        filmsArraylist.add(f7);

        adapter=new FilmAdapter(this,filmsArraylist);
        rv.setAdapter(adapter);
    }
}