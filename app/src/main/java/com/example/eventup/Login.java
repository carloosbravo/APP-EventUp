package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void changeToMain(View view){
        Intent nIntent = new Intent(Login.this,MainActivity.class);
        startActivity(nIntent);

    }
}