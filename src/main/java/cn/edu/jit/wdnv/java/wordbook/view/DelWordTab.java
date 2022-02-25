package cn.edu.jit.wdnv.java.wordbook.view;

import javax.swing.*;

public class DelWordTab extends JPanel {
    JTextField inputWord;     //输入要删除的单词
    JButton submit;           //提交按钮
    JTextField hintMess;
    DelWordHandler handleDelWord;  //负责处理删除单词

    DelWordTab() {
        initView();
        registerListener();
    }

    private void initView() {
        inputWord = new JTextField(12);
        submit = new JButton("删除单词");
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        add(new JLabel("输入要删除的单词:"));
        add(inputWord);
        add(submit);
        add(new JLabel("提示:"));
        add(hintMess);
    }

    private void registerListener() {
        handleDelWord = new DelWordHandler();
        handleDelWord.setView(this);
        submit.addActionListener(handleDelWord);
    }
}