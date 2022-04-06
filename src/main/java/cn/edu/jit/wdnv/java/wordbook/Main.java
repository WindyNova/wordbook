package cn.edu.jit.wdnv.java.wordbook;
/*
  Launcher
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.edu.jit.wdnv.java.wordbook.mapper")
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);//启动窗口
    }
}