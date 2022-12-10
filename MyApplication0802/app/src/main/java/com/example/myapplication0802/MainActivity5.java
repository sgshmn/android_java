package com.example.myapplication0802;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_score;
    private ImageView img_dice1, img_dice2;
    private Button btn_shake;
    private int[] imgs = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    private Random rd = new Random();
    private int score1 = 0;
    private int score2 = 0;
    private boolean isFin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tv_score = findViewById(R.id.tv_score);
        img_dice1 = findViewById(R.id.img_dice1);
        img_dice2 = findViewById(R.id.img_dice2);
        btn_shake = findViewById(R.id.btn_shake);

        btn_shake.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (isFin) {
            btn_shake.setText("SHAKE");
            isFin = false;
            img_dice1.setImageResource(imgs[0]);
            img_dice2.setImageResource(imgs[0]);
            tv_score.setText(score1 + " : " + score2);

        } else {
            int diceNum1 = rd.nextInt(6);
            int diceNum2 = rd.nextInt(6);

            img_dice1.setImageResource(imgs[diceNum1]);
            img_dice2.setImageResource(imgs[diceNum2]);

            if (diceNum1 > diceNum2) {
                score1++;
            } else if (diceNum1 < diceNum2) {
                score2++;
            }

            String massage = "";
            if (score1 == 5) {
                massage = "USER! 승리!";
            } else if (score2 == 5) {
                massage = "USER2 승리!";
            }
            Toast.makeText(getApplicationContext(), massage, Toast.LENGTH_SHORT).show();

            tv_score.setText(score1 + " : " + score2);

            if (score1 == 5 || score2 == 5) {
                btn_shake.setText("처음부터");
                isFin = true;
                score1 = 0;
                score2 = 0;
            }
        }

    }

}