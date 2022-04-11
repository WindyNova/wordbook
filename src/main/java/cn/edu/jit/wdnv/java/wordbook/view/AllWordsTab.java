package cn.edu.jit.wdnv.java.wordbook.view;
/*
  查询所有单词界面
 */

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AllWordsTab extends JPanel {
    protected final JButton submit;    //查询按钮
    protected final JTextArea showWord;//显示查询结果

    @Autowired
    private WordMapper wordMapper;


    AllWordsTab() {
        setLayout(new BorderLayout());
        submit = new JButton("查询全部单词");
        add(submit, BorderLayout.NORTH);
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        add(new JScrollPane(showWord), BorderLayout.CENTER);
        submit.addActionListener(e -> queryAllWord());
    }


    protected void queryAllWord() {

        showWord.setText(String.valueOf(wordMapper.queryAllWords()));
    }
}
