package com.example.myapplication0802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    private int[] ids = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12};
    private Button[] btns = new Button[ids.length];
    private Random rd = new Random();
    private int[] ns = new int[btns.length];
    private ArrayList<Integer> temps = new ArrayList<Integer>(); // ArrayList는 레퍼런스 자료형만 쓸 수 있다

    private int rev = -1;
    private int order = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        for (int i = 0; i < btns.length; i++) {
            btns[i] = findViewById(ids[i]);
            btns[i].setOnClickListener(this);
            btns[i].setVisibility(View.INVISIBLE);
        }

        btns[7].setText("start");
        btns[7].setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View view) {

        Button btn = (Button)view;
        String btnStr = btn.getText().toString();
        Toast.makeText(getApplicationContext(), btnStr, Toast.LENGTH_SHORT).show();

        int tmp;
        if (rev == -1) {
            tmp = 0;
        } else {
            tmp = Integer.parseInt(btnStr);
        }

        if (tmp == order + rev * btns.length) {
            order++;
            view.setVisibility(View.INVISIBLE);
        }

        if (order == btns.length + 1) {

            rev++;
            for (int i = rev * btns.length + 1; i < (rev + 1) * btns.length + 1; i++) {
                temps.add(i);
            }

            for (int i = 0; i < btns.length; i++) {
                int x = rd.nextInt(temps.size());
                ns[i] = temps.get(x);
                temps.remove(x);
                btns[i].setText(ns[i] + "");
                btns[i].setVisibility(View.VISIBLE);
            }

            order = 1;
        }

        if (rev == 4) {
            for (int i = 0; i < btns.length; i++) {
                btns[i].setVisibility(View.INVISIBLE);
            }
        }

    }
}