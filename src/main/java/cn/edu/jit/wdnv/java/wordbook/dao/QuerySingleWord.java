package cn.edu.jit.wdnv.java.wordbook.dao;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import cn.edu.jit.wdnv.java.wordbook.utils.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerySingleWord extends DBConnect {
    public Word queryOneWord(Word word) {
        Word result = null;
        Statement sql;
        ResultSet rs;
        String str =
                "select * from word_table where word ='" + word.getEnglishWord() + "'";
        try {
            sql = con.createStatement();
            rs = sql.executeQuery(str);
            if (rs.next()) {
                result = new Word();
                result.setEnglishWord(rs.getString(1));
                result.setMeaning(rs.getString(2));
            }
            con.close();
        } catch (SQLException ignored) {
        }
        return result;
    }
}
