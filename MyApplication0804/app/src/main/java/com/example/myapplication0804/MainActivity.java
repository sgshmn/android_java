package com.example.myapplication0804;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt_input;
    private Button btn_input;
    private TextView tv_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input = findViewById(R.id.edt_input);
        btn_input = findViewById(R.id.btn_input);
        tv_input = findViewById(R.id.tv_input);

        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_input.getText().toString();
                tv_input.setText(name);
            }
        });


    }
}