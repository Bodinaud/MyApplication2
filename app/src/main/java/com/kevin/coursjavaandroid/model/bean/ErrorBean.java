package com.kevin.coursjavaandroid.model.bean;

public class ErrorBean {

    private String meassage, code;

    public ErrorBean(String meassage, String code) {
        this.meassage = meassage;
        this.code = code;
    }

    public String getMeassage() {
        return meassage;
    }

    public void setMeassage(String meassage) {
        this.meassage = meassage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
