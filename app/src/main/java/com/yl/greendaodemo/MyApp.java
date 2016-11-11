package com.yl.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.yl.greendaodemo.db.DaoMaster;
import com.yl.greendaodemo.db.DaoSession;
import com.yl.greendaodemo.db.InfoDao;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class MyApp extends Application {

    public InfoDao getDao() {
        return dao;
    }

    private InfoDao dao;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }

    /**
     * 设置数据库
     */
    private void setupDatabase() {
        //通过DaoMaster的内部类DevOpenHelper创建数据库
        //注意: 默认的DaoMaster.DevOpenHelper会在数据库升级时,删除所有的表
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "student.db", null);//获取数据库
        SQLiteDatabase database = helper.getWritableDatabase();//获取数据库
        DaoMaster daoMaster = new DaoMaster(database);//获取DaoMaster
        DaoSession daoSession = daoMaster.newSession();//获取session
        //拿到对应表的dao对象
        dao = daoSession.getInfoDao();



    }
}
