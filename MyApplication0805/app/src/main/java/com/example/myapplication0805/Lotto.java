package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lotto extends AppCompatActivity {

    private Button btn_lotto;

    private int[] edt_ids = {R.id.edt_lotto1, R.id.edt_lotto2, R.id.edt_lotto3, R.id.edt_lotto4, R.id.edt_lotto5, R.id.edt_lotto6};
    private EditText[] edts = new EditText[edt_ids.length];

    private int[] userLotto = new int[edts.length];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto);

        // 화면을 가로로 고정하기
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // 번호생성 버튼 눌렀을 때
        // edt_lotto1 ~ 6까지 입력한 수를 정수형 배열에 저장하기
        btn_lotto = findViewById(R.id.btn_lotto);

        for (int i = 0; i < edts.length; i++) {
            edts[i] = findViewById(edt_ids[i]);
        }

        btn_lotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < edts.length; i++) {
                    userLotto[i] = Integer.parseInt(edts[i].getText().toString());
                }

                Intent intent = new Intent(getApplicationContext(), LottoResult.class);
                intent.putExtra("userLotto", userLotto);

                startActivity(intent);



            }
        });





    }
}