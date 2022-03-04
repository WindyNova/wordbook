package cn.edu.jit.wdnv.java.wordbook.dao;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import cn.edu.jit.wdnv.java.wordbook.utils.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWord extends DBConnect {
    //定义状态信息
    int status;

    //将单词添加到数据库
    public int insertWord(Word word) {
        try {
            String SQL = "insert into word_table values(?,?)";  //编写SQL语句
            PreparedStatement sta = con.prepareStatement(SQL);  //创建一个PreparedStatement实例（SQL语句预编译对象）
            sta.setString(1, word.getEnglishWord()); //第1个通配符?的值是word.getEnglishWord():
            sta.setString(2, word.getMeaning());    //第2个通配符?的值是word.getMeaning():
            status = sta.executeUpdate();   //执行SQL语句
            con.close();    //关闭连接
        } catch (SQLException e) {
            status = 0; //word_table表中word字段是主键，即不允许单词重复
        }
        return status;
    }
}
