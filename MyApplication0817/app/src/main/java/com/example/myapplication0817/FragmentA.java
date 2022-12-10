package com.example.myapplication0817;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_a, container, false);

        EditText edt_name = view.findViewById(R.id.edt_name);
        Button btn_send = view.findViewById(R.id.btn_send);
        TextView tv_result = view.findViewById(R.id.tv_result);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                tv_result.setText(MainActivity.testString);
            }
        });


        return view;


    }
}
