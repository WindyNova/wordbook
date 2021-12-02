package wordbook.view;

import wordbook.data.AddWord;
import wordbook.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWordHandler implements ActionListener {
    public AddWordTab view;

    public void actionPerformed(ActionEvent e) {
        String englishWord = view.inputWord.getText();
        String meaning = view.inputMeaning.getText();
        if (englishWord.length() == 0 || meaning.length() == 0)
            return;
        Word word = new Word();
        AddWord addWord = new AddWord();
        word.setEnglishWord(englishWord);
        word.setMeaning(meaning);
        int isOK = addWord.insertWord(word);
        if (isOK != 0)
            view.hint.setText("添加单词成功");
        else
            view.hint.setText("添加单词失败，单词已经在表里了");
    }

    public void setView(AddWordTab view) {
        this.view = view;
    }
}