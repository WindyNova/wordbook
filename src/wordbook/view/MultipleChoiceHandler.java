/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package wordbook.view;

import wordbook.data.GetChoices;
import wordbook.data.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Fuzzbear
 * @date 2021/12/7 11:52
 */
public class MultipleChoiceHandler implements ActionListener {
    MultipleChoiceTab view;
    String right_answer;
    public synchronized void actionPerformed(ActionEvent e){
//        System.out.println("当前按下的是："+e.getActionCommand());

        String answer = e.getActionCommand();



        if(answer.equals("开始")){
            view.bw2.setVisible(true);
            view.bw3.setVisible(true);
            view.bw4.setVisible(true);
            view.hint.setVisible(true);
        }else{
            System.out.println("休眠之前");
            if(answer.equals(right_answer)){

                view.hint.setText("回答正确");
            }else{
                view.hint.setText("回答错误，正确答案为："+right_answer);
            }
            view.repaint();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("休眠之后");
        }

        GetChoices choices = new GetChoices();
        Word[] result = choices.getChoices();

        int index = (int)(Math.random()*4);

        // 设置下一题
        view.question.setText(result[index].getEnglishWord());
        view.bw1.setText(result[0].getMeaning());
        view.bw2.setText(result[1].getMeaning());
        view.bw3.setText(result[2].getMeaning());
        view.bw4.setText(result[3].getMeaning());


        right_answer = result[index].getMeaning();

    }

    public void setView(MultipleChoiceTab view){
        this.view = view;
    }
}