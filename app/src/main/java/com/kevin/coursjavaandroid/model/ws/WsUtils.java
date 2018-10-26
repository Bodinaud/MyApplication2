package com.kevin.coursjavaandroid.model.ws;

import android.os.SystemClock;

import com.google.gson.Gson;
import com.kevin.coursjavaandroid.model.bean.CityBean;
import com.kevin.coursjavaandroid.model.bean.EleveBean;
import com.kevin.coursjavaandroid.model.bean.ResultBean;
import com.kevin.coursjavaandroid.transverse.OkHttpUtils;

import java.io.InputStreamReader;
import java.util.ArrayList;

import okhttp3.Response;

public class WsUtils {

    private static final String URL_WS_CODE_POSTAL = "http://www.citysearch-api.com/fr/city?login=webserviceexemple&apikey=sof940dd26cf107eabf8bf6827f87c3ca8e8d82546&cp=";

    private static final Gson gson = new Gson();

    public static EleveBean getElevFromWen() throws Exception {
        SystemClock.sleep(5000);//instruction qui dure 5sec
        return new EleveBean("tooto du web", "toto");
    }

    public static ArrayList<CityBean> getCitiesFromCp(String cp) throws Exception {
        //Url
        //Requete
        String json = OkHttpUtils.sendGetOkHttpRequest(URL_WS_CODE_POSTAL + cp);
        //Parse le json en Java
        ResultBean resultBean = gson.fromJson(json, ResultBean.class);
        //Traite le resultat
        if (resultBean.getErrors() != null) {
            throw new Exception("Une erreur est survenue : " + resultBean.getErrors().getMessage());
        }
        else if (resultBean.getResults() == null) {
            throw new Exception("Une erreur est survenue : ArrayListVille");
        }

        //Comme le webservice est codé par des stagiaires, on retire les ville qui ne correspondent pas.
        for (int i = resultBean.getResults().size() - 1; i >= 0; i--) {
            if (!resultBean.getResults().get(i).getCp().contains(cp)) {
                resultBean.getResults().remove(i);
            }
        }

        return resultBean.getResults();
    }

    public static ArrayList<CityBean> getCitiesFromCpOpti(String cp) throws Exception {
        //Url
        //Requete
        Response response = OkHttpUtils.sendGetOkHttpRequestResponse(URL_WS_CODE_POSTAL + cp);

        InputStreamReader isr = new InputStreamReader(response.body().byteStream());

        try {
            //Parse le json en Java
            ResultBean resultBean = gson.fromJson(isr, ResultBean.class);
            //Traite le resultat
            if (resultBean.getErrors() != null) {
                throw new Exception("Une erreur est survenue : " + resultBean.getErrors().getMessage());
            }
            else if (resultBean.getResults() == null) {
                throw new Exception("Une erreur est survenue : ArrayListVille");
            }

            //Comme le webservice est codé par des stagiaires, on retire les ville qui ne correspondent pas.
            for (int i = resultBean.getResults().size() - 1; i >= 0; i--) {
                if (!resultBean.getResults().get(i).getCp().contains(cp)) {
                    resultBean.getResults().remove(i);
                }
            }

            return resultBean.getResults();
        }
        finally {
            if (isr != null) {
                isr.close();
            }
        }
    }
}