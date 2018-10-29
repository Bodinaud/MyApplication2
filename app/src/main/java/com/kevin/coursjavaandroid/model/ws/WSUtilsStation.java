package com.kevin.coursjavaandroid.model.ws;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kevin.coursjavaandroid.model.bean.PositionBean;
import com.kevin.coursjavaandroid.model.bean.VeloBean;
import com.kevin.coursjavaandroid.transverse.OkHttpUtils;

import java.io.InputStreamReader;
import java.util.ArrayList;

import okhttp3.Response;

public class WSUtilsStation {
    private static final String URL_WS_STATION_VELO = "https://api.jcdecaux.com/vls/v1/stations?contract=toulouse&apiKey=292bc73cbd40a6f6e28e20906dddfc04cc8c7806";

    private static final Gson gson = new Gson();

    public static ArrayList<PositionBean> getStation() throws Exception {

        Response response = OkHttpUtils.sendGetOkHttpRequestResponse(URL_WS_STATION_VELO);

        InputStreamReader isr = new InputStreamReader(response.body().byteStream());


        try {

            //Url
            //Requete
            String json = OkHttpUtils.sendGetOkHttpRequest(URL_WS_STATION_VELO);

            //Parser une ArrayList typée
            return gson.fromJson(json,
                    new TypeToken<ArrayList<VeloBean>>(){}.getType());
        }

         finally{
                if (isr != null) {
                    isr.close();
                }
            }
        }

}