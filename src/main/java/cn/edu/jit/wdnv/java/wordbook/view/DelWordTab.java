package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class DelWordTab extends JPanel {
    protected final JTextField inputWord;     //输入要删除的单词
    protected final JButton submit;           //提交按钮
    protected final JTextField hintMess;
    @Autowired
    WordMapper wordMapper;

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
        if (englishWord.length() == 0) {
            hintMess.setText("您没有输入任何单词");
        }
        int status = wordMapper.deleteWord(englishWord);
        if (status != 0)
            hintMess.setText("删除单词成功");
        else
            hintMess.setText("删除失败，单词不在表里");
    }
}