/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.GetChoices;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Fuzzbear
 * @date 2021/12/7 11:52
 */
public class QuizHandler implements ActionListener {
    QuizTab view;
    String right_answer;

    public synchronized void actionPerformed(ActionEvent e) {
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


                view.hint.setText("回答错误，正确答案为：" + right_answer);
                view.hint.setVisible(true);
                view.continueButton.setVisible(true);
                if(view.continueButton.getModel().isArmed()) {
                    setOptions();
                }

            }
            view.repaint();
        }
    }


    private void setOptions() {
        GetChoices choices = new GetChoices();
        Word[] result = choices.getChoices();

        int index = (int) (Math.random() * 4);

        view.question.setText(result[index].getEnglishWord());   // 设置题目
        view.bw1.setText(result[0].getMeaning());
        view.bw2.setText(result[1].getMeaning());
        view.bw3.setText(result[2].getMeaning());
        view.bw4.setText(result[3].getMeaning());
        view.hint.setText(null);
        view.continueButton.setVisible(false);
        view.hint.setVisible(false);

        right_answer = result[index].getMeaning();

    }


    private void init() {
        view.textButton.setVisible(false);
        view.bw1.setVisible(true);
        view.bw2.setVisible(true);
        view.bw3.setVisible(true);
        view.bw4.setVisible(true);


    }

    public void setView(QuizTab view) {
        this.view = view;
    }
}