package com.example.projet_zili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExamLsi extends AppCompatActivity {


    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    int currentItem=0;

    FloatingActionButton back1_button;
    FloatingActionButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_lsi);


        spinner = (Spinner) findViewById(R.id.spinner1);
        adapter = ArrayAdapter.createFromResource(this, R.array.niv3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        back1_button = findViewById(R.id.back1_button);
        back_button = findViewById(R.id.back_button);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " Selected", Toast.LENGTH_LONG).show();

                if(currentItem==position){
                    return;
                }else{

                    Intent intent =new Intent(ExamLsi.this,Recuperetudiant.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        back1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamLsi.this, Examin.class);
                startActivity(intent);

            }
        });





    }
}