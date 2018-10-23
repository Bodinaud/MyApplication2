package com.kevin.coursjavaandroid.model.bean;

public class EleveBean {

    private String nom, prenom;

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

    public EleveBean() {
    }

    public EleveBean(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}