package com.example.backstackuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ActivityD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent ıntent =  new Intent(ActivityD.this,ActivityB.class);

        ıntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(ıntent);

    }
}
