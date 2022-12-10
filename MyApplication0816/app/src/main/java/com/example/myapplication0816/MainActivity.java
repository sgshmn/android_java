package com.example.myapplication0816;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_up;
    private TextView tv_timer, tv_cnt;
    private int cnt = 0;
    private int time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_up = findViewById(R.id.btn_up);

        tv_timer = findViewById(R.id.tv_timer);
        tv_cnt = findViewById(R.id.tv_cnt);

        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                tv_cnt.setText(cnt + "");
            }
        });

        MytimerThread Thread = new MytimerThread();
        Thread.start();



    }
    
    // Handler : 외부 Thread에서 UI/UX를 수정하려면 Handler를 통해 변경해야 한다. 원래는 main Thread 만 할수 있다
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 외부 Thread에서 요청하면 handleMessage 메소드를 실행한다
            // 외부 Thread에서 데이터를 보낼 때 msg에 담아 보낸다
            int time = msg.arg1;
            tv_timer.setText(time + "");

            if (time == 30) {
                btn_up.setClickable(false);
            }

        }
    };
    
    // Thread사용하는 방법 2가지
    // Thread class를 상속 받아서 사용
    // Runnable interface를 구현해서 사용
    public class MytimerThread extends Thread {
        @Override
        public void run() {
            while (time < 30) {
                time++;

                Message message = new Message();
                message.arg1 = time;

//                tv_timer.setText(time + ""); // 외부 Thread에서는 이것을 할 수 없다

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendMessage(message);

//                if (time == 30) {
//                    btn_up.setClickable(false); 될수도 있고 안 될 수도 있기 때문에 이왕이면 handler에서 해라
//                    break;
//                }
            }
        }
    }




}