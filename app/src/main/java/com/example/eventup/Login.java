package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eventup.dbHelper.DatabaseAux;

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

    public void verifyUser(){
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users",null);


    }
    public void checkUser(View v) {
        EditText nameEditText = findViewById(R.id.EditTextLoginNameUser);
        EditText passwordEditText = findViewById(R.id.editTextLoginPassword);

        String nameString = nameEditText.getText().toString();
        String passwordString = passwordEditText.getText().toString();

        DatabaseAux aux = new DatabaseAux(Login.this);
        SQLiteDatabase db = aux.getReadableDatabase();

        if (db != null) {
            String[] columns = {"name"};
            String selection = "name = ? AND password = ?";
            String[] selectionArgs = {nameString, passwordString};

            Cursor cursor = db.query("users", columns, selection, selectionArgs, null, null, null);

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    Toast.makeText(this, "Usuario encontrado en la base de datos", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Usuario no encontrado en la base de datos", Toast.LENGTH_LONG).show();
                }
                cursor.close();
            }
            db.close();
        }
    }
}