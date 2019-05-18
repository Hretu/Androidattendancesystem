package com.androidattendancesystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FacultySignin extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_signin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });
    }

    private  void checkUser(){

        SharedPreferences sharedPreferences = getSharedPreferences("Users", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("etUsername","");
        String password = sharedPreferences.getString("etPassword","");

        if (username.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString())){
            Toast.makeText(FacultySignin.this,"Login Success",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(FacultySignin.this, AppBaseActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(FacultySignin.this,"Username or Password incorrect",Toast.LENGTH_LONG).show();
        }
    }
}
