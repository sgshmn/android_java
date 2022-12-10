package com.example.myapplication0809;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorChoice extends AppCompatActivity implements View.OnClickListener{

    private int[] btn_ids = {R.id.btn_white, R.id.btn_red, R.id.btn_green, R.id.btn_blue, R.id.btn_black};
    private Button[] btn_colors = new Button[btn_ids.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_choice);

        for (int i = 0; i < btn_ids.length; i++) {
            btn_colors[i] = findViewById(btn_ids[i]);
            btn_colors[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        Button btn = (Button)view;

        intent.putExtra("color", btn.getText().toString());

        setResult(894, intent);
        finish();

    }
}