package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WebActivity extends AppCompatActivity {


    Button btnStart;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        btnStart = findViewById(R.id.btnStart);
        tvContent = findViewById(R.id.tvContent);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpConnection httpConnection = HttpConnection.getInstance();
                httpConnection.requestServer(callback);

            }
        });
    }

    Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final String body = response.body().string();

            //웹 통신 후에 결과값을 화면에 적용시키고 싶다면


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvContent.setText(body);
                }
            });
        }
    };
}
