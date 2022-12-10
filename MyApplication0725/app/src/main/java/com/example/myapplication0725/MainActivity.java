package com.example.myapplication0725;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;
    private String data, data1;
    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 파일을 사용자에게 띄워주는 역할

        tv_text = findViewById(R.id.tv_text);
        data = tv_text.getText().toString(); // toString 은 xml을 java에서 인식할 수 있는 문자열로 만든다
//        data = String.valueOf(tv_text.getText());  애도 윗줄이랑 같다 윗줄이 더 편하다
        // 그런데 toString은 안 되는 객체도 있다
        // 버튼 눌렀을 때 EditText에 적은 값을 Log.d로 출력
        // 버튼을 눌렀을 때다 멍청아 여기 말고 버튼 클릭 했을 때 실행하는 메소드에 넣어야지!!!!

    }

    public void click1(View view){
        edit_text = findViewById(R.id.edit_text);
        data1 = edit_text.getText().toString();
        Log.d("첫 화면 : ", data);
        Log.d("edit_text : ", data1);
        tv_text.setText(data1);
    }
}