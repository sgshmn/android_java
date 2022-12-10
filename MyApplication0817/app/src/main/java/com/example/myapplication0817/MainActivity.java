package com.example.myapplication0817;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    public static String testString;
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    private FragmentC fragmentC;
    private FragmentD fragmentD;
    private FragmentE fragmentE;

    private FragmentManager fm;

    private BottomNavigationView navi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testString = "good";

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        fragmentC = new FragmentC();
        fragmentD = new FragmentD();
        fragmentE = new FragmentE();

        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.frame, fragmentA).commit();

        navi = findViewById(R.id.navi);
        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int selectedId = item.getItemId();

                if (selectedId == R.id.page1){
                    fm.beginTransaction().replace(R.id.frame, fragmentA).commit();
                } else if (selectedId == R.id.page2){
                    fm.beginTransaction().replace(R.id.frame, fragmentB).commit();
                } else if (selectedId == R.id.page3){
                    fm.beginTransaction().replace(R.id.frame, fragmentC).commit();
                } else if (selectedId == R.id.page4){
                    fm.beginTransaction().replace(R.id.frame, fragmentD).commit();
                } else if (selectedId == R.id.page5){
                    fm.beginTransaction().replace(R.id.frame, fragmentE).commit();
                }


                return true;
            }
        });

    }
}