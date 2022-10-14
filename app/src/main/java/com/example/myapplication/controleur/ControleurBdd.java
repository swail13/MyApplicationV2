package com.example.myapplication.controleur;

import android.content.Context;

import com.example.myapplication.entite.Etudiant;
import com.example.myapplication.model.AccesBdd;

import java.util.ArrayList;
import java.util.List;

public final class ControleurBdd {
    public static ArrayList<Etudiant> etudiants = new ArrayList<>();

    private static String TAG = "ControleurBdd";
    private static ControleurBdd instance = null;
    private static AccesBdd accesBd;

    private ControleurBdd() {
        super();
    }

    public static final ControleurBdd getInstance(Context context) {
        if (ControleurBdd.instance == null) {
            ControleurBdd.instance = new ControleurBdd();
            accesBd = new AccesBdd(context);
        }
        return ControleurBdd.instance;
    }

    public void insert(Etudiant nouveletudiant) {

        accesBd.insert(nouveletudiant);
        // accesBd.getEtudiants();
    }

    public void update(Etudiant nouveletudiant) {

        accesBd.update(nouveletudiant);
        //accesBd.getEtudiants();
    }


    public List<Etudiant> getEudiants() {

       return accesBd.getEtudiants();
        // accesBd.getEtudiants();
    }

}
