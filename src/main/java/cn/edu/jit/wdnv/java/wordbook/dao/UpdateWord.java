package cn.edu.jit.wdnv.java.wordbook.dao;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import cn.edu.jit.wdnv.java.wordbook.utils.DBConnect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateWord extends DBConnect {
    int status;

    public int updateWord(Word word) {
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
