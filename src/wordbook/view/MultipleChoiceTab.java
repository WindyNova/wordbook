/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package wordbook.view;

import wordbook.data.Word;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @author Fuzzbear
 * @date 2021/12/6 18:47
 */
public class MultipleChoiceTab extends JPanel {
    protected JTextField question;  //英文单词

    protected JButton refresh,bw1,bw2,bw3,bw4;
    protected JTextField hint;  //提示信息
    Box BoxV;
    protected MultipleChoiceHandler handleMultipleChoice;

    MultipleChoiceTab(){
        initializer();  //调用布局方法
        registerListener(); //注册监听器
    }

    private void initializer(){

        BoxV = Box.createVerticalBox();
        question = new JTextField(20);
        question.setEditable(false);
        hint = new JTextField(20);
        hint.setEditable(false);
        hint.setVisible(false);

        bw1 = new JButton("开始");
        bw2 = new JButton();
        bw2.setVisible(false);
        bw3 = new JButton();
        bw3.setVisible(false);
        bw4 = new JButton();
        bw4.setVisible(false);

        BoxV.add(new JLabel("中译英"));
        BoxV.add(question);
        BoxV.add(bw1);
        BoxV.add(bw2);
        BoxV.add(bw3);
        BoxV.add(bw4);
        BoxV.add(hint);


        add(BoxV);
    }

    private void registerListener(){
        handleMultipleChoice = new MultipleChoiceHandler();
        handleMultipleChoice.setView(this);

        bw1.addActionListener(handleMultipleChoice);
        bw2.addActionListener(handleMultipleChoice);
        bw3.addActionListener(handleMultipleChoice);
        bw4.addActionListener(handleMultipleChoice);

    }

}