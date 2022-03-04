package cn.edu.jit.wdnv.java.wordbook.dao;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import cn.edu.jit.wdnv.java.wordbook.utils.DBConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryAllWord extends DBConnect {
    public Word[] queryAllWord() {
        Word[] word = null;
        try {
            Statement sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = sql.executeQuery("select * from word_table");
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
