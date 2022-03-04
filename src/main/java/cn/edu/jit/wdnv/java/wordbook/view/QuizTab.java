/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package cn.edu.jit.wdnv.java.wordbook.view;

import javax.swing.*;

/**
 * @author Fuzzbear
 * @date 2021/12/6 18:47
 */
public class QuizTab extends JPanel {
    protected final JTextField question;  //英文单词

    protected final JButton textButton;
    protected final JButton bw1;
    protected final JButton bw2;
    protected final JButton bw3;
    protected final JButton bw4;
    protected final JButton continueButton;
    protected final JTextField hint;  //提示信息
    final Box BoxV;
    protected QuizHandler handleMultipleChoice;

    QuizTab(){
        BoxV = Box.createVerticalBox();
        question = new JTextField(20);
        question.setEditable(false);
        hint = new JTextField(20);
        hint.setEditable(false);
        textButton =new JButton("开始");
        bw1 = new JButton();
        bw2 = new JButton();

        bw3 = new JButton();
        bw4 = new JButton();
        continueButton =new JButton("继续");


        hint.setVisible(false);
        bw1.setVisible(false);
        bw2.setVisible(false);
        bw3.setVisible(false);
        bw4.setVisible(false);
        continueButton.setVisible(false);


        BoxV.add(new JLabel("中译英"));
        BoxV.add(question);
        BoxV.add(textButton);
        BoxV.add(bw1);
        BoxV.add(bw2);
        BoxV.add(bw3);
        BoxV.add(bw4);
        BoxV.add(hint);
        BoxV.add(continueButton);


        add(BoxV);
        registerListener(); //注册监听器
    }

    private void registerListener(){
        handleMultipleChoice = new QuizHandler();
        handleMultipleChoice.setView(this);
        textButton.addActionListener(handleMultipleChoice);
        bw1.addActionListener(handleMultipleChoice);
        bw2.addActionListener(handleMultipleChoice);
        bw3.addActionListener(handleMultipleChoice);
        bw4.addActionListener(handleMultipleChoice);
        continueButton.addActionListener(handleMultipleChoice);
    }

}