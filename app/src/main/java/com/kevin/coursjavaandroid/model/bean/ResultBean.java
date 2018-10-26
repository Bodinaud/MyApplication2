package com.kevin.coursjavaandroid.model.bean;

import java.util.ArrayList;

public class ResultBean {

    private int nbr;

    public ResultBean() {
    }

    private ErrorBean errors;

    private ArrayList<CityBean> results;

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public ErrorBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorBean errors) {
        this.errors = errors;
    }

    public ArrayList<CityBean> getResults() {
        return results;
    }

    public void setResults(ArrayList<CityBean> results) {
        this.results = results;
    }
}
