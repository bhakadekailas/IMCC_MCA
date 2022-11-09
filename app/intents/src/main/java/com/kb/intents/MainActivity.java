package com.kb.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callExplicitIntent(View view) {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void callImplicitIntent(View view) {
        Intent intent = new Intent(this, ImplicitIntentActivity.class);
        startActivity(intent);
    }

    public void callIntentFilter(View view) {
        Intent intent = new Intent(this, IntentFilterActivity.class);
        startActivity(intent);
    }
}