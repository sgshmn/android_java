package com.example.myapplication0809;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorBack extends AppCompatActivity {

    private ConstraintLayout lay_back;
    private Button btn_back;

    private String[] color_strs = {"하양", "빨강", "초록", "파랑", "검정"};
    private int[] colors = {Color.WHITE, Color.RED, Color.GREEN, Color.BLUE, Color.BLACK};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_back);

        lay_back = findViewById(R.id.lay_back);
        btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ColorChoice.class);

                startActivityForResult(intent, 893);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 893 && resultCode == 894) {

            String color = data.getStringExtra("color");

            for (int i = 0; i < color_strs.length; i++) {
                if (color.equals(color_strs[i])) {
                    lay_back.setBackgroundColor(colors[i]);
                    break;
                }
            }
        }



        super.onActivityResult(requestCode, resultCode, data);
    }
}