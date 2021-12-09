package wordbook.view;

import javax.swing.*;
import java.awt.*;

public class UpdateWordTab extends JPanel {
    JTextField inputWord;        //输入要更新的单词
    JTextField inputNewMeaning;  //输入单词的新解释
    JButton lookWord;            //提交查看
    JButton submit;              //提交更新按钮
    JTextField hintMess;
    UpdateWordHandler handleUpdateWord;  //负责处理更新单词

    UpdateWordTab() {
        initView();
        registerListener();
    }

    private void initView() {
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
    }

    private void registerListener() {
        handleUpdateWord = new UpdateWordHandler();
        handleUpdateWord.setView(this);
        submit.addActionListener(handleUpdateWord);
        lookWord.addActionListener(handleUpdateWord);
    }
}