package cn.edu.jit.wdnv.java.wordbook.test;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;

import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" },loader = HeadlessSpringBootContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = "classpath:application.yml")
@SpringBootTest(classes = {FunctionTest.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FunctionTest {

    @Autowired
    private WordMapper wordMapper;

    @Test
    @Before
    void DelWord() {
        wordMapper.deleteWord("Test123");
        Assert.assertEquals(null, wordMapper.getMeaning("Test123"));
    }

    @Test
    @Before
    void AddWord() {

        wordMapper.insertWord("Test123","Test你好");
        Assert.assertEquals("Test你好", wordMapper.getMeaning("Test123"));
    }



    @Test
    void TestConnections() {

Assertions.assertNotNull(wordMapper.TestConnections());
    }

    @Test
    void randomQuery() {

        System.out.println(wordMapper.getRandomWord(3));
    }

    @Test
    void UpdateWord() {
        wordMapper.updateWord("Test123", "Test321");
        Assert.assertEquals("Test321", wordMapper.getMeaning("Test123"));
    }
        @Test
        void TestQuiz() {
            Word[] result = wordMapper.getQuiz();
            System.out.println(Arrays.toString(result));

    }



}
