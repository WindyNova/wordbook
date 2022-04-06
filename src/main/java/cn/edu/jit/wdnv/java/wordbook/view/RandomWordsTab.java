package cn.edu.jit.wdnv.java.wordbook.view;
import cn.edu.jit.wdnv.java.wordbook.mapper.WordMapper;
import cn.edu.jit.wdnv.java.wordbook.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class RandomWordsTab extends JPanel {
    final JTextField inputQueryNumber;//输入要查询的单词数目
    final JButton submit;            //查询按钮
    final JTextArea showWord;       //显示查询结果

    @Autowired
    WordMapper wordMapper;

    RandomWordsTab() {
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
                GetRandomWords();
            }
        });
    }

    protected void GetRandomWords() {
        showWord.setText("");
        String n = inputQueryNumber.getText().trim();
        if (n.length() == 0) {
            showWord.setText("您没有输入任何数据");
            return;
        }
        try {
            List<Word> words = wordMapper.getRandomWord(Integer.parseInt(n));
            showWord.setText(String.valueOf(words));
        } catch (NumberFormatException exp) {
            showWord.setText("请输入正整数");
        }


    }
}