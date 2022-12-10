package com.example.myapplication0811;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CallAdapter extends BaseAdapter { // ctrl 좌클릭하면 해당 클래스를 따라간다

    private ArrayList<CallVO> items = new ArrayList<CallVO>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Context context = viewGroup.getContext();
        
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // (LayoutInflater)이거는 다운캐스팅
            view = inflater.inflate(R.layout.call, viewGroup, false);
        }

        CallVO vo = items.get(i);
        // findViewbyId는 onCreate 안에서만 쓸 수 있다. 왜?

        ImageView img_call = view.findViewById(R.id.img_call);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_time = view.findViewById(R.id.tv_time);

        img_call.setImageDrawable(vo.getCall());
        tv_name.setText(vo.getName());
        tv_time.setText(vo.getTime());

        return view;
    }

    public void addItem(Drawable call, String name, String time, String number) {

        CallVO vo = new CallVO(call, name, time, number);
        items.add(vo);
    }
}
