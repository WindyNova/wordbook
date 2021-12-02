package wordbook.view;
/**
 * 主窗口
 */

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    final JTabbedPane tabbedPane; //JTabbedPane选项卡集成视图
    final AddWordTab addWordView; //添加单词
    final UpdateWordTab updateWordView; //修改单词
    final DelWordTab delWordView; //删除单词
    final QuerySingleWordTab queryOneWordView; //单个单词
    final QueryAllWordTab queryAllWordView; //所有单词
    final RandomlyQueryTab queryRandomView; //随机单词

    public MainWindow() {
        setBounds(100, 100, 720, 460);
        setVisible(true);
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);//设定选项卡显示在左侧，实例化各个view
        tabbedPane.add("添加单词", addWordView = new AddWordTab());
        tabbedPane.add("修改单词", updateWordView = new UpdateWordTab());
        tabbedPane.add("删除单词", delWordView = new DelWordTab());
        tabbedPane.add("查询单个单词", queryOneWordView = new QuerySingleWordTab());
        tabbedPane.add("浏览全部单词", queryAllWordView = new QueryAllWordTab());
        tabbedPane.add("随机抽取单词", queryRandomView = new RandomlyQueryTab());
        add(tabbedPane, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //关闭后销毁进程
    }
}