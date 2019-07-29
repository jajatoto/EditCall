package com.example.tutorial01;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnection {

    private OkHttpClient client;
    private static HttpConnection instance = new HttpConnection();

    public static HttpConnection getInstance() {
        return instance;
    }  // 위 세줄 알아오기

    private HttpConnection() {
        this.client = new OkHttpClient();
    }


    /**
     * 웹 서버로 요청을 한다.
     */
   /* public void requestWebServer(String parameter, String parameter2, Callback callback) {
        RequestBody body = new FormBody.Builder()
                .add("parameter", parameter)
                .add("parameter2", parameter2)
                .build();
        Request request = new Request.Builder()
                .url("http://mydomain.com/sendData")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }*/

    public void requestServer(Callback callback) {
        RequestBody body = new FormBody.Builder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.androidhive.info/contacts/")
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}