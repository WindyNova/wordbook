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
    protected JTextField question;

    protected JButton refresh,bw1,bw2,bw3,bw4;
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
        refresh = new JButton("刷新");
        bw1 = new JButton();
        bw2 = new JButton();
        bw3 = new JButton();
        bw4 = new JButton();
        BoxV.add(new JLabel("中译英"));
        BoxV.add(question);
        BoxV.add(bw1);
        BoxV.add(bw2);
        BoxV.add(bw3);
        BoxV.add(bw4);


        add(BoxV);
    }

    private void registerListener(){
        handleMultipleChoice = new MultipleChoiceHandler();
        handleMultipleChoice.setView(this);
        refresh.addActionListener(handleMultipleChoice);
        bw1.addActionListener(handleMultipleChoice);
        bw2.addActionListener(handleMultipleChoice);
        bw3.addActionListener(handleMultipleChoice);
        bw4.addActionListener(handleMultipleChoice);

    }

}