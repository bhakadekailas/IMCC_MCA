package com.kb.webservicesdemo.okhhtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.kb.webservicesdemo.R;
import java.io.IOException;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;

public class OkHttpDemoActivity extends AppCompatActivity {
    private EditText nameEdt, jobEdt;
    private TextView responseTV;
    private ProgressBar loadingPB;
    public String url = "https://reqres.in/api/users/2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_demo);
        nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        Button btnGetData = findViewById(R.id.btnGetData);
        Button postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);


        btnGetData.setOnClickListener(v -> {
            fetchDataUsingGetRequest();
        });

        postDataBtn.setOnClickListener(v -> {
            fetchDataUsingPostRequest();
        });
    }

    private void fetchDataUsingPostRequest() {
        if (nameEdt.getText().toString().isEmpty() && jobEdt.getText().toString().isEmpty()) {
            Toast.makeText(OkHttpDemoActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
            return;
        }
        postData(nameEdt.getText().toString(), jobEdt.getText().toString());
    }

    private void fetchDataUsingGetRequest() {
        //get request using async task (Synchronous)
//        OkHttpHandler okHttpHandler = new OkHttpHandler();
//        okHttpHandler.execute(url);

        //get request using asynchronous
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String myResponse = response.body().string();
                OkHttpDemoActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseTV.setText(myResponse);
                    }
                });
            }
        });
    }

    public class OkHttpHandler extends AsyncTask<String, String, String> {
        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... params) {
            Request.Builder builder = new Request.Builder();
            builder.url(params[0]);
            Request request = builder.build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            responseTV.setText(s);
        }
    }

    private void postData(String name, String job) {
        loadingPB.setVisibility(View.VISIBLE);
        String postUrl = "https://reqres.in/api/users/";

        String postBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        try {
            postRequest(postUrl, postBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void postRequest(String postUrl, String postBody) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), postBody);

        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                OkHttpDemoActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingPB.setVisibility(View.GONE);
                        try {
                            responseTV.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}