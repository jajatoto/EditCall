package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    Button btnWeb;
    Button btnCall;
    EditText edtTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTel = findViewById(R.id.edtTel);
        btnGo = findViewById(R.id.btnGo);
        btnWeb = findViewById(R.id.btnWeb);
        btnCall = findViewById(R.id.btnCall);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //컴포넌트간 정보 전달을 목적으로 하는 클래스 : Intent
                //명시적 인텐트
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

                finish(); //액티비티 종
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri url = Uri.parse("http://www.gtec.ac.kr");
                //인텐트 액션, 액션과 동작할 값
                //묵시적 인텐트
                Intent i = new Intent(Intent.ACTION_VIEW, url);

                startActivity(i);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:" + edtTel.getText().toString());
                Intent i = new Intent(Intent.ACTION_CALL, uri);

                startActivity(i);
            }
        });
    }
}