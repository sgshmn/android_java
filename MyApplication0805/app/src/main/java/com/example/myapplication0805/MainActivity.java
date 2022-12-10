package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_input;
    private Button btn_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input = findViewById(R.id.edt_input);
        btn_input = findViewById(R.id.btn_input);

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = edt_input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                // intent안에 데이터 넣을 수 있다!
                // 기본자료형 8가지는 다 된다
                // 레퍼런스 자료형은 String과 Serializable만 된다
                // 데이터를 넣을 때 putExtra()로 넣는다
                // Key와 Value형태로 넣는다
                intent.putExtra("name", value);
                startActivity(intent);


//                Intent intent = new Intent(getApplicationContext(), ); 이건 기존에 배운거
//                Intent intent = new Intent(this, ); 이렇게 쓸수 있다. 익명 클래스 방식으로 하지 않았다면
//                                                  익명 클래스 안에서는 지역변수도 쓸 수 없다. 전역변수는 가능
//                Intent intent = new Intent(MainActivity.this, ); 이건 가능하다



            }
        });

    }
}