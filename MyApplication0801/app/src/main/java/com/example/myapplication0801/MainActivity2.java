package com.example.myapplication0801;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    private ImageView img_main;
    private Button btn_pre, btn_post;
    private int cnt = 0;
    private int[] img_id = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img_main = findViewById(R.id.img_main);
        btn_pre = findViewById(R.id.btn_pre);
        btn_post = findViewById(R.id.btn_post);

        btn_pre.setOnClickListener(this);
        btn_post.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_pre) {
            if (cnt > 0) cnt--;
            else cnt = 4;
        } else {
            if (cnt < 4) cnt++;
            else cnt = 0;
        }
        img_main.setImageResource(img_id[cnt]);

    }
}