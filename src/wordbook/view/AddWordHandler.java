package wordbook.view;

import wordbook.data.AddWord;
import wordbook.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWordHandler implements ActionListener {
    public AddWordTab view;     //定义窗口为AddWordTab类型

    public void actionPerformed(ActionEvent e) {
        String englishWord = view.inputWord.getText();  //获取用户输入的单词
        String meaning = view.inputMeaning.getText();   //获取用户输入的解释
        if (englishWord.length() == 0 || meaning.length() == 0)     //如果用户没有输入完整，则不执行操作
        { view.hint.setText("您没有输入任何单词");return;}

        Word word = new Word();     //定义word
        AddWord addWord = new AddWord();    //定义addWord
        word.setEnglishWord(englishWord);   //设置word的单词
        word.setMeaning(meaning);           //设置word的解释

        int isOK = addWord.insertWord(word);    //定义int型isOK，或执行成功返回影响的行数，失败返回0
        if (isOK != 0)
            view.hint.setText("添加单词成功");
        else
            view.hint.setText("添加单词失败，单词已经在表里了");

    }

    public void setView(AddWordTab view) {
        this.view = view;   //为了能操作view中的数据，将传入的view赋给当前类的成员变量view
    }
}