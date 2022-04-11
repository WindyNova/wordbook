package cn.edu.jit.wdnv.java.wordbook.test;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" },loader = HeadlessSpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = "classpath:application.yml")
@SpringBootTest(classes = {FunctionTest.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FunctionTest {

    @Autowired
    private WordMapper wordMapper;

    @Test
    void AddWord() {

        String[][] a = {{"boy", "男孩"}, {"girl", "女孩"},
                {"sun", "太阳"}, {"moon", "月亮"},
                {"book", "书籍"}, {"water", "水"}
        };
        for (String[] strings : a) {
            wordMapper.insertWord(strings[0], strings[1]);
        }
   //     Assert.assertEquals(wordMapper.getMeaning());
    }

    @Test
    void GetMeaning() {
        Assert.assertEquals("Test你好", wordMapper.getMeaning("Test123"));

    }

    @Test
    void QueryAllWord() {

Assertions.assertNotNull(wordMapper.queryAllWords());
    }

    @Test
    void randomQuery() {

        System.out.println(wordMapper.getRandomWord(3));
    }

    @Test
    void UpdateWord() {
        wordMapper.updateWord("book", "n.书籍，卷，帐簿，名册，工作簿 vt.预订，登记");
        wordMapper.deleteWord("boy");
        wordMapper.deleteWord("del");
    }
        @Test
        void test() {
            Word[] result = wordMapper.getQuiz();
            System.out.println(result);

    }



}
