package com.kevin.coursjavaandroid;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.kevin.coursjavaandroid.model.bean.DaoMaster;
import com.kevin.coursjavaandroid.model.bean.DaoSession;
import com.squareup.otto.Bus;

import org.greenrobot.greendao.database.Database;

public class MyApplication extends Application {

    private static Bus bus;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        bus = new Bus();
        setupDatabase();
        Stetho.initializeWithDefaults(this);
    }

    public static Bus getBus() {
        return bus;
    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "mytable-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
