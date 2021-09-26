package com.example.toolbardesign2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Toolbar Menu");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.action_Info:
                Toast.makeText(getApplicationContext(),"Info Selected",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.action_tools:
                Toast.makeText(getApplicationContext(),"Tools Selected",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.action_exit:
                Toast.makeText(getApplicationContext(),"Exit Selected",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.action_add:
                Toast.makeText(getApplicationContext(),"Add Selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}