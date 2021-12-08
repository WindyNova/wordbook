package wordbook.view;
/**
 * 主窗口
 */

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    final JTabbedPane tabbedPane; //JTabbedPane选项卡集成视图（选项卡组件）
    final AddWordTab addWordView; //添加单词页面
    final UpdateWordTab updateWordView; //修改单词页面
    final DelWordTab delWordView; //删除单词页面
    final QuerySingleWordTab queryOneWordView; //单个单词页面
    final QueryAllWordTab queryAllWordView; //所有单词页面
    final RandomlyQueryTab queryRandomView; //随机单词页面
    final MultipleChoiceTab MultipleChoiceView;//单选测试页面

    public MainWindow() {
        super("单词簿");
        setBounds(100, 100, 720, 460);  //设置窗口显示位置和窗口大小
        setVisible(true);   //设置窗口状态：显示
        tabbedPane = new JTabbedPane(JTabbedPane.LEFT); //设定选项卡显示在左侧，实例化各个view

        tabbedPane.add("添加单词", addWordView = new AddWordTab());     //设置选项卡标题，并附加相应的页面
        tabbedPane.add("修改单词", updateWordView = new UpdateWordTab());
        tabbedPane.add("删除单词", delWordView = new DelWordTab());
        tabbedPane.add("查询单个单词", queryOneWordView = new QuerySingleWordTab());
        tabbedPane.add("浏览全部单词", queryAllWordView = new QueryAllWordTab());
        tabbedPane.add("随机抽取单词", queryRandomView = new RandomlyQueryTab());
        tabbedPane.add("单选测试",MultipleChoiceView = new MultipleChoiceTab());
        add(tabbedPane, BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //关闭后销毁进程
    }
}