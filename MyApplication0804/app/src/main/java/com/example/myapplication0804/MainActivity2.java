package com.example.myapplication0804;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText edt_start, edt_end;
    private Button btn_googoo;
    private TextView tv_googoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt_start = findViewById(R.id.edt_start);
        edt_end = findViewById(R.id.edt_end);
        btn_googoo = findViewById(R.id.btn_googoo);
        tv_googoo = findViewById(R.id.tv_googoo);

        btn_googoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ns = Integer.parseInt(edt_start.getText().toString());
                int ne = Integer.parseInt(edt_end.getText().toString());
                String result = "";
                for (int i = 1; i <= 9; i++) {
                    for (int j = ns; j <= ne; j++) {
                        result += String.format("%2d X %2d = %3d \t",j,i,j*i);;
//                        int multi = j*i;
//                        int lngth = 0;
//                        while (multi > 0) {
//                            lngth++;
//                            multi /= 10;
//                        }
//                        for (int k = 0; k < 5 - lngth; k++) {
//                            result = result + "  ";
//                        }     줄을 맞춰서 출력하려고 한 흔적이다. 안드로이드 TextView에서는 띄어쓰기와 숫자의 글자 크기가 달라서 실패했다
//                              자바 문자열 포맷팅을 하면 해결할 수 있다. String.format
                    }
                    result += "\n";
                }
                tv_googoo.setText(result);

            }
        });

    }
}