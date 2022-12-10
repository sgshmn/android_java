package com.example.myapplication0726;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout lay_con;
    private Button btn_red;
    private Button btn_blue;
    private Button btn_green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lay_con = findViewById(R.id.lay_con);


        btn_red = findViewById(R.id.btn_red);
        btn_red.setOnClickListener(this);
        btn_blue = findViewById(R.id.btn_blue);
        btn_blue.setOnClickListener(this);
        btn_green = findViewById(R.id.btn_green);
        btn_green.setOnClickListener(this);


    }

    // 이벤트 적용 방법 1
    // 메소드를 만들어서 각각의 view에 적용하는 방법
    public void ChangeRed(View view) {
        // View : 이 함수를 실행한 객체를 담는 변수
        lay_con.setBackgroundColor(Color.parseColor("red"));
    }

    public void ChangeBlue(View view) {
        lay_con.setBackgroundColor(Color.parseColor("blue"));
    }

    public void ChangeGreen(View view) {
        lay_con.setBackgroundColor(Color.parseColor("green"));
    }


    // 이벤트 적용 방법 2로도 해보자 0727
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_red) {

            lay_con.setBackgroundColor(Color.parseColor("red"));

        } else if (view.getId() == R.id.btn_blue) {

            lay_con.setBackgroundColor(Color.parseColor("blue"));

        } else if (view.getId() == R.id.btn_green) {

            lay_con.setBackgroundColor(Color.parseColor("green"));

        }



    }
}