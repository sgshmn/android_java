package com.example.myapplication0808;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_id, edt_pw, edt_nick, edt_phone;
    private Button btn_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_nick = findViewById(R.id.edt_nick);
        edt_phone = findViewById(R.id.edt_phone);

        btn_join = findViewById(R.id.btn_join);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();
                String nick = edt_nick.getText().toString();
                String phone = edt_phone.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                MemberVO vo = new MemberVO(id, pw, nick, phone);

                intent.putExtra("vo", vo);

                startActivity(intent);

            }
        });




    }
}