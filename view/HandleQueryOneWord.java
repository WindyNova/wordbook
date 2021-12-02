package ch3.view;

import ch3.data.QueryOneWord;
import ch3.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleQueryOneWord implements ActionListener {
    QueryOneWordView view;

    public void actionPerformed(ActionEvent e) {
        String englishWord = view.inputWord.getText();
        if (englishWord.length() == 0)
            return;
        Word word = new Word();
        word.setEnglishWord(englishWord);
        QueryOneWord query = new QueryOneWord();
        Word result = query.queryOneWord(word);
        if (result == null) return;
        view.showWord.append(" " + result.getEnglishWord());
        view.showWord.append("   " + result.getMeaning());
        view.showWord.append("\n");
    }

    public void setView(QueryOneWordView view) {
        this.view = view;
    }
}