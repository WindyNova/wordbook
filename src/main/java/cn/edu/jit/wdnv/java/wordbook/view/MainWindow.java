package cn.edu.jit.wdnv.java.wordbook.view;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
@Component
public class MainWindow extends JFrame {
    //设定选项卡显示在左侧，实例化各个view
    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    private JPanel panel;
    final AddWordTab addWordView; //添加单词页面

    final DelWordTab delWordView; //删除单词页面
    final GetMeaningTab queryOneWordView; //单个单词页面
    final QueryAllWordTab queryAllWordView; //所有单词页面
    final RandomlyQueryTab queryRandomView; //随机单词页面


    public MainWindow() {
        super("单词簿");
        setBounds(100, 100, 720, 460);  //设置窗口显示位置和窗口大小
        setVisible(true);   //设置窗口状态：显示
        tabbedPane.add("添加单词", addWordView = new AddWordTab());     //设置选项卡标题，并附加相应的页面

        tabbedPane.add("删除单词", delWordView = new DelWordTab());
        tabbedPane.add("查询单个单词", queryOneWordView = new GetMeaningTab());
        tabbedPane.add("浏览全部单词", queryAllWordView = new QueryAllWordTab());
        tabbedPane.add("随机抽取单词", queryRandomView = new RandomlyQueryTab());
        add(tabbedPane, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭后销毁进程
    }
}
