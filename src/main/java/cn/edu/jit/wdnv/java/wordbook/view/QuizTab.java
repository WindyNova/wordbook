/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Fuzzbear
 * @date 2021/12/6 18:47
 */

@Component
public class QuizTab extends JPanel {
    protected final JTextField question;  //英文单词
    protected final JButton textButton;
    protected final JButton bw1;
    protected final JButton bw2;
    protected final JButton bw3;
    protected final JButton bw4;
    protected final JButton continueButton;
    protected final JTextField hint;  //提示信息
    protected String right_answer;
    final Box BoxV;

    @Autowired
    private WordMapper wordMapper;

    QuizTab() {
        BoxV = Box.createVerticalBox();
        question = new JTextField(20);
        question.setEditable(false);
        hint = new JTextField(20);
        hint.setEditable(false);
        textButton = new JButton("开始");
        bw1 = new JButton();
        bw2 = new JButton();

        bw3 = new JButton();
        bw4 = new JButton();
        continueButton = new JButton("继续");


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

        textButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOptions();
            }
        });

        bw1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clicky(e);
            }
        });
        bw2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clicky(e);
            }
        });
        bw3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clicky(e);
            }
        });
        bw4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clicky(e);
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clicky(e);
            }
        });
    }

    public synchronized void Clicky(ActionEvent e) {
        //  System.out.println("当前按下的是："+e.getActionCommand());

        String answer = e.getActionCommand(); //获取ActionCommand


        if (answer.equals("开始")) {
            init();
            setOptions();
        } else {
            if (answer.equals(right_answer)) {

                setOptions();


//                }
            } else {


                hint.setText("回答错误，正确答案为：" + right_answer);
                hint.setVisible(true);
                continueButton.setVisible(true);
                if (continueButton.getModel().isArmed()) {
                    setOptions();
                }

            }
            repaint();
        }
    }


    private void setOptions() {

        Word[] result = getChoices();

        int index = (int) (Math.random() * 4);

        question.setText(result[index].getWord());   // 设置题目
        bw1.setText(result[0].getMeaning());
        bw2.setText(result[1].getMeaning());
        bw3.setText(result[2].getMeaning());
        bw4.setText(result[3].getMeaning());
        hint.setText(null);
        continueButton.setVisible(false);
        hint.setVisible(false);

        right_answer = result[index].getMeaning();

    }

    public Word[] getChoices() {

        Word[] word = new Word[0];
        try {
            ResultSet rs = (ResultSet) wordMapper.getQuiz();
            rs.last();  //将游标移到最后
            int recordAmount = rs.getRow();  //结果集中的全部记录条数
            word = new Word[recordAmount];
            for (int i = 0; i < word.length; i++) {
                word[i] = new Word();
            }
            rs.beforeFirst();   //将游标移到首部
            int i = 0;
            while (rs.next()) {
                word[i].setWord(rs.getString(1));
                word[i].setMeaning(rs.getString(2));
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return word;
    }


    private void init() {
        textButton.setVisible(false);
        bw1.setVisible(true);
        bw2.setVisible(true);
        bw3.setVisible(true);
        bw4.setVisible(true);


    }
}