package wordbook.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateWord extends ConnectDatabase {
    int status;

    public int updateWord(Word word) {
        connectDatabase();
        try {
            String SQL = "update word_table set meaning = ? where word = ? ";
            PreparedStatement sta = con.prepareStatement(SQL);
            sta.setString(1, word.getMeaning()); //第1个通配符?的值是word.getMeaning():
            sta.setString(2, word.getEnglishWord()); //第2个通配符?的值是word.getEnglishWord():
            status = sta.executeUpdate(); //execute
            con.close();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }
}
