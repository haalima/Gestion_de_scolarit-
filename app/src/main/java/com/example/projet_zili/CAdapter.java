package com.example.projet_zili;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CAdapter extends RecyclerView.Adapter<CAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList etudiant_id, etudiant_cne, etudiant_nom, etudiant_prenom, etudiant_filiere;

    Animation translate_anim;



    CAdapter(Activity activity,Context context, ArrayList etudiant_id, ArrayList etudiant_cne, ArrayList etudiant_nom,
             ArrayList etudiant_prenom, ArrayList etudiant_filiere){


        this.context = context;
        this.activity = activity;
        this.etudiant_id = etudiant_id;
        this.etudiant_cne = etudiant_cne;
        this.etudiant_nom = etudiant_nom;
        this.etudiant_prenom = etudiant_prenom;
        this.etudiant_filiere = etudiant_filiere;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.etudiant_id_txt.setText(String.valueOf(etudiant_id.get(position)));
        holder.etudiant_cne_txt.setText(String.valueOf(etudiant_cne.get(position)));
        holder.etudiant_nom_txt.setText(String.valueOf(etudiant_nom.get(position)));
        holder.etudiant_prenom_txt.setText(String.valueOf(etudiant_prenom.get(position)));
        holder.etudiant_filiere_txt.setText(String.valueOf(etudiant_filiere.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(etudiant_id.get(position)));
                intent.putExtra("cne", String.valueOf(etudiant_cne.get(position)));
                intent.putExtra("nom", String.valueOf(etudiant_nom.get(position)));
                intent.putExtra("prenom", String.valueOf(etudiant_prenom.get(position)));
                intent.putExtra("filiere", String.valueOf(etudiant_filiere.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return etudiant_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView etudiant_id_txt, etudiant_cne_txt, etudiant_nom_txt, etudiant_prenom_txt, etudiant_filiere_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            etudiant_id_txt = itemView.findViewById(R.id.etudiant_id_txt);
            etudiant_cne_txt = itemView.findViewById(R.id.etudiant_cne_txt);
            etudiant_nom_txt = itemView.findViewById(R.id.etudiant_nom_txt);
            etudiant_prenom_txt = itemView.findViewById(R.id.etudiant_prenom_txt);
            etudiant_filiere_txt = itemView.findViewById(R.id.etudiant_filiere_txt);
            mainLayout = itemView.findViewById(R.id.mainlayout);
            //Animation de recyclerview
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);


        }
    }
}
