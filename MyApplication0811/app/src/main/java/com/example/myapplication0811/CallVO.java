package com.example.myapplication0811;

import android.graphics.drawable.Drawable;

public class CallVO {

    private Drawable call;
    private String name;
    private String time;
    private String number;

    public CallVO(Drawable call, String name, String time, String number) {
        this.call = call;
        this.name = name;
        this.time = time;
        this.number = number;
    }

    public Drawable getCall() {
        return call;
    }

    public void setCall(Drawable call) {
        this.call = call;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
