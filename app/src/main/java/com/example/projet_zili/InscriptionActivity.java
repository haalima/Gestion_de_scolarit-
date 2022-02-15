package com.example.projet_zili;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class InscriptionActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    FloatingActionButton back1_button;
    ImageView empty_imageview;
    TextView no_data;


    MyDatabaseHelper DB;
    ArrayList<String> etudiant_id, etudiant_cne, etudiant_nom, etudiant_prenom, etudiant_filiere;
    CAdapter cAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        recyclerView = findViewById(R.id.recyclerview);
        back1_button = findViewById(R.id.back1_button);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);

        back1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });




        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InscriptionActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });


        DB = new MyDatabaseHelper(InscriptionActivity.this);
        etudiant_id = new ArrayList<>();
        etudiant_cne = new ArrayList<>();
        etudiant_nom = new ArrayList<>();
        etudiant_prenom = new ArrayList<>();
        etudiant_filiere = new ArrayList<>();

        StoreDataInArrays();

        cAdapter = new CAdapter(InscriptionActivity.this,this, etudiant_id, etudiant_cne, etudiant_nom,etudiant_prenom, etudiant_filiere);
        recyclerView.setAdapter(cAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(InscriptionActivity.this));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void StoreDataInArrays(){
        Cursor cursor = DB.readAllData();
        if (cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
            //Toast.makeText(this,"No Data", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                etudiant_id.add(cursor.getString(0));
                etudiant_cne.add(cursor.getString(1));
                etudiant_nom.add(cursor.getString(2));
                etudiant_prenom.add(cursor.getString(3));
                etudiant_filiere.add(cursor.getString(4));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }




}