package wordbook.view;
/**
 * 查询所有单词界面
 */

import javax.swing.*;
import java.awt.*;

public class QueryAllWordTab extends JPanel {
    JButton submit;    //查询按钮
    JTextArea showWord;       //显示查询结果
    QueryAllWordHandler handleQueryAllWord;  //负责处理查询全部单词

    QueryAllWordTab() {
        initView();
        registerListener();
    }

    public void initView() {
        setLayout(new BorderLayout());
        submit = new JButton("查询全部单词");
        add(submit, BorderLayout.NORTH);
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        add(new JScrollPane(showWord), BorderLayout.CENTER);
    }

    private void registerListener() {
        handleQueryAllWord = new QueryAllWordHandler();
        handleQueryAllWord.setView(this);
        submit.addActionListener(handleQueryAllWord);
    }
}