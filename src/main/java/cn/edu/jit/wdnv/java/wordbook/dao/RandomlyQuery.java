package cn.edu.jit.wdnv.java.wordbook.dao;
/*
  随机抽取单词
 */
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomlyQuery extends DBConnect {
    int count = 0;//随机抽取的数目

    public int getCount() {
        return count;
    }

    public void setCount(int n) {
        count = n;
    }

    public Word[] randomQueryWord() {
        Word[] word = null;
        Statement sql;
        ResultSet rs;
        try {
            sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("select * from word_table");
            rs.last();
            int recordAmount = rs.getRow();//结果集中的记录
            count = Math.min(count, recordAmount);
            word = new Word[count];
            for (int i = 0; i < word.length; i++) {
                word[i] = new Word();
            }
            //得到1至recordAmount之间count个不同随机整数（存放在index中）：
            int[] index = getRandomNumber(recordAmount, count);
            int m = 0;
            for (int randomNumber : index) { // randomNumber依次取数组index每个单元的值
                rs.absolute(randomNumber);//查询游标移动到第randomNumber行
                word[m].setEnglishWord(rs.getString(1));
                word[m].setMeaning(rs.getString(2));
                m++;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }

    public int[] getRandomNumber(int max, int count) {
        // 得到1至max之间的amount个不同随机整数（包括1和max）：
        int[] randomNumber = new int[count];
        Set<Integer> set = new HashSet<>(); //set不允许有相同的元素
        int index = set.size();
        Random random = new Random();
        while (index < count) {
            int number = random.nextInt(max) + 1;
            set.add(number); //number放入集合set中
            index = set.size();
        }
        Iterator<Integer> iter = set.iterator();
        index = 0;
        while (iter.hasNext()) {  //把集合中的随机数放入数组
            Integer te = iter.next();
            randomNumber[index] = te;
            index++;
        }
        return randomNumber;
    }
}
