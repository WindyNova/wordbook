package cn.edu.jit.wdnv.java.wordbook;
/*
  Launcher
 */

import cn.edu.jit.wdnv.java.wordbook.view.MainWindow;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new MainWindow(); //启动窗口
    }
}