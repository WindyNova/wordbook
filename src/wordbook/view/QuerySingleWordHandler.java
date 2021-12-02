package wordbook.view;

import wordbook.data.QuerySingleWord;
import wordbook.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuerySingleWordHandler implements ActionListener {
    QuerySingleWordTab view;

    public void actionPerformed(ActionEvent e) {
        String englishWord = view.inputWord.getText();
        if (englishWord.length() == 0)
            return;
        Word word = new Word();
        word.setEnglishWord(englishWord);
        QuerySingleWord query = new QuerySingleWord();
        Word result = query.queryOneWord(word);
        if (result == null) return;
        view.showWord.append(" " + result.getEnglishWord());
        view.showWord.append("   " + result.getMeaning());
        view.showWord.append("\n");
    }

    public void setView(QuerySingleWordTab view) {
        this.view = view;
    }
}