package com.example.tutorial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Log.i("asdf", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();


        Log.i("asdf", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("asdf", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("asdf", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("asdf", "onDestroy");
    }
}
