package wordbook.view;

import javax.swing.*;

public class AddWordTab extends JPanel {
  protected JTextField inputWord;     //输入单词
  protected JTextField inputMeaning;  //输入单词的翻译
 protected JButton submit;           //提交按钮
  protected JTextField hint;
    AddWordHandler handleAddWord;  //负责处理添加单词

    AddWordTab() {
        initializer();
        registerListener();
    }

    private void initializer() {
        Box boxH;                 //行式盒
        Box boxVOne, boxVTwo;      //列式盒
        boxH = Box.createHorizontalBox();
        boxVOne = Box.createVerticalBox();
        boxVTwo = Box.createVerticalBox();
        inputWord = new JTextField(30);
        inputMeaning = new JTextField(30);
        submit = new JButton("添加单词");
        hint = new JTextField(30);
        hint.setEditable(false);
        boxVOne.add(new JLabel("单词:"));
        boxVOne.add(new JLabel("解释:"));
        boxVOne.add(new JLabel("提交:"));
        boxVOne.add(new JLabel("提示:"));
        boxVTwo.add(inputWord);
        boxVTwo.add(inputMeaning);
        boxVTwo.add(submit);
        boxVTwo.add(hint);
        boxH.add(boxVOne);
        boxH.add(Box.createHorizontalStrut(10));
        boxH.add(boxVTwo);
        add(boxH);
    }

    private void registerListener() { //注册监听器
        handleAddWord = new AddWordHandler();
        handleAddWord.setView(this);
        submit.addActionListener(handleAddWord);
    }
}