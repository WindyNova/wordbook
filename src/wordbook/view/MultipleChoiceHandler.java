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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Fuzzbear
 * @date 2021/12/7 11:52
 */
public class MultipleChoiceHandler implements ActionListener {
    MultipleChoiceTab view;
    public void actionPerformed(ActionEvent e){
        System.out.println(111);
        GetChoices choices = new GetChoices();
        Word[] result = choices.getChoices();
        for(int i=0; i<result.length;i++){
            System.out.println(result[i].getMeaning());
        }

        view.question.setText(result[(int)(Math.random()*4+1)].getEnglishWord());
        view.bw1.setText(result[0].getMeaning());
        view.bw2.setText(result[1].getMeaning());
        view.bw3.setText(result[2].getMeaning());
        view.bw4.setText(result[3].getMeaning());
    }

    public void setView(MultipleChoiceTab view){
        this.view = view;
    }
}