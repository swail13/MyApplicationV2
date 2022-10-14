package com.example.myapplication;

import static com.example.myapplication.entite.Etudiant.etudiants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.entite.Etudiant;

public class StudentActivity extends AppCompatActivity {

    public void openCreateFormulaire(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openEditFormulaire(int id){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
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

            case R.id.formulaire:
                openCreateFormulaire();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        l = findViewById(R.id.list);
        ArrayAdapter<Etudiant> arr;
        arr
                = new ArrayAdapter<Etudiant>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                etudiants);
        l.setAdapter(arr);
        l.setClickable(true);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Etudiant o = (Etudiant)l.getItemAtPosition(position);
                openEditFormulaire(o.getId());
            }
        });
    }



}