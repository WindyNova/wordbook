package cn.edu.jit.wdnv.java.wordbook;
/*
  项目初始化：创建表
 */

import cn.edu.jit.wdnv.java.wordbook.dao.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstTimeInitializer {

    Connection con = new DBConnect().con();  //实例化ConnectDatabase类 调用con方法获取变量


    // 创建表word_table
    public FirstTimeInitializer() {
        try {
            Statement sta = con.createStatement();      //创建一个Statement实例（SQL语句对象）
            String sql = "create table word_table" + "(word varchar(50) primary key,meaning varchar(200))";     //编写创建表的SQL语句
            sta.executeUpdate(sql);     //执行语句
            con.close();    //关闭连接
        } catch (SQLException e) {//如果表已经存在，将触发SQL异常，即不再创建该表
        }

    }
}