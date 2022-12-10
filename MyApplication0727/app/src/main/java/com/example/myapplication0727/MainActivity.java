package com.example.myapplication0727;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


// 이벤트 구동방식 2번째 > 리스너를 상속 받아서 구현
public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tv_num;
    private Button btn_plus, btn_minus;
    private String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_num = findViewById(R.id.tv_num);
        // xml에 있는 view를 java애서 사용할 수 있게 함

        btn_plus = findViewById(R.id.plus_btn);
        // btn_plus에 onClickListener를 달고 실행 메소드로
        // 현재 클래스에 있는 onClick을 지정한다
        btn_plus.setOnClickListener(this);

        btn_minus = findViewById(R.id.minus_btn);
        btn_minus.setOnClickListener(this);


        // 더하기 버튼을 눌렀을 때 TextView에 있는 숫자가 1 증가하도록 만들기


    }

    public void plus(View view) {

        // 버튼을 누를 때마다 TextView의 내용을 가져와야 한다
        // 그래서 num 변수에 대입을 여기서 한다
        num = tv_num.getText().toString();
        int numData = Integer.parseInt(num);
        numData++;
        // setText는 문자열에 대한 데이터만 매개변수로 받을 수 있다
        tv_num.setText(String.valueOf(numData));
    }

    public void minus(View view) {

        num = tv_num.getText().toString();
        int numData = Integer.parseInt(num);
        numData--;
        tv_num.setText(String.valueOf(numData));
    }

    @Override
    public void onClick(View view) {

        // View : 클릭한 객체의 정보를 가지고 있다.



         if (view.getId() == R.id.plus_btn) {// 플러스 버튼을 눌렀다면

             num = tv_num.getText().toString();
             int numData = Integer.parseInt(num);
             numData++;
             tv_num.setText(String.valueOf(numData));

         } else if (view.getId() == R.id.minus_btn) { // 마이너스 버튼을 눌렀다면

             num = tv_num.getText().toString();
             int numData = Integer.parseInt(num);
             numData--;
             tv_num.setText(String.valueOf(numData));

         }


    }
}