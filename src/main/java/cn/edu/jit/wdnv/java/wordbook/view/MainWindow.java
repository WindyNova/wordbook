package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.utils.GetBeanUtil;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainWindow extends JFrame {
    //设定选项卡显示在左侧，实例化各个view
    private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    private JPanel panel;
    AddWordTab addWordView = GetBeanUtil.getBean(AddWordTab.class); //添加单词页面
    DelWordTab delWordView = GetBeanUtil.getBean(DelWordTab.class); //删除单词页面
    GetMeaningTab GetMeaningView = GetBeanUtil.getBean(GetMeaningTab.class); //单个单词页面
    AllWordsTab allWordsView = GetBeanUtil.getBean(AllWordsTab.class); //所有单词页面
    UpdateWordsTab updateWordsView = GetBeanUtil.getBean(UpdateWordsTab.class); //所有单词页
    RandomWordsTab randomWordsView = GetBeanUtil.getBean(RandomWordsTab.class); //随机单词页面


    public MainWindow() {
        super("单词簿");
        setBounds(100, 100, 720, 460);  //设置窗口显示位置和窗口大小
        setVisible(true);   //设置窗口状态：显示
        tabbedPane.add("查询单个单词", GetMeaningView);
        tabbedPane.add("添加单词", addWordView);//设置选项卡标题，并附加相应的页
        tabbedPane.add("更新单词", updateWordsView);//设置选项卡标题，并附加相应的页
        tabbedPane.add("删除单词", delWordView);
        tabbedPane.add("浏览全部单词", allWordsView);
        tabbedPane.add("随机抽取单词", randomWordsView);
        this.add(tabbedPane, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭后销毁进程
    }
}
