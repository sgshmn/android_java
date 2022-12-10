package com.example.myapplication0811;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CallAdapter adapter = new CallAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.phone), "강성관 선생님", "오후 1시50분","tel:01012546178");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.phone), "박병관 선생님", "오후 3시49분","tel:01012345678");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.phone), "박화연 팀장", "오후 3시 12분","tel:01042342343");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.phone), "이경령", "오후 10시 37분","tel:01054669546");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.phone), "누나", "오전 9시 48분","tel:01068234713");

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                adapterView.getItemAtPosition(i); ??
                CallVO vo = (CallVO) adapter.getItem(i);
                Uri uri = Uri.parse(vo.getNumber());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
    }
}