package wordbook.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseAndTable {
    Connection con;
    public final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DBURL = "jdbc:mysql://127.0.0.1:3306/wordbook";
    public final static String DBUSER = "root";
    public final static String PASSWORD = "12345678";

    public CreateDatabaseAndTable() {
        try {
            Class.forName(DBDRIVER);
        } catch (Exception e) {
        }
        try { //创建名字是MyEnglishBook的数据库
            // String uri ="jdbc:derby:MyEnglishBook;create=true";
            con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); //连接数据库代码

        } catch (Exception e) {
        }
        try {
            Statement sta = con.createStatement();
            String SQL = "create table word_table" +
                    "(word varchar(50) primary key,meaning varchar(200))";
            sta.executeUpdate(SQL);//创建表
            con.close();
        } catch (SQLException e) {//如果表已经存在，将触发SQL异常，即不再创建该表
        }

    }
}