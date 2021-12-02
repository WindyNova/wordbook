package ch3.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWord extends ConnectDatabase {
    int isOK;

    public int insertWord(Word word) {
        connectDatabase();
        try {
            String SQL = "insert into word_table values(?,?)";
            PreparedStatement sta = con.prepareStatement(SQL);
            //从左向右数第1个通配符?的值是word.getEnglishWord():
            sta.setString(1, word.getEnglishWord());
            //从左向右数第2个通配符?的值是word.getMeaning():
            sta.setString(2, word.getMeaning());
            isOK = sta.executeUpdate();
            con.close();
        } catch (SQLException e) {
            isOK = 0; //word_table表中word字段是主键，即不允许单词重复
        }
        return isOK;
    }
}
