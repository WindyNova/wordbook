package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.RandomlyQuery;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomlyQueryHandler implements ActionListener {
    RandomlyQueryTab view;

    public void actionPerformed(ActionEvent e) {
        view.showWord.setText("");
        String n = view.inputQueryNumber.getText().trim();
        if (n.length() == 0)
        { view.showWord.setText("您没有输入任何数据");return;}
        int count = 0;
        try {
            count = Integer.parseInt(n);
        } catch (NumberFormatException exp) {
            view.showWord.setText("请输入正整数");
        }
        RandomlyQuery random = new RandomlyQuery();
        random.setCount(count); //随机抽取count个单词
        Word[] result = random.randomQueryWord();
        for (int i = 0; i < result.length; i++) {
            int m = i + 1;
            view.showWord.append(m + "." + result[i].getEnglishWord());
            view.showWord.append("   " + result[i].getMeaning());
            view.showWord.append("\n");
        }
    }

    public void setView(RandomlyQueryTab view) {
        this.view = view;
    }
}