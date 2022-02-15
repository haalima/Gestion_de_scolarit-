package com.example.projet_zili;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Saisienotes extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ed1 = (EditText) findViewById(R.id.snote1);
        ed2 = (EditText) findViewById(R.id.sprojet);
        ed3 = (EditText) findViewById(R.id.stravauxp);
        ed4 = (EditText) findViewById(R.id.stotal);
        ed5 = (EditText) findViewById(R.id.smoyenne);
        ed6 = (EditText) findViewById(R.id.sresultat);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markscal();

            }
        });

    }

    public void markscal(){
        int m1, m2,m3,tot;
        double avg;
        String resultat;

        m1 = Integer.parseInt(ed1.getText().toString());
        m2 = Integer.parseInt(ed2.getText().toString());
        m3 = Integer.parseInt(ed3.getText().toString());

        tot = m1 + m2 + m3;

        ed4.setText(String.valueOf(tot));

        avg = tot/3;

        ed5.setText(String.valueOf(avg));

        if (avg > 16)
        {
            ed6.setText("Très Bien");
        }
        else if (avg >13){
            ed6.setText("Bien");
        }
        else if (avg >12){
            ed6.setText("Assez_Bien");
        }
        else if (avg >9){
            ed6.setText("passable");
        }
        else{
            ed6.setText("Rattrapage");
        }



    }


    public void clear(){
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed4.setText("");
        ed5.setText("");
        ed6.setText("");
        ed1.requestFocus();
    }





}
