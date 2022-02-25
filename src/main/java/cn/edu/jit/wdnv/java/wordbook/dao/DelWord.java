package cn.edu.jit.wdnv.java.wordbook.dao;

import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DelWord extends DBConnect {
    int status;

    public int delWord(Word word) {
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
