package wordbook.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryAllWord extends ConnectDatabase {
    public Word[] queryAllWord() {
        connectDatabase();
        Word[] word = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from word_table");
            rs.last();      //将游标移到最后
            int recordAmount = rs.getRow();//结果集中的全部记录条数
            word = new Word[recordAmount];
            for (int i = 0; i < word.length; i++) {
                word[i] = new Word();
            }
            rs.beforeFirst();   //将游标移到首部
            int i = 0;
            while (rs.next()) {
                word[i].setEnglishWord(rs.getString(1));
                word[i].setMeaning(rs.getString(2));
                i++;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }
}
