package com.example.mymembersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Join extends AppCompatActivity {

    // Gradle Scripts > build.gradle(module) 에 implementation 'com.android.volley:volley:1.2.1'를 넣어줘야한다. 
    // android developers에는 implementation 'com.android.volley:volley:1.1.1'로 되어있으니 유의하자
//    RequestQueue 이제 이게 자동완성이 뜨고 알아서 import에 필요한 거를 넣어준다

    private EditText edt_join_id, edt_join_pw, edt_join_nick, edt_join_addr;
    private Button btn_join, btn_join_home;
    
    // 서버에 요청하는 객체
    private RequestQueue queue;
    // 요청할 때 요청사항을 담는 객체
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        edt_join_id = findViewById(R.id.edt_join_id);
        edt_join_pw = findViewById(R.id.edt_join_pw);
        edt_join_nick = findViewById(R.id.edt_join_nick);
        edt_join_addr = findViewById(R.id.edt_join_addr);

        btn_join = findViewById(R.id.btn_join);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });

        btn_join_home = findViewById(R.id.btn_join_home);
        btn_join_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void sendRequest() {
        // Volley Lib 새로운 요청객체 생성
        queue = Volley.newRequestQueue(this);
        // 서버에 요청할 주소
        String url = "http://192.168.21.62:5000/join";
        // 요청 문자열 저장
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() { // (통신방식, url, 응답 리스너(통신할 때 받은 응답이 담긴다))
            
            // 통신방식 GET, POST

            // GET방식 : url?key1=value1&key2=value2&...  query string 방식이라고도 함
            // 보안이 안 좋음, 전송량의 한계 (1024byte) 이미지나 영상은 보낼 수 없다. 공유할 수 있다

            // 웹에서는 데이터를 한 덩어리로 보내지 않고 쪼개서 보낸다. 그 쪼개는 것을 패킷이라고 한다
            // POST방식 : 패킷 바디 안에 데이터를 key=value 형태로 보낸다
            // 장접 : 보안이 좋다. 많은 양의 데이터를 보낼 수 있다. 공유할 수 없다


            // 응답데이터를 받아오는 곳
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
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

                String id = edt_join_id.getText().toString();
                String pw = edt_join_pw.getText().toString();
                String nick = edt_join_nick.getText().toString();
                String addr = edt_join_addr.getText().toString();

                params.put("id", id);
                params.put("pw",pw);
                params.put("nick", nick);
                params.put("addr", addr);

                return params;
            }
        };
        String TAG = "ooo";
        stringRequest.setTag(TAG); //
        queue.add(stringRequest);
    }
}