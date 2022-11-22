package com.kb.webservicesdemo.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kb.webservicesdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDemoActivity extends AppCompatActivity {
    private EditText nameEdt, jobEdt;
    private TextView responseTV;
    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo);
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
            Toast.makeText(RetrofitDemoActivity.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
            return;
        }
        postData(nameEdt.getText().toString(), jobEdt.getText().toString());
    }

    private void fetchDataUsingGetRequest() {
        loadingPB.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<RandomUserDataModel> call = retrofitAPI.getRandomUser();

        call.enqueue(new Callback<RandomUserDataModel>() {
            @Override
            public void onResponse(Call<RandomUserDataModel> call, Response<RandomUserDataModel> response) {
                Toast.makeText(RetrofitDemoActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
                RandomUserDataModel responseFromAPI = response.body();
                String responseString = responseFromAPI.toString();
                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<RandomUserDataModel> call, Throwable t) {
                responseTV.setText("Error found is : " + t.getMessage());
            }
        });
    }

    private void postData(String name, String job) {
        loadingPB.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        DataModal modal = new DataModal(name, job);

        Call<DataModal> call = retrofitAPI.createPost(modal);

        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                Toast.makeText(RetrofitDemoActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
                jobEdt.setText("");
                nameEdt.setText("");
                DataModal responseFromAPI = response.body();
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();
                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                responseTV.setText("Error found is : " + t.getMessage());
            }
        });
    }
}