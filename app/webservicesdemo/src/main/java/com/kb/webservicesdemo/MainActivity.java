package com.kb.webservicesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.kb.webservicesdemo.okhhtp.OkHttpDemoActivity;
import com.kb.webservicesdemo.retrofit.RetrofitDemoActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonRetrofit, buttonOkHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        buttonRetrofit = findViewById(R.id.buttonRetrofit);
        buttonOkHttp = findViewById(R.id.buttonOkHttp);

        buttonRetrofit.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RetrofitDemoActivity.class));
        });

        buttonOkHttp.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, OkHttpDemoActivity.class));
        });
    }
}