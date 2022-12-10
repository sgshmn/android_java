package com.example.mymembersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class List extends AppCompatActivity {

    private RequestQueue queue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        sendRequest();

    }

    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://192.168.21.62:5000/list";
        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() { // (통신방식, url, 응답 리스너(통신할 때 받은 응답이 담긴다))

            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
                String[] member = response.split("/");

                String[][] list = new String[member.length][4]; // 왜 4 가 들어가 있는 곳을 비워도 될까?
                for (int i = 0; i < list.length; i++) {
                    String[] values = member[i].split(",");
                    list[i][0] = values[0];
                    list[i][1] = values[1];
                    list[i][2] = values[2];
                    list[i][3] = values[3];
                }

                for (int i = 0; i < list.length; i++) {
                    for (int j = 0; j < list[i].length; j++) {
                        Log.v("resultValue",list[i][j]);
                    }
                }


            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override //response를 UTF8로 변경해주는 소스코드
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }
            // 보낼 데이터를 저장하는 곳
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>(); // 인덱스 대신 key를 통해 value를 찾는 자료형
                return params;
            }
        };
        String TAG = "ooo";
        stringRequest.setTag(TAG); //
        queue.add(stringRequest);
    }
}