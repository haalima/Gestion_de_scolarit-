package com.example.projet_zili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Examin extends AppCompatActivity {

    TextView mbd;
    TextView sim;
    TextView lsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examin);

        mbd=(TextView) findViewById(R.id.mb);
        sim=(TextView) findViewById(R.id.si);
        lsi=(TextView) findViewById(R.id.ls);

        mbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExamMbd.class);
                startActivity(intent);
            }
        });
        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExamSim.class);
                startActivity(intent);
            }
        });
        lsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExamLsi.class);
                startActivity(intent);
            }
        });
    }
}