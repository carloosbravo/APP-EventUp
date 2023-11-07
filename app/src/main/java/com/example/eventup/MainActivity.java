package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToRegistro(View view){
        Intent nIntent = new Intent(MainActivity.this, Registro.class);
        startActivity(nIntent);

    }

    public void changeToLogin(View view){
        Intent nIntent = new Intent(MainActivity.this,Login.class);
        startActivity(nIntent);

    }

    public void changeToMostrarUsers(View view){
        Intent nIntent = new Intent(MainActivity.this, MostrarUsuarios.class);
        startActivity(nIntent);

    }

}