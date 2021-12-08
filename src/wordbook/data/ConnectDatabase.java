package wordbook.data;
/*
  连接数据库
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
    // 设置数据库连接所需的基本参数
    public final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DBURL = "jdbc:mysql://sz1.test.nodes.wdksl.com:33068/wordbook";      //指定数据库
    public final static String DBUSER = "test";     //数据库用户名
    public final static String PASSWORD = "12345678";

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
        connectDatabase();  //调用连接数据库方法改变con的值
        return con;
    }

}