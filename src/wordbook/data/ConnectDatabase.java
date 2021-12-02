package wordbook.data;
/**
 * 连接数据库
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    public final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DBURL = "jdbc:mysql://127.0.0.1:3306/wordbook";
    public final static String DBUSER = "root";
    public final static String PASSWORD = "12345678";
    Connection con;

    public final void connectDatabase() {
        try {
            Class.forName(DBDRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try { //创建名字是MyEnglishBook的数据库
            con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); //连接数据库代码

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}