package com.example.myapplication0728;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtv_n1, edtv_n2;

    private Button btn_plus, btn_minus, btn_mul, btn_div;

    private TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtv_n1 = findViewById(R.id.edtv_n1);
        edtv_n2 = findViewById(R.id.edtv_n2);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);

       /* btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);*/


        
        // 이벤트 적용 3번째 방법 (익명 클래스 구현)
        // 인터페이스인 리스너를 직접 버튼에 구현한다
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edtv_n1.getText().toString());
                int n2 = Integer.parseInt(edtv_n2.getText().toString());
                
                tv_result.setText("연산 결과 : " + (n1 + n2));
                
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edtv_n1.getText().toString());
                int n2 = Integer.parseInt(edtv_n2.getText().toString());

                tv_result.setText("연산 결과 : " + (n1 - n2));

            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edtv_n1.getText().toString());
                int n2 = Integer.parseInt(edtv_n2.getText().toString());

                tv_result.setText("연산 결과 : " + (n1 * n2));

            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double n1 = Integer.parseInt(edtv_n1.getText().toString());
                double n2 = Integer.parseInt(edtv_n2.getText().toString());

                if (n2 != 0) {
                    tv_result.setText("연산 결과 : " + (n1 / n2));
                } else {
                    tv_result.setText("0으로는 못 나눠 멍청아");
                }


            }
        });

        tv_result = findViewById(R.id.tv_result);

        

    }

//    이벤트 적용 2번째 방법
//    @Override 
//    public void onClick(View view) {
//
//        int n1 = Integer.parseInt(edtv_n1.getText().toString());
//
//        int n2 = Integer.parseInt(edtv_n2.getText().toString());
//
//        int result = 0;
//
//        if (view.getId() == R.id.btn_plus) {
//            result = n1 + n2;
//        } else if (view.getId() == R.id.btn_minus) {
//            result = n1 - n2;
//        } else if (view.getId() == R.id.btn_mul) {
//            result = n1 * n2;
//        } else if (view.getId() == R.id.btn_div) {
//            result = n1 / n2;
//        }
//
//        tv_result.setText("연산결과 : " + result);
//
//    }

}