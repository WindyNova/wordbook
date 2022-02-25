package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.DelWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelWordHandler implements ActionListener {
    DelWordTab view;

    public void actionPerformed(ActionEvent e) {
        String englishWord = view.inputWord.getText();
        if (englishWord.length() == 0)
        { view.hintMess.setText("您没有输入任何单词");return;}
        Word word = new Word();
        DelWord del = new DelWord();
        word.setEnglishWord(englishWord);
        int isOK = del.delWord(word);
        if (isOK != 0)
            view.hintMess.setText("删除单词成功");
        else
            view.hintMess.setText("删除失败，单词不在表里");
    }

    public void setView(DelWordTab view) {
        this.view = view;
    }
}