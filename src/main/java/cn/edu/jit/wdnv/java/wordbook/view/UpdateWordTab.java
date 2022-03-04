package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.QuerySingleWord;
import cn.edu.jit.wdnv.java.wordbook.dao.UpdateWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateWordTab extends JPanel {
    JTextField inputWord;        //输入要更新的单词
    JTextField inputNewMeaning;  //输入单词的新解释
    JButton lookWord;            //提交查看
    JButton submit;              //提交更新按钮
    JTextField hintMess;

    UpdateWordTab() {
        Box boxH;                 //行式盒
        Box boxVOne, boxVTwo;      //列式盒
        boxH = Box.createHorizontalBox();
        boxVOne = Box.createVerticalBox();
        boxVTwo = Box.createVerticalBox();
        inputWord = new JTextField(30);
        inputNewMeaning = new JTextField(30);
        submit = new JButton("提交新的解释");
        lookWord = new JButton("查看原有解释");
        hintMess = new JTextField(20);
        hintMess.setEditable(false);
        boxVOne.add(new JLabel("输入单词:"));
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("查看旧的解释:"));
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("输入新的解释:"));
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("提交新的解释:"));
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("提示信息:"));
        boxVTwo.add(inputWord);
        boxVTwo.add(lookWord);
        boxVTwo.add(inputNewMeaning);
        boxVTwo.add(submit);
        boxVTwo.add(hintMess);
        boxH.add(boxVOne);
        boxH.add(Box.createHorizontalStrut(10));
        boxH.add(boxVTwo);
        add(boxH);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String englishWord = inputWord.getText();
                String meaning = inputNewMeaning.getText();
                if (englishWord.length() == 0 || meaning.length() == 0)
                { hintMess.setText("您没有输入任何单词或解释");return;}
                Word word = new Word();
                UpdateWord update = new UpdateWord();
                word.setEnglishWord(englishWord);
                word.setMeaning(meaning);
                int isOK = update.updateWord(word);
                if (isOK != 0)
                    hintMess.setText("更新单词成功");
                else
                    hintMess.setText("更新失败，单词不在表里");
            }
        });
        lookWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String englishWord = inputWord.getText();
                if (englishWord.length() == 0)
                { hintMess.setText("您没有输入任何单词");return;}
                Word word = new Word();
                word.setEnglishWord(englishWord);
                QuerySingleWord query = new QuerySingleWord();
                Word result = query.queryOneWord(word);
                if (result != null) {
                    inputNewMeaning.setText(result.getMeaning());
                } else
                    hintMess.setText("单词不在表里");
            }
        });
    }

}