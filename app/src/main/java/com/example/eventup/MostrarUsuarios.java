package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MostrarUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);
    }

    public void changeToMain(View view) {
        Intent nIntent = new Intent(MostrarUsuarios.this, MainActivity.class);
        startActivity(nIntent);
    }
}