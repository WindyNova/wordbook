package wordbook;
/**
 * Launcher
 */

import wordbook.data.FirstTimeInitializer;
import wordbook.view.MainWindow;

public class Main {
    public static void main(String[] args) {
        new FirstTimeInitializer(); //第一次启动初始化数据库
        new MainWindow(); //启动窗口
    }
}