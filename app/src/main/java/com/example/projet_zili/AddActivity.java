package com.example.projet_zili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddActivity extends AppCompatActivity {

    EditText cne;
    EditText nom;
    EditText prenom;
    EditText idfilieres;
    Button add_button;
    FloatingActionButton back_button;
    //DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        cne = (EditText) findViewById(R.id.cne_etu);
        nom = (EditText) findViewById(R.id.nom_etu);
        prenom = (EditText) findViewById(R.id.prenom_etu);
        idfilieres = (EditText) findViewById(R.id.idfilieres);
        add_button = (Button) findViewById(R.id.add_button);
        back_button = findViewById(R.id.back_button);


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DB = new DBHelper(AddActivity.this);
                MyDatabaseHelper DB = new MyDatabaseHelper(AddActivity.this);
                DB.ajouteretudiant(cne.getText().toString().trim(),
                        nom.getText().toString().trim(),
                        prenom.getText().toString().trim(),
                        Integer.valueOf(idfilieres.getText().toString().trim()));
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, InscriptionActivity.class);
                startActivity(intent);

            }
        });




    }
}