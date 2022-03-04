package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.DelWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelWordTab extends JPanel {
   protected JTextField inputWord;     //输入要删除的单词
    protected JButton submit;           //提交按钮
   protected JTextField hintMess;

    DelWordTab() {
        inputWord = new JTextField(12);
        submit = new JButton("删除单词");
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        add(new JLabel("输入要删除的单词:"));
        add(inputWord);
        add(submit);
        add(new JLabel("提示:"));
        add(hintMess);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitDel();
            }
        });
    }


    protected void submitDel() {
        String englishWord = inputWord.getText();
        if (englishWord.length() == 0)
        { hintMess.setText("您没有输入任何单词");return;}
        Word word = new Word();
        DelWord del = new DelWord();
        word.setEnglishWord(englishWord);
        int isOK = del.delWord(word);
        if (isOK != 0)
            hintMess.setText("删除单词成功");
        else
            hintMess.setText("删除失败，单词不在表里");
    }
}