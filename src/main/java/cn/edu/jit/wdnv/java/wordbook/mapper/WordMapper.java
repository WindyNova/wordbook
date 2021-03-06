package cn.edu.jit.wdnv.java.wordbook.mapper;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Mapper
public interface WordMapper {


    @Select({"select t.*\n" +
            "          FROM wordbook.word_table t\n" +
            "          LIMIT 501"})
    @Results({
            @Result(column = "word", property = "word", jdbcType = JdbcType.VARCHAR),
            @Result(column = "meaning", property = "meaning", jdbcType = JdbcType.VARCHAR)
    })
    List<Word> TestConnections();


    @Insert({"insert into word_table (word, meaning)", "values(#{word,jdbcType=VARCHAR}, #{meaning,jdbcType=VARCHAR})"})
    int insertWord(String word, String meaning);


    @Delete("delete from word_table where word = #{word}")
    int deleteWord(String word);

    @Update("update word_table set meaning = #{meaning} where word = #{word}")
    int updateWord(String word, String meaning);


    @Select("select meaning from word_table where word = #{word}")
    String getMeaning(String word);

    @Results(id = "wordResult", value = {
            @Result(column = "word", property = "word", jdbcType = JdbcType.VARCHAR),
            @Result(column = "meaning", property = "meaning", jdbcType = JdbcType.VARCHAR)})
    @Select("select word,meaning from word_table where word = #{word}")
    Word getWordNMeaning(String word);

    @Select("select * from word_table order by rand() limit 4")
    Word[] getQuiz();

    @Select("select * from word_table order by rand() limit #{count}")
    List<Word> getRandomWord(int count);
}