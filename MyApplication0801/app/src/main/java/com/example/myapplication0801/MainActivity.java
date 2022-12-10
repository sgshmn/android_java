package com.example.myapplication0801;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img_bluehole;
    private Button btn_bluehole;
    private boolean visi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이미지를 불러오려면 이미지의 이름이 변수 이름 규칙을 지켜야한다
        // jpg png gif bmp 확장자만 된다

        // findViewById는 setContentView 이후에 나와야 한다
        // ImageView img_bluehole = (ImageView) findViewById(R.id.img_bluehole); // 전에는 이렇게 했다.
        img_bluehole = findViewById(R.id.img_bluehole); // 세상이 좋아져서 다운캐스팅을 명시하지 않아도 오류가 안 생긴다
        btn_bluehole = findViewById(R.id.btn_bluehole);

        visi = true;

        btn_bluehole.setOnClickListener(new View.OnClickListener() { // View.OnClickListener 이놈은 인터페이스다
            @Override                                                // 익명 클래스 방법, 버튼의 개수가 그리 많지 않을 때 쓴다???
            public void onClick(View view) {

                if (visi) {
                    img_bluehole.setVisibility(View.INVISIBLE);
                    btn_bluehole.setText("나타나");    // button의 부모 : textview, textivew의 부모 : view
                } else {
                    img_bluehole.setVisibility(View.VISIBLE);
                    btn_bluehole.setText("사라져");
                }
                visi = !visi;

            }
        });

        btn_bluehole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}