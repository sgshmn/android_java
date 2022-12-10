package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = new Intent(this, MainActivity4.class);

        // 여러가지 데이터를 Intent에 담기
        String name = "yyw";
        int age = 20;
        boolean isCheck = true;
        String[] foods = {"팟타이", "볶음밥", "감자튀김"};
        int[] nums = {45, 5, 24, 687};

        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("isCheck", isCheck);
        intent.putExtra("foods", foods);
        intent.putExtra("nums", nums); // 오버로딩

        startActivity(intent);

    }
}