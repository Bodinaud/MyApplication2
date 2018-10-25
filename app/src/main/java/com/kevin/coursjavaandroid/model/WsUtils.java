package com.kevin.coursjavaandroid.model;

import android.os.SystemClock;

import com.kevin.coursjavaandroid.model.bean.EleveBean;

public class WsUtils {
    public static EleveBean loadEleveFromWeb(){
        SystemClock.sleep(5000); //Attente de 5 secondes
        return new EleveBean("Toto", "Tata");
    }
}
