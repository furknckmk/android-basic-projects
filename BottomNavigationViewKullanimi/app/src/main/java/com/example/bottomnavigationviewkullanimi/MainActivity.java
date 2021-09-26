package com.example.bottomnavigationviewkullanimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottom_navigation;
    private Fragment tempFragment;
    private FrameLayout aMainFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation=findViewById(R.id.bottom_navigation);
        aMainFrame =(BottomNavigationView) findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu,new FragmentBirinci()).commit();
        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.action1){
                  //  Toast.makeText(getApplicationContext(),"Birinci Tiklandi",Toast.LENGTH_SHORT).show();

                    tempFragment=new FragmentBirinci();

                }
                if (item.getItemId()==R.id.action2){
                    Toast.makeText(getApplicationContext(),"Ikinci Tiklandi",Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentIkinci();

                }
                if (item.getItemId()==R.id.action3){
                    Toast.makeText(getApplicationContext(),"Ucuncu Tiklandi",Toast.LENGTH_SHORT).show();
                    tempFragment=new FragmentUcuncu();

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu,tempFragment).commit();
                return true;



            }
        });
    }

}