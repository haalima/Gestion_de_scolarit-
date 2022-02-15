package com.example.projet_zili;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Planning extends AppCompatActivity {

    Spinner mfiliere,mniveau;
    int currentItem=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);


        mfiliere=findViewById(R.id.filiere);
        mniveau=findViewById(R.id.niveau);

        final String[] fil={"choisir filiere","MBD","SIM","LSI"};
        final String[] niv2={"choisir niveau...","1ère année","2ème année"};
        final String[] niv3={"choisir niveau...","1ère année","2ème année","3ème année"};

        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,fil);
        final ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,niv2);
        final ArrayAdapter<String> adapter3=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,niv3);

        mfiliere.setAdapter(adapter1);
        mfiliere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1 ){
                    mniveau.setAdapter(adapter2);
                    mniveau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(currentItem==position){
                                return;
                            }else{

                                Intent intent =new Intent(Planning.this,planningmbd1.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });


                                    }else{
                    if (position==2)
                    mniveau.setAdapter(adapter2);
                    mniveau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(currentItem==position){
                                return;
                            }else{


                                Intent intent =new Intent(Planning.this,planningsim1.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                    if (position==3){

                        mniveau.setAdapter(adapter3);
                        mniveau.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if(currentItem==position){
                                    return;
                                }else{

                                    Intent intent =new Intent(Planning.this,planninglsi1.class);
                                    startActivity(intent);
                                }

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });

                    }


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}