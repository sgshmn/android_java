package com.example.myapplication0809;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText edt_main2;
    private Button btn_main2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt_main2 = findViewById(R.id.edt_main2);
        btn_main2 = findViewById(R.id.btn_main2);

        btn_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = edt_main2.getText().toString();

                Intent intent = new Intent(); // 미리 돌아온다고 설정했기 때문에 시작점과 경로를 적을 필요가 없다

                intent.putExtra("value", value);

                setResult(8128, intent);
                finish(); // 지금 켜져있는 main2 창을 닫아야 main1 창으로 갈 수 있다


            }
        });
    }
}