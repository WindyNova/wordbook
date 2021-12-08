/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package wordbook.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Fuzzbear
 * @date 2021/12/6 19:30
 */
public class GetChoices extends ConnectDatabase{
    public Word[] getChoices(){
        connectDatabase();
        Word[] word = null;
        Statement sql;
        ResultSet rs;
        try{
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from word_table order by rand() limit 4");
            rs.last();  //将游标移到最后
            int recordAmout = rs.getRow();  //结果集中的全部记录条数
            word = new Word[recordAmout];
            for(int i = 0; i < word.length; i++){
                word[i] = new Word();
            }
            rs.beforeFirst();   //将游标移到首部
            int i = 0;
            while(rs.next()){
                word[i].setEnglishWord(rs.getString(1));
                word[i].setMeaning(rs.getString(2));
                i++;
            }

            con.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

//        for(int i=0; i<word.length;i++){
//            System.out.println(word[i].getEnglishWord());
//            System.out.println(word[i].getMeaning());
//        }


        return word;
    }


}