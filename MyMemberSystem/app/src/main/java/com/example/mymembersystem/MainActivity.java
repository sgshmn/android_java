package com.example.mymembersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] btn_ids = {R.id.btn_loginGo, R.id.btn_joinGo, R.id.btn_listGo, R.id.btn_updateGo, R.id.btn_deleteGo};
    private int l = btn_ids.length;
    private Button[] btns = new Button[l];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < l; i++) {
            btns[i] = findViewById(btn_ids[i]);
            btns[i].setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View view) {

        int btnId = view.getId();
        Intent intent = null;

        if (btnId == btn_ids[0]) {
            intent = new Intent(this, Login.class);
        } else if (btnId == btn_ids[1]) {
            intent = new Intent(this, Join.class);
        } else if (btnId == btn_ids[2]) {
            intent = new Intent(this, List.class);
        } else if (btnId == btn_ids[4]) {
            intent = new Intent(this, Delete.class);
        }
        startActivity(intent);


    }
}