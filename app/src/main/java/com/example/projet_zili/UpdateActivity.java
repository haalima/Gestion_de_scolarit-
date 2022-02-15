package com.example.projet_zili;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateActivity extends AppCompatActivity {

    EditText cne;
    EditText nom;
    EditText prenom;
    Button update_button;
    Button delete_button;
    FloatingActionButton back_button2;

    String id_, cne_, nom_, prenom_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        cne = findViewById(R.id.cne_etu2);
        nom = findViewById(R.id.nom_etu2);
        prenom = findViewById(R.id.prenom_etu2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        back_button2 = findViewById(R.id.back_button2);

        //First we call this
        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if( ab != null){
            ab.setTitle(cne_);
        }


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //and only then we call this
                MyDatabaseHelper DB = new MyDatabaseHelper(UpdateActivity.this);
                cne_=cne.getText().toString().trim();
                nom_=nom.getText().toString().trim();
                prenom_=prenom.getText().toString().trim();
                DB.updatedata(id_, cne_, nom_, prenom_);

            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();


            }
        });

        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, InscriptionActivity.class);
                startActivity(intent);

            }
        });


    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("cne") &&
                getIntent().hasExtra("nom") && getIntent().hasExtra("prenom") ){
            //obtenir des données d'apres Intent
            id_ = getIntent().getStringExtra("id");
            cne_ = getIntent().getStringExtra("cne");
            nom_ = getIntent().getStringExtra("nom");
            prenom_ = getIntent().getStringExtra("prenom");

            //définition des données d'Intent
            cne.setText(cne_);
            nom.setText(nom_);
            prenom.setText(prenom_);



        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " +  cne_ + " ?");
        builder.setMessage(" Are you sure you want to delete " + cne_ + " ?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper DB = new MyDatabaseHelper(UpdateActivity.this);
                DB.deleteOneRow(id_);
                finish();//pour me rendre a inscriptionactivity directement

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }





}