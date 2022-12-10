package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_result = findViewById(R.id.tv_result);
        Intent intent = getIntent();

        String name = intent.getStringExtra("name"); // "name" 이 없으면 null이 담긴다
        int age = intent.getIntExtra("age", 0); // 근데 "age" 가 없어도 int에는 null을 넣을 수 없다. 그래서 디폴트 0을 설정해야한다
        boolean isCheck = intent.getBooleanExtra("isCheck", false); // 얘도 마찬가지
        String[] foods = intent.getStringArrayExtra("foods"); 
        int[] nums = intent.getIntArrayExtra("nums"); // 아래 두개의 데이터타입에는 null이 들어갈 수 있다

        String result = name + " / ";
        result += age + " / ";
        result += isCheck + " / ";
        result += Arrays.toString(foods) + " / ";
        result += Arrays.toString(nums);

        tv_result.setText(result);
        
        

    }
}