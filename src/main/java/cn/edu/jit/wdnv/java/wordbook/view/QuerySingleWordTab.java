package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.QuerySingleWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("Convert2Lambda")
public class QuerySingleWordTab extends JPanel {
    protected final JTextField inputWord;     //输入要查询的单词
    protected final JButton submit;
    protected final JTextArea showWord;       //显示查询结果

    QuerySingleWordTab() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        inputWord = new JTextField(12);
        submit = new JButton("查询单词");
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        pNorth.add(new JLabel("输入要查询的单词:"));
        pNorth.add(inputWord);
        pNorth.add(submit);
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(showWord), BorderLayout.CENTER);
submit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        QuerySingleWord();
    }
});
    }

    protected void QuerySingleWord() {
        String englishWord = inputWord.getText();
        if (englishWord.length() == 0)
        { showWord.setText("您没有输入任何单词\n");return;}
        Word word = new Word();
        word.setEnglishWord(englishWord);
        QuerySingleWord query = new QuerySingleWord();
        Word result = query.queryOneWord(word);
        if (result == null) {
            showWord.setText("本单词簿中不存在您输出的单词\n");
            return;
        }
        if(showWord.getText().equals("您没有输入任何单词\n")
                || showWord.getText().equals("本单词簿中不存在您输出的单词\n")){
            showWord.setText(null);
        }
        showWord.append(" " + result.getEnglishWord());
        showWord.append("   " + result.getMeaning());
        showWord.append("\n");
    }



}