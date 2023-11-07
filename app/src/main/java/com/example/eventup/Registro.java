package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eventup.dbHelper.DatabaseAux;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void changeToMain(View view) {
        Intent nIntent = new Intent(Registro.this, MainActivity.class);
        startActivity(nIntent);
    }

    public void InsertValues(View v){
        TextView nameTextView = findViewById(R.id.editTextUserName);
        TextView emailTextView = findViewById(R.id.editTextEmail);
        TextView passwordTextView = findViewById(R.id.editTextPassword);

        String nameString = nameTextView.getText().toString();
        String emailString = emailTextView.getText().toString();
        String passwordString = passwordTextView.getText().toString();

        DatabaseAux aux = new DatabaseAux(Registro.this);
        SQLiteDatabase db = aux.getWritableDatabase();

        if(db != null && !nameString.isEmpty() && !emailString.isEmpty() && !passwordString.isEmpty()) {
            ContentValues values = new ContentValues();
            values.put("name", nameString);
            values.put("email", emailString);
            values.put("password",passwordString);

            long res = db.insert("users", null, values);
            if(res >= 0) {
                Toast.makeText(this, "Insertado correctamente", Toast.LENGTH_LONG).show();
                nameTextView.setText("");
                emailTextView.setText("");
                passwordTextView.setText("");
            }
            else {
                Toast.makeText(this, "Fallo al insertar", Toast.LENGTH_LONG).show();
            }
            db.close();
        }

    }
}