package com.kevin.coursjavaandroid.model.bean;

public class CityBean {

    public CityBean(String ville, int cp) {
        this.ville = ville;
        this.cp = cp;
    }

    private String ville;
    private int cp;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }
}

