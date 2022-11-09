package com.kb.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        context = FirstActivity.this;
        Button buttonMain = (Button) findViewById(R.id.button1);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                startActivity(intent);
////                finish();


                /*
                 * Pass data using simple intent (Not Bundle) from one activity to another activity
                 */
//            Intent intent = new Intent(context, SecondActivity.class);
//            intent.putExtra("MyName", "Kailas Bhakade");
//            startActivity(intent);

                /*
                 * Pass data using bundle from one activity to another activity
                 */
//            Intent intent = new Intent(context, SecondActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("Name", "Kailas Bhakade");
//            intent.putExtras(bundle);
//            startActivity(intent);

            }
        });
    }
}