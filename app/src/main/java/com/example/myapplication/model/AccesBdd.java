package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.entite.Etudiant;

import java.util.ArrayList;
import java.util.List;

public class AccesBdd {
    private static String TAG = "AccesBd";
    private DatabaseOpenHelper mDbHelper;
    private Context context;

    public AccesBdd(Context context) {
        Log.i(TAG,"AccesBd");
        mDbHelper = new DatabaseOpenHelper(context);
        this.context = context;
    }
    public void insert(Etudiant nouveletudiant){
        
        SQLiteDatabase dataBase = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", nouveletudiant.getNom());
        values.put("prenom", nouveletudiant.getPrenom());
        values.put("age", nouveletudiant.getAge());
        values.put("mail", nouveletudiant.getMail());
        values.put("telephone", nouveletudiant.getTelephone());
        values.put("formation", nouveletudiant.getFormation());
        values.put("adresse", nouveletudiant.getAdresse());
        values.put("genre", nouveletudiant.getGenre());
        values.put("id", nouveletudiant.getId());
        dataBase.insert("etudiant", null, values);
        dataBase.close();
    }

    public void update(Etudiant existingEtudiant){
        SQLiteDatabase dataBase = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom", existingEtudiant.getNom());
        values.put("prenom", existingEtudiant.getPrenom());
        values.put("age", existingEtudiant.getAge());
        values.put("mail", existingEtudiant.getMail());
        values.put("telephone", existingEtudiant.getTelephone());
        values.put("formation", existingEtudiant.getFormation());
        values.put("adresse", existingEtudiant.getAdresse());
        values.put("genre", existingEtudiant.getGenre());
        dataBase.update("etudiant", values,String.format("%s = ?", "primary_column"),
                new String[]{existingEtudiant.getId().toString()});
        dataBase.close();
    }

    public List<Etudiant> getEtudiants() {
        Etudiant profil = null;
        List<Etudiant> profilList = null;
        SQLiteDatabase dataBase = mDbHelper.getReadableDatabase();
        String req = "select * from etudiant";
        Cursor cursor = dataBase.rawQuery(req, null);
        if (cursor.getCount() > 0) {
            profilList = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    try {
                        Integer id = cursor.getInt(0);
                        String nom = cursor.getString(1);
                        String prenom = cursor.getString(2);
                        Integer age = cursor.getInt(3);
                        String mail = cursor.getString(4);
                        String telephone = cursor.getString(5);
                        String adresse = cursor.getString(6);
                        String genre = cursor.getString(7);
                        String formation = cursor.getString(8);
                        Etudiant nouveletudiant = new Etudiant(nom, prenom,age, mail, telephone, formation,adresse,genre,id);
                        profilList.add(nouveletudiant);
                    } catch (SQLException e) {
                        Toast.makeText(this.context, "Impossible de lire les profils en bdd",
                                Toast.LENGTH_LONG).show();

                    }
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        Log.i(TAG, "profilList=" + profilList);
        return profilList;
    }
}
