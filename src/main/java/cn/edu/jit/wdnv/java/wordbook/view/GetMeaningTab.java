package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class GetMeaningTab extends JPanel {
    protected final JTextField inputWord;     //输入要查询的单词
    protected final JButton submit;
    protected final JButton reset;      //重置按钮
    protected final JTextArea showWord;//显示查询结果


    @Autowired
    private WordMapper wordMapper;

    GetMeaningTab() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        inputWord = new JTextField(12);
        submit = new JButton("查询单词");
        reset = new JButton("清空");
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        pNorth.add(new JLabel("输入要查询的单词:"));
        pNorth.add(inputWord);
        pNorth.add(submit);
        pNorth.add(reset);
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(showWord), BorderLayout.CENTER);
        submit.addActionListener(e -> GetMeaning());
        reset.addActionListener(e -> showWord.setText(""));
    }


    protected void GetMeaning() {
        String englishWord = inputWord.getText();
        if (englishWord.length() == 0) {
            showWord.append("您没有输入任何单词\n");
            return;
        }
        Word result = wordMapper.getWordNMeaning(englishWord);

        if (result == null) {
            showWord.append("本单词簿中不存在您输出的单词\n");
        } else {
            showWord.append(result + "\n");
        }
        if (showWord.getText().equals("您没有输入任何单词\n")) {
            showWord.setText(null);
        }

    }
}