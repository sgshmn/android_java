package com.example.myapplication0810;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class KakaoVO {

    private Drawable profile;
    private String name;
    private String msg;

    public KakaoVO(Drawable profile, String name, String msg) {
        this.profile = profile;
        this.name = name;
        this.msg = msg;
    }

    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
