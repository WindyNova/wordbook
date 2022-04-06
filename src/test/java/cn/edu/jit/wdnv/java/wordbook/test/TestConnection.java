package cn.edu.jit.wdnv.java.wordbook.test;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;

import org.junit.jupiter.api.Test;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author
 * @date 2022/4/6
 * @apinote
 */
public class TestConnection {
@Autowired
    private WordMapper wordMapper;
    private static final Logger logger = LoggerFactory.getLogger(TestConnection.class);
    @Test
    public void testConnection() {
        wordMapper.queryAllWords();
        ;
    }
}

