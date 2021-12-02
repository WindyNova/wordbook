

package wordbook.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase { //连接数据库的类
    Connection con;
    public final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DBURL = "jdbc:mysql://127.0.0.1:3306/wordbook";
    public final static String DBUSER = "root";
    public final static String PASSWORD = "12345678";

    public final void connectDatabase() {
        try {
            String uri = "com.mysql.cj.jdbc.driver";
            con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); //连接数据库代码
        } catch (Exception e) {
        }
    }
}