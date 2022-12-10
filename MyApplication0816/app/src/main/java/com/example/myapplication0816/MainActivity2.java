package com.example.myapplication0816;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    // 두더지 터치 개수를 알려주는 TextView
    private TextView tv_result;

    // ImageView
    private int[] img_ids = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};
    private int l = img_ids.length;
    private ImageView[] imgs = new ImageView[l];


    // 게임 실행 여부를 확인하는 변수
    private boolean isPlaying = true;

    private int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_result = findViewById(R.id.tv_result);

        for (int i = 0; i < l; i++) {
            imgs[i] = findViewById(img_ids[i]);
            imgs[i].setTag("off");
            int k = 10;
            MyThread myThread = new MyThread(i);
            myThread.start(); // 이상하다 myThread가 계속 바뀔 텐데 실행은 잘 된다
            final int pos = i; // 익명 클래스 안에서 쓸려고 상수로 만듬
            imgs[pos].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String status = imgs[pos].getTag().toString();

                    if (status.equals("on")) {
                        cnt++;
                    } else {
                        cnt--;
                    }

                }
            });

        }


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int pos = msg.arg1;
            int img = msg.arg2;
            String status = (String)msg.obj;

            imgs[pos].setTag(status);
            imgs[pos].setImageResource(img);

        }
    };


    public class MyThread extends Thread {

        // 이미지에 접근하기 위해 배열 인덱스를 정한다
        int pos; // position

        public MyThread(int pos) {
            this.pos = pos;
        }

        @Override
        public void run() {

            while (isPlaying){
                // 랜덤 시간초 생성
                int offTime = new Random().nextInt(5000);
                int onTime = new Random().nextInt(3000);


                try {
                    Thread.sleep(offTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message message = new Message();
                message.arg1 = pos;
                message.arg2 = R.drawable.on;
                message.obj = "on";
                handler.sendMessage(message);

                try {
                    Thread.sleep(onTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                message = new Message(); // 왜 다른 객체를 만들어야 하지? 그냥 있는거 쓰면 안되나?
                message.arg1 = pos;
                message.arg2 = R.drawable.off;
                message.obj = "off";
                handler.sendMessage(message);


            }



        }
    }

}