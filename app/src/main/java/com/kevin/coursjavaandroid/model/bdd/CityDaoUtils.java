package com.kevin.coursjavaandroid.model.bdd;

import com.kevin.coursjavaandroid.MyApplication;
import com.kevin.coursjavaandroid.model.bean.CityBean;
import com.kevin.coursjavaandroid.model.bean.CityBeanDao;

import java.util.ArrayList;
import java.util.List;

public class CityDaoUtils {
    public static CityBeanDao getDao() {
        return MyApplication.getDaoSession().getCityBeanDao();
    }

    public static void insertOrReplace(CityBean data) {
        getDao().insertOrReplace(data);
    }

    public static void insertOrReplace(ArrayList<CityBean> data) {

        ArrayList<CityBean> aEnregistrer = new ArrayList<>();

        for (CityBean d : data) {
            if (!exist(d)) {
                aEnregistrer.add(d);
            }
        }

        getDao().insertOrReplaceInTx(aEnregistrer);
    }

    public static boolean exist(CityBean data) {
        return getDao().queryBuilder().where(CityBeanDao.Properties.Ville.eq(
                data.getVille()),
                CityBeanDao.Properties.Cp.eq(data.getCp())).count() > 0;
    }

    public static ArrayList<CityBean> getCitiesFromCp(String cp) {

        return (ArrayList<CityBean>) getDao().queryBuilder().where(CityBeanDao.Properties.Cp.like("%" + cp + "%")).orderAsc(CityBeanDao.Properties.Cp).list();
    }

    public static List<CityBean> loadAll() {
        return getDao().loadAll();
    }
}
