package com.kb.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initViews();
        setListener();
    }

    private void setListener() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
            }
        });
    }

    private void saveUser() {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        UserDataModel userDataModel = new UserDataModel();
        userDataModel.setFirstName(firstName);
        userDataModel.setLastName(lastName);
        userDataModel.setEmail(email);
        userDataModel.setPassword(password);

        Toast.makeText(SignupActivity.this, userDataModel.toString(), Toast.LENGTH_SHORT).show();
        Log.d("KAILAS", "saveUser: "+ userDataModel);

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        myDatabaseHelper.saveUser(userDataModel);
        finish();

    }

    private void initViews() {
        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);
    }
}