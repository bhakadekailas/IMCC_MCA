package com.kb.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class IntentFilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter);

        if (getIntent().getData()!=null && getIntent().getAction().equals(Intent.ACTION_VIEW)){
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageURI(getIntent().getData());
        }
    }
}