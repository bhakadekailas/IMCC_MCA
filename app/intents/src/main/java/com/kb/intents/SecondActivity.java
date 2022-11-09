package com.kb.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        context = SecondActivity.this;
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(context, FirstActivity.class);
            startActivity(intent);
//                finish();
        });


        /**
         *  Get Intent value from Intent
         */
        Intent intent = getIntent();
        String myName = intent.getStringExtra("MyName");
//        Log.e("SecondActivity", "onCreate: " + myName);
        Toast.makeText(this, myName, Toast.LENGTH_SHORT).show();


        /**
         *  Get Intent value from bundle
         */
//        Bundle bundle = getIntent().getExtras();
//        String myBundleName = bundle.getString("Name");
//        Log.e("SecondActivity", "onCreate: " + myBundleName);
//        Toast.makeText(this, myBundleName, Toast.LENGTH_SHORT).show();
    }
}