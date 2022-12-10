package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv_input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_input = findViewById(R.id.tv_input);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv_input.setText(name);


    }
}