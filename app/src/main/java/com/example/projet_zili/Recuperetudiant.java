package com.example.projet_zili;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Recuperetudiant extends AppCompatActivity {

    MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupereliste);
        PreCreateDB.copyDB(this);
        DB = new MyDatabaseHelper(this);
        ListView lvetudiant = findViewById(R.id.lvetudiant);
        final SimpleCursorAdapter simpleCursorAdapter = DB.populateListViewFromDB();
        lvetudiant.setAdapter(simpleCursorAdapter);
        lvetudiant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) simpleCursorAdapter.getItem(position);
                String name = cursor.getString(1);
                //Toast.makeText(Recuperetudiant.this, name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Recuperetudiant.this, Saisienotes.class);
                startActivity(intent);
            }
        });
    }
}