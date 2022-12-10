package com.example.myapplication0810;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {

    private ListView kakaoList;
    private KakaoAdapter kakaoAdapter = new KakaoAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        kakaoList = findViewById(R.id.kakaoList);

        kakaoAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile1), "아인슈타인", "E = mc^2");
        kakaoAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile2), "뉴턴", "F = ma");
        kakaoAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile3), "볼츠만", "S = logW");
        kakaoAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile4), "맥스웰", "c = 1/root(ue)");
        kakaoAdapter.addItem(ContextCompat.getDrawable(this, R.drawable.profile5), "플랑크", "E = hf");

        kakaoList.setAdapter(kakaoAdapter);


    }
}