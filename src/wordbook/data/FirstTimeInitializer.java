package wordbook.data;
/**
 * 项目初始化：创建表
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstTimeInitializer {

    Connection con = new ConnectDatabase().getCon();  //实例化ConnectDatabase类 调用get方法获取变量
//    Connection con = new ConnectDatabase().con;

    // 创建表word_table
    public FirstTimeInitializer() {
        try {
            Statement sta = con.createStatement();      //创建一个Statement实例（SQL语句对象）
            String SQL = "create table word_table" + "(word varchar(50) primary key,meaning varchar(200))";     //编写创建表的SQL语句
            sta.executeUpdate(SQL);     //执行语句
            con.close();    //关闭连接
        } catch (SQLException e) {//如果表已经存在，将触发SQL异常，即不再创建该表
        }

    }
}