package wordbook.data;
/**
 * 连接数据库
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    // 设置数据库连接所需的基本参数
//    public final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";     //Abel
    public final static String DBDRIVER = "com.mysql.jdbc.Driver";  //Fuzzbear  数据库驱动
    public final static String DBURL = "jdbc:mysql://127.0.0.1:3306/wordbook";      //指定数据库
    public final static String DBUSER = "root";     //数据库用户名
//    public final static String PASSWORD = "12345678";     //Abel‘s database password
    public final static String PASSWORD = "root";       //Fuzzbear  数据库密码

    // 定义连接对象
    Connection con;

    // 连接数据库方法
    public final void connectDatabase() {
        try {
            Class.forName(DBDRIVER);    //装载数据库驱动
        } catch (Exception e) {
            e.printStackTrace();
        }
        try { //创建名字是MyEnglishBook的数据库
            con = DriverManager.getConnection(DBURL, DBUSER, PASSWORD); //连接数据库代码

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 调用此方法获取数据库连接对象
    public Connection getCon(){
        connectDatabase();  //调用连接数据库方法为改变con的值
        return con;
    }

}