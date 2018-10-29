package com.kevin.coursjavaandroid.model.bdd;

import com.kevin.coursjavaandroid.MyApplication;
import com.kevin.coursjavaandroid.model.bean.EleveBean;
import com.kevin.coursjavaandroid.model.bean.EleveBeanDao;

import java.util.List;


public class EleveDaoUtils {
    public static EleveBeanDao getDao() {
        return MyApplication.getDaoSession().getEleveBeanDao();
    }

    public static void insertOrReplace(EleveBean data) {
        getDao().insertOrReplace(data);
    }

    public static List<EleveBean> loadAll() {
        return getDao().loadAll();
    }
}
