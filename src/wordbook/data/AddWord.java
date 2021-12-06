package wordbook.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddWord extends ConnectDatabase {
    //定义状态信息
    int status;

    public int insertWord(Word word) {
        connectDatabase();
        try {
            String SQL = "insert into word_table values(?,?)";  //编写SQL语句
            PreparedStatement sta = con.prepareStatement(SQL);
            sta.setString(1, word.getEnglishWord()); //第1个通配符?的值是word.getEnglishWord():
            sta.setString(2, word.getMeaning()); //第2个通配符?的值是word.getMeaning():
            status = sta.executeUpdate();
            con.close();
        } catch (SQLException e) {
            status = 0; //word_table表中word字段是主键，即不允许单词重复
        }
        return status;
    }
}
