package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.RandomlyQuery;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomlyQueryTab extends JPanel {
    JTextField inputQueryNumber;//输入要查询的单词数目
    JButton submit;            //查询按钮
    JTextArea showWord;       //显示查询结果

    RandomlyQueryTab() {
        setLayout(new BorderLayout());
        JPanel pNorth = new JPanel();
        inputQueryNumber = new JTextField(4);
        showWord = new JTextArea();
        showWord.setFont(new Font("宋体", Font.BOLD, 20));
        submit = new JButton("查询");
        pNorth.add(new JLabel("输入随机查询的数目:"));
        pNorth.add(inputQueryNumber);
        pNorth.add(submit);
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(showWord), BorderLayout.CENTER);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
RandomlyQueryTab();
            }
        });
    }
protected void RandomlyQueryTab() {
    showWord.setText("");
    String n = inputQueryNumber.getText().trim();
    if (n.length() == 0) {
        showWord.setText("您没有输入任何数据");
        return;
    }
    int count = 0;
    try {
        count = Integer.parseInt(n);
    } catch (NumberFormatException exp) {
        showWord.setText("请输入正整数");
    }
    RandomlyQuery random = new RandomlyQuery();
    random.setCount(count); //随机抽取count个单词
    Word[] result = random.randomQueryWord();
    for (int i = 0; i < result.length; i++) {
        int m = i + 1;
        showWord.append(m + "." + result[i].getEnglishWord());
        showWord.append("   " + result[i].getMeaning());
        showWord.append("\n");
    }

}
}