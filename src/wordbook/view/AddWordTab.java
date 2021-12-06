package wordbook.view;

import javax.swing.*;

public class AddWordTab extends JPanel {
  protected JTextField inputWord;     //输入单词
  protected JTextField inputMeaning;  //输入单词的翻译
 protected JButton submit;           //提交按钮
  protected JTextField hint;
    AddWordHandler handleAddWord;  //负责处理添加单词

    AddWordTab() {
        initializer();  //调用布局方法
        registerListener(); //注册监听器
    }

    // 设置添加单词的页面布局
    private void initializer() {
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
        boxVOne.add(new JLabel("解释:"));     //向列式盒1中添加标签：解释
        boxVOne.add(new JLabel("提交:"));     //向列式盒1中添加标签：提交
        boxVOne.add(new JLabel("提示:"));     //向列式盒1中添加标签：提示

        boxVTwo.add(inputWord);     //向列式盒2中添加文本框对象：单词
        boxVTwo.add(inputMeaning);  //向列式盒2中添加文本框对象：解释
        boxVTwo.add(submit);        //向列式盒2中添加按钮对象：添加单词
        boxVTwo.add(hint);          //向列式盒2中添加文本框对象：提示

        boxH.add(boxVOne);      //向行式盒中添加盒容器：列式盒1
        boxH.add(Box.createHorizontalStrut(10));    //向行式盒中添加盒容器：10宽度（用于设置列式盒1和列式盒2之间的间距）
        boxH.add(boxVTwo);      //向行式盒中添加盒容器：列式盒2
        add(boxH);      //向页面中添加盒容器：行式盒1
    }

    //注册监听器
    private void registerListener() {
        handleAddWord = new AddWordHandler();   //创建处理器对象：添加
        handleAddWord.setView(this);
        submit.addActionListener(handleAddWord);    //为按钮添加监听器
    }
}