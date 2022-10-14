package com.example.myapplication.entite;

import java.util.ArrayList;

public class  Etudiant {
    public static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

    private String nom;
    private String prenom;
    private Integer age;
    private String telephone;
    private String mail;
    private String adresse;
    private String formation;
    private String genre;
    private Integer id;


    public Etudiant(String nom, String prenom, Integer age, String telephone, String mail, String adresse, String formation, String genre, Integer id) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAge(age);
        this.setTelephone(telephone);
        this.setMail(mail);
        this.setAdresse(adresse);
        this.setFormation(formation);
        this.setGenre(genre);
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}









