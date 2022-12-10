package com.example.myapplication0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class LottoResult extends AppCompatActivity {

    private int[] com_ids = {R.id.tv_com1, R.id.tv_com2, R.id.tv_com3, R.id.tv_com4, R.id.tv_com5, R.id.tv_com6};
    private int[] user_ids = {R.id.tv_user1, R.id.tv_user2, R.id.tv_user3, R.id.tv_user4, R.id.tv_user5, R.id.tv_user6};

    private TextView[] tv_coms = new TextView[com_ids.length];
    private TextView[] tv_users = new TextView[com_ids.length];

    private TextView tv_rank;

    private ArrayList<Integer> nnn = new ArrayList<Integer>();
    private int[] comLotto = new int[com_ids.length];
    private int[] userLotto = new int[com_ids.length];

    private Random rd = new Random();


    private int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_result);

        // 전 페이지에서 내가 입력한 로또번호 가져오기
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // 화면이 돌아가는 순간 새로운 로또 번호가 생성된다

        Intent intent = getIntent();

        tv_rank = findViewById(R.id.tv_rank);

        userLotto = intent.getIntArrayExtra("userLotto");


        // 로또 번호 만들기
        for (int i = 1; i <= 45; i++) {
            nnn.add(i);
        }

        for (int i = 0; i < com_ids.length ; i++) {
            int r = rd.nextInt(nnn.size());
            comLotto[i] = nnn.get(r);
            nnn.remove(r);
        }

//        for (int i = 0; i < coms.length; i++) { // 로또 확인용 코드 나중에 주석처리하자
//            comLotto[i] = i + 1;
//        }

        // 당첨번호와 내가 적은 로또번호 띄우기
        for (int i = 0; i < com_ids.length; i++) {
            tv_coms[i] = findViewById(com_ids[i]);
            tv_users[i] = findViewById(user_ids[i]);


        }

        for (int i = 0; i < com_ids.length; i++) {
            tv_coms[i].setText(comLotto[i] + "");
            tv_users[i].setText(userLotto[i] + "");
        }


        // 로또 당첨 여부 알아내기
        cnt = 0;

        for (int i = 0; i < com_ids.length; i++) {
            for (int j = 0; j < com_ids.length; j++) {
                if (comLotto[i] == userLotto[j]) {
                    cnt++;
                    break;
                }
            }
        }

        String result;
        if (cnt == 6) {
            result = "1등!!!";
        } else if (cnt == 5) {
            result = "2등!!!";
        } else if (cnt == 4) {
            result = "3등!!!";
        } else {
            result = cnt + "개 맞았습니다";
        }

        tv_rank.setText(result);


    }
}