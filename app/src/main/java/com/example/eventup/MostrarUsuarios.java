package com.example.eventup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eventup.dbHelper.DatabaseAux;

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

    void showUsers(){
        SQLiteDatabase db = new DatabaseAux(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM users",null);
        LinearLayout layout = findViewById(R.id.fillContentShow);

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);

                TextView data = new TextView(this) ;

                data.setText("Nombre: " + name + " Email: " + email);
                layout.addView(data);


            }while(cursor.moveToNext());
        }

    }
}