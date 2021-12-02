package wordbook.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstTimeInitializer {

    Connection con = new ConnectDatabase().con;  //实例化con 从ConnectDatabase传参

    public FirstTimeInitializer() {

        try {
            Statement sta = con.createStatement();
            String SQL = "create table word_table" + "(word varchar(50) primary key,meaning varchar(200))";
            sta.executeUpdate(SQL);//创建表
            con.close();
        } catch (SQLException e) {//如果表已经存在，将触发SQL异常，即不再创建该表
        }

    }
}