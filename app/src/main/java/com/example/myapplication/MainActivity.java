package com.example.myapplication;

import static com.example.myapplication.entite.Etudiant.etudiants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.controleur.ControleurBdd;
import com.example.myapplication.entite.Etudiant;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button button1;

    public void openStudentActivity(){
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.liste:
                openStudentActivity();
                return true;
                default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        if (b!= null) {
            int id = b.getInt("id");
            if (id != 0) {
                ShowEtudiant(id);
            }
        }



        final Button button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                // Code here executes on main thread after user presses button

                EditText nomEditText = (EditText) findViewById(R.id.nom);
                String nom = nomEditText.getText().toString();

                EditText prenomEditText = (EditText) findViewById(R.id.prenom);
                String prenom = prenomEditText.getText().toString();

                EditText ageEditText = (EditText) findViewById(R.id.age);
                Integer age = Integer.parseInt(ageEditText.getText().toString());

                EditText phoneEditText = (EditText) findViewById(R.id.telephone);
                String telephone = phoneEditText.getText().toString();

                EditText mailEditText = (EditText) findViewById(R.id.mail);
                String mail = mailEditText.getText().toString();

                EditText adresseEditText = (EditText) findViewById(R.id.adresse);
                String adresse = adresseEditText.getText().toString();

                EditText formationEditText = (EditText) findViewById(R.id.formation);
                String formation = formationEditText.getText().toString();

                EditText genreEditText = (EditText) findViewById(R.id.genre);
                String genre = genreEditText.getText().toString();

                EditText idEditText = (EditText) findViewById(R.id.Id);
                if (idEditText.getText().toString().isEmpty()) {
                    int id = getMaxId() + 1 ;
                    Etudiant etudiant = new Etudiant(nom,prenom,age,telephone,mail,adresse,formation,genre,id);
                    createEtudiant(etudiant);
                }else
                {
                    Integer id = Integer.parseInt(idEditText.getText().toString());
                    Etudiant existingEtudiant = new Etudiant(nom,prenom,age,telephone,mail,adresse,formation,genre,id);
                    updateEtudiant(existingEtudiant);
                }


                resetForm();
            }

        });
        ControleurBdd cbd = ControleurBdd.getInstance(this);
        List<Etudiant> list = cbd.getEudiants();
        if (list != null) {
            etudiants = new ArrayList<Etudiant>(list);
        }



    }

    public void ShowEtudiant(int id) {
        for (Etudiant e:etudiants
        ) {
            if (e.getId() == id) {
                EditText nomEditText = (EditText) findViewById(R.id.nom);
                nomEditText.setText(e.getNom());

                EditText prenomEditText = (EditText) findViewById(R.id.prenom);
                prenomEditText.setText(e.getPrenom());

                EditText ageEditText = (EditText) findViewById(R.id.age);
                ageEditText.setText(e.getAge().toString());

                EditText mailEditText = (EditText) findViewById(R.id.mail);
                mailEditText.setText(e.getMail());

                EditText formationEditText = (EditText) findViewById(R.id.formation);
                formationEditText.setText(e.getFormation());

                EditText genreEditText = (EditText) findViewById(R.id.genre);
                genreEditText.setText(e.getGenre());

                EditText adresseEditText = (EditText) findViewById(R.id.adresse);
                adresseEditText.setText(e.getAdresse());

                EditText phoneEditText = (EditText) findViewById(R.id.telephone);
                phoneEditText.setText(e.getTelephone());

                EditText idEditText = (EditText) findViewById(R.id.Id);
                idEditText.setText(e.getId().toString());


            }
                return;
            }
    }
    public  int getMaxId() {
        int max = 0;
        for (Etudiant etudiant:etudiants
             ) {
          if (etudiant.getId() > max) {
              max = etudiant.getId();
          }
        }
        return max;
    }
    public void updateEtudiant(Etudiant etudiant) {
        for (Etudiant e:etudiants
        ) {
            if (e.getId() == etudiant.getId()) {
                e.setAge(etudiant.getAge());
                e.setAdresse(etudiant.getAdresse());
                e.setNom(etudiant.getNom());
                e.setPrenom(etudiant.getPrenom());
                e.setMail(etudiant.getMail());
                e.setFormation(etudiant.getFormation());
                e.setGenre(etudiant.getGenre());
                e.setTelephone(etudiant.getTelephone());
                ControleurBdd.getInstance(this).update(etudiant);

            }
        }
    }
    public void createEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        ControleurBdd.getInstance(this).insert(etudiant);
    }

    public void resetForm() {
        EditText nomEditText = (EditText) findViewById(R.id.nom);
        nomEditText.setText("");

        EditText prenomEditText = (EditText) findViewById(R.id.prenom);
        prenomEditText.setText("");

        EditText ageEditText = (EditText) findViewById(R.id.age);
        ageEditText.setText("");

        EditText mailEditText = (EditText) findViewById(R.id.mail);
        mailEditText.setText("");

        EditText formationEditText = (EditText) findViewById(R.id.formation);
        formationEditText.setText("");

        EditText genreEditText = (EditText) findViewById(R.id.genre);
        genreEditText.setText("");

        EditText adresseEditText = (EditText) findViewById(R.id.adresse);
        adresseEditText.setText("");

        EditText phoneEditText = (EditText) findViewById(R.id.telephone);
        phoneEditText.setText("");

        EditText idEditText = (EditText) findViewById(R.id.Id);
        idEditText.setText("");


    }
}






