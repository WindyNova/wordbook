package cn.edu.jit.wdnv.java.wordbook.view;

import cn.edu.jit.wdnv.java.wordbook.dao.QuerySingleWord;
import cn.edu.jit.wdnv.java.wordbook.dao.UpdateWord;
import cn.edu.jit.wdnv.java.wordbook.model.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateWordHandler implements ActionListener {
    UpdateWordTab view;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.lookWord) {
            lookWord();
        } else if (e.getSource() == view.submit) {
            updateWord();
        }
    }

    private void updateWord() {
        String englishWord = view.inputWord.getText();
        String meaning = view.inputNewMeaning.getText();
        if (englishWord.length() == 0 || meaning.length() == 0)
        { view.hintMess.setText("您没有输入任何单词或解释");return;}
        Word word = new Word();
        UpdateWord update = new UpdateWord();
        word.setEnglishWord(englishWord);
        word.setMeaning(meaning);
        int isOK = update.updateWord(word);
        if (isOK != 0)
            view.hintMess.setText("更新单词成功");
        else
            view.hintMess.setText("更新失败，单词不在表里");
    }

    private void lookWord() {
        String englishWord = view.inputWord.getText();
        if (englishWord.length() == 0)
        { view.hintMess.setText("您没有输入任何单词");return;}
        Word word = new Word();
        word.setEnglishWord(englishWord);
        QuerySingleWord query = new QuerySingleWord();
        Word result = query.queryOneWord(word);
        if (result != null) {
            view.inputNewMeaning.setText(result.getMeaning());
        } else
            view.hintMess.setText("单词不在表里");
    }

    public void setView(UpdateWordTab view) {
        this.view = view;
    }
}