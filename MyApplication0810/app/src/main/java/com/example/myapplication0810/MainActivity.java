package com.example.myapplication0810;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    //  ListView에 적용하는 Adapter에 들어갈 Data를 준비하자!!!!
    private ArrayList<String> names = new ArrayList<String>();
    // ListView에 적용할 Adapter
    private ArrayAdapter<String> adapter; // 여기서 객체 생성을 할 수 없다. onCreate이후에 객체를 생성할 수 있다

    private EditText edt_name;
    private Button btn_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name = findViewById(R.id.edt_name);
        btn_name = findViewById(R.id.btn_name);

        listView = findViewById(R.id.listView);
        names.add("김민재");
        names.add("손흥민");
        names.add("강성관");
        names.add("박승현");
        names.add("박병관");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        // ArrayAdapter의 생성자에는 3가지가 들어가야 한다, 클래스정보, 래이아웃, 데이터. ArrayAdapter의 데이터 자리에는 ArrayList<String>만 들어갈수 있다
        listView.setAdapter(adapter);

        // names.add("우영우");
        // 아래 코드까지 써야 바뀐 데이터가 adapter에 적용되는데 최근 버전에서는 아래 코드를 안써도 적용이 되긴 한다
        // adapter.notifyDataSetChanged();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                   // 여기에 적용한 adapter, 클릭한놈, 클릭한 위치, ?
                // 문제
                // 이름을 눌렀을 때 Toast로 그 이름을 띄우기

                Toast.makeText(getApplicationContext(), names.get(i), Toast.LENGTH_SHORT).show();


            }
        });

        btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.add(edt_name.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                names.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });





    }
}