package com.kevin.coursjavaandroid.transverse;


import com.kevin.coursjavaandroid.MyApplication;
import com.kevin.coursjavaandroid.model.bean.CityBean;
import com.kevin.coursjavaandroid.model.bean.CityBeanDao;
import com.kevin.coursjavaandroid.model.bean.EleveBean;

import java.util.ArrayList;
import java.util.List;

public class CityBeanDaoUtils {

    private static CityBeanDao getCityBeanDao() {
        return MyApplication.getDaoSession().getCityBeanDao();
    }

    public static void insertOrUpdate(CityBean city) {
        getCityBeanDao().insertOrReplace(city);
    }
    public static void clearCity() {
        getCityBeanDao().deleteAll();
    }
    public static void deleteCityWithId(long id) {
        getCityBeanDao().deleteByKey(id);
    }
    public static CityBean getCityeById(long id) {
        return getCityBeanDao().load(id);
    }
    public static ArrayList<CityBean> getAllCity() {
        return (ArrayList<CityBean>) getCityBeanDao().loadAll();
    }

    /**
     * Retourne une liste de ville en fonction du cp
     * @param cp
     * @return
     */
    public static List<CityBean> getCitybycp (String cp) {
        return getCityBeanDao().queryBuilder().where(CityBeanDao.Properties.Ville.eq(cp)).list();
    }

}