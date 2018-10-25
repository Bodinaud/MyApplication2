package com.kevin.coursjavaandroid.model.bean;

import java.util.ArrayList;

public class ResultsBean {

private int nbr;

private String errorrs;

private ArrayList<CityBean> cityBeans;

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public String getErrorrs() {
        return errorrs;
    }

    public void setErrorrs(String errorrs) {
        this.errorrs = errorrs;
    }

    public ArrayList<CityBean> getCityBeans() {
        return cityBeans;
    }

    public void setCityBeans(ArrayList<CityBean> cityBeans) {
        this.cityBeans = cityBeans;
    }

    public ResultsBean(int nbr, String errorrs, ArrayList<CityBean> cityBeans) {
        this.nbr = nbr;
        this.errorrs = errorrs;
        this.cityBeans = cityBeans;
    }
}
