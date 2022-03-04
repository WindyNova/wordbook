package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.AddWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWordTab extends JPanel {
    protected final JTextField inputWord;     //输入单词
    protected final JTextField inputMeaning;  //输入单词的翻译
    protected final JButton submit;           //提交按钮
    protected final JTextField hint;

    AddWordTab() { // 设置添加单词的页面布局
        Box boxH;                 //定义行式盒容器
        Box boxVOne, boxVTwo;      //定义列式盒容器
        boxH = Box.createHorizontalBox();   //创建行式盒（横向排列元素）
        boxVOne = Box.createVerticalBox();  //创建列式盒1（纵向排列元素）
        boxVTwo = Box.createVerticalBox();  //创建列式盒2（纵向排列元素）

        inputWord = new JTextField(30);     //创建文本框对象：单词，并设置文本框宽度
        inputMeaning = new JTextField(30);  //创建文本框对象：解释，并设置文本框宽度

        submit = new JButton("添加单词");   //创建按钮对象：添加单词

        hint = new JTextField(30);      //创建文本框对象：提示，并设置文本框宽度

        hint.setEditable(false);    //设置文本框对象：提示，禁止编辑

        boxVOne.add(new JLabel("单词:"));     //向列式盒1中添加标签：单词
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("解释:"));     //向列式盒1中添加标签：解释
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("提交:"));     //向列式盒1中添加标签：提交
        boxVOne.add(Box.createRigidArea(new Dimension(5,10)));
        boxVOne.add(new JLabel("提示:"));     //向列式盒1中添加标签：提示

        boxVTwo.add(inputWord);     //向列式盒2中添加文本框对象：单词
        boxVTwo.add(inputMeaning);  //向列式盒2中添加文本框对象：解释
        boxVTwo.add(submit);        //向列式盒2中添加按钮对象：添加单词
        boxVTwo.add(hint);          //向列式盒2中添加文本框对象：提示

        boxH.add(boxVOne);      //向行式盒中添加盒容器：列式盒1
        boxH.add(Box.createHorizontalStrut(10));    //向行式盒中添加盒容器：10宽度（用于设置列式盒1和列式盒2之间的间距）
        boxH.add(boxVTwo);      //向行式盒中添加盒容器：列式盒2
        add(boxH);      //向页面中添加盒容器：行式盒1


        submit.addActionListener(new ActionListener() { //侦听提交按钮的按键操作
            @Override
            public void actionPerformed(ActionEvent e) {
                submitAdd();
            }
        });
    }

    protected void submitAdd() { //提交按钮的操作
        String englishWord = inputWord.getText();  //获取用户输入的单词
        String meaning = inputMeaning.getText();   //获取用户输入的解释
        if (englishWord.length() == 0 || meaning.length() == 0)     //如果用户没有输入完整，则不执行操作
        { hint.setText("您没有输入任何单词");return;}

        Word word = new Word();     //定义word
        AddWord addWord = new AddWord();    //定义addWord
        word.setEnglishWord(englishWord);   //设置word的单词
        word.setMeaning(meaning);           //设置word的解释

        int isOK = addWord.insertWord(word);    //定义int型isOK，或执行成功返回影响的行数，失败返回0
        if (isOK != 0)
            hint.setText("添加单词成功");
        else
            hint.setText("添加单词失败，单词已经在表里了");

    }

}