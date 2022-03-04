package cn.edu.jit.wdnv.java.wordbook.view;
/*
  查询所有单词界面
 */

import cn.edu.jit.wdnv.java.wordbook.dao.QueryAllWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryAllWordTab extends JPanel {
    protected JButton submit;    //查询按钮
    protected JTextArea showWord;       //显示查询结果

    QueryAllWordTab() {
        setLayout(new BorderLayout());
        submit = new JButton("查询全部单词");
        add(submit, BorderLayout.NORTH);
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        add(new JScrollPane(showWord), BorderLayout.CENTER);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryAllWord();
            }
        });
    }


    protected void queryAllWord() {
        showWord.setText("");
        QueryAllWord query = new QueryAllWord();
        Word[] result = query.queryAllWord();
        for (int i = 0; i < result.length; i++) {
            int m = i + 1;
            showWord.append(m + "." + result[i].getEnglishWord());
            showWord.append("   " + result[i].getMeaning());
            showWord.append("\n");
        }
    }
}