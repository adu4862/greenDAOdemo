package com.yl.greendaodemo;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class CustomDaoGenerater {
    public static void main(String[] args) {
        //1.第一个参数是数据库版本号,第二个参数是数据库的包名
        Schema schema = new Schema(1, "com.yl.greendaodemo.db");
        //创建表,参数是表名
        Entity info = schema.addEntity("Info");
        //为表添加字段
        info.addIdProperty();//该字段是id默认主键自增长
        info.addStringProperty("name");
        info.addIntProperty("age");
        info.addStringProperty("tel");

        //生成数据库相关类
        //第二个参数指定生成文件的本次存储路径,AndroidStudio工程指定到当前工程的java路径
        try {
            new DaoGenerator().generateAll(schema,"C:\\Users\\Administrator\\Downloads\\greenDAOdemo\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
