package cn.edu.jit.wdnv.java.wordbook.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;

/**
 * @author
 * @date 2022/4/8
 * @apinote
 */
public class HeadlessSpringBootContextLoader extends SpringBootContextLoader {

        @Override
        protected SpringApplication getSpringApplication() {
            SpringApplication application = super.getSpringApplication();
            application.setHeadless(false);
            return application;
        }
    }

