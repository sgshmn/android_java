package com.example.myapplication0728;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // manifests를 연다
        // exported의 / 를 지운다
        // 다음줄에 </를 치면</activity>가 생긴다
        // intent filter를 mainActivity2로 옮긴다
        // exported를 true로 바꾼다
    }
}