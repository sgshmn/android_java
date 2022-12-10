package com.example.myapplication0809;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main1;
    private Button btn_main1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_main1 = findViewById(R.id.tv_main1);
        btn_main1 = findViewById(R.id.btn_main1);

        btn_main1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                startActivityForResult(intent, 1729); // 짝대기가 그어졌네. 지금은 쓸 수 있지만 앞으로 쓰는 것을 권장하지 않는다는 뜻
                                                                 // 원래 켜져있는 창으로 돌아가는 코드




            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // Intent 타입의 data를 쓰는 조건이 필요하다

        if (requestCode == 1729 && resultCode == 8128) {
            String value = data.getStringExtra("value");
            tv_main1.setText(value);
        }

        super.onActivityResult(requestCode, resultCode, data);





    }
}