package cn.edu.jit.wdnv.java.wordbook.dao;
/*
  连接数据库
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    // 设置数据库连接所需的基本参数
    private final static String dbURL = "jdbc:mysql://localhost:3306/wordbook";      //指定数据库
    private final static String dbUSER = "user";     //数据库用户名
    private final static String dbPASS = "12345678";

    // 定义连接对象
    protected static Connection con;

    // 连接数据库方法
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    //装载数据库驱动
            con= DriverManager.getConnection(dbURL, dbUSER, dbPASS); //连接数据库代码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}