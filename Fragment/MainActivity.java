package com.example.fragmentcalismayapisi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        ft.add(R.id.fragmentTutucu,new FragmentBirinci());
        ft.add(R.id.fragmentTututucu2,new FragmentIkinci());

        ft.commit();
    }
}