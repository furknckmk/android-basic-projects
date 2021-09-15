package com.example.recyclerviewuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<String> ulkelerList;
    private BasicRVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=findViewById(R.id.rv);
        //icerisine ekleyecegemiz listelerin
        // size sini fixlemek icin duzenli durmasi icin/
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));
        //rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ulkelerList=new ArrayList<>();
        ulkelerList.add("Turkiye");
        ulkelerList.add("Italya");
        ulkelerList.add("Almanya");
        ulkelerList.add("Kanada");
        ulkelerList.add("Ingiltere");
        ulkelerList.add("Turkiye");
        ulkelerList.add("Italya");
        ulkelerList.add("Almanya");
        ulkelerList.add("Kanada");
        ulkelerList.add("Ingiltere");
        ulkelerList.add("Turkiye");
        ulkelerList.add("Italya");
        ulkelerList.add("Almanya");
        ulkelerList.add("Kanada");
        ulkelerList.add("Ingiltere");

        adapter=new BasicRVAdapter(this,ulkelerList);

        rv.setAdapter(adapter);


    }
}