package com.kevin.coursjavaandroid.model.bean;

import com.google.android.gms.maps.model.LatLng;

public class ToulouseBean {

    private LatLng position;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        position = position;
    }

        public ToulouseBean(String nom, LatLng position) {
            this.nom = nom;
            this.position = position;
        }

    }
