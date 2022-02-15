package com.example.projet_zili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    ImageView inscri;
    ImageView exam;
    ImageView plan;
    ImageView bull;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        inscri = (ImageView) findViewById(R.id.ins);
        exam = (ImageView) findViewById(R.id.exm);
        plan = (ImageView) findViewById(R.id.pl);
        bull = (ImageView) findViewById(R.id.bl);


        inscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InscriptionActivity.class);
                startActivity(intent);
            }
        });

        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Examin.class);
                startActivity(intent);
            }
        });
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Planning.class);
                startActivity(intent);
            }
        });

        bull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bulletin.class);
                startActivity(intent);
            }
        });
    }
}