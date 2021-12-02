package wordbook.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelWord extends ConnectDatabase {
    int status;

    public int delWord(Word word) {
        connectDatabase();
        try {
            String SQL = "delete from word_table where word = ? ";
            PreparedStatement sta = con.prepareStatement(SQL);
            sta.setString(1, word.getEnglishWord()); //通配符?的值是word.getEnglishWord():
            status = sta.executeUpdate();
            con.close();
        } catch (SQLException e) {
            status = 0;
        }
        return status;
    }
}
