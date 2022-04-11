package cn.edu.jit.wdnv.java.wordbook;
// Launcher

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
@MapperScan("cn.edu.jit.wdnv.java.wordbook.mapper")
public class WordbookApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(WordbookApplication.class);
        builder.headless(false).run(args); //make it not headless
    }
}