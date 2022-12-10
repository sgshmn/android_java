package com.example.myapplication0808;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        MemberVO vo = (MemberVO)intent.getSerializableExtra("vo");

        tv_join = findViewById(R.id.tv_join);

        tv_join.setText(vo.getNick() + " 어서오고");

    }
}