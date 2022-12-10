package com.example.myapplication0810;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KakaoAdapter extends BaseAdapter {

    // ListView에 보여줄 데이터
    private ArrayList<KakaoVO> items = new ArrayList<KakaoVO>();


    @Override
    public int getCount() {
        // 현재 가지고 있는 데이터의 개수
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        // 해당 위치의 데이터
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        // 해당 위치의 아이템의 아이디. 안쓴다.
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 제일 중요!?
        // ArrayList에서 데이터를 하나씩 꺼내서
        // 내가 만든 xml(layout)틀에 넣고 Listview에 하나씩 넣는다

        // kakao.xml을 읽기
        Context context = viewGroup.getContext();
        if (view == null) {
            // view와 context를 어떻게 연결할까
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.kakao, viewGroup, false); // inflater 부풀게 하다
        }

        KakaoVO vo = items.get(i);

        ImageView img_profile = view.findViewById(R.id.img_profile);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_msg = view.findViewById(R.id.tv_msg);

        img_profile.setImageDrawable(vo.getProfile());
        tv_name.setText(vo.getName());
        tv_msg.setText(vo.getMsg());
        
        return view;
    }


    // 외부에서 items에 데이터를 넣기위한 메소드
    public void addItem(Drawable profile, String name, String msg) {

        KakaoVO vo = new KakaoVO(profile, name, msg);
        items.add(vo);

    }


}
