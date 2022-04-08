package cn.edu.jit.wdnv.java.wordbook.test;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author
 * @date 2022/4/8
 * @apinote
 */
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(value = "classpath:application.yml")
@SpringBootTest(classes = {GetAllWords.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GetAllWords {
    @Autowired
    WordMapper wordMapper;
@Test
    public void getAllWords() {
        System.out.println(wordMapper.queryAllWords());
    }
}
