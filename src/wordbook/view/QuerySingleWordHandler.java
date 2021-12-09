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
        { view.showWord.setText("您没有输入任何单词\n");return;}
        Word word = new Word();
        word.setEnglishWord(englishWord);
        QuerySingleWord query = new QuerySingleWord();
        Word result = query.queryOneWord(word);
        if (result == null) {
            view.showWord.setText("本单词簿中不存在您输出的单词\n");
            return;
        }
        if(view.showWord.getText().equals("您没有输入任何单词\n")
        || view.showWord.getText().equals("本单词簿中不存在您输出的单词\n")){
            view.showWord.setText(null);
        }
            view.showWord.append(" " + result.getEnglishWord());
            view.showWord.append("   " + result.getMeaning());
            view.showWord.append("\n");
        }


    public void setView(QuerySingleWordTab view) {
        this.view = view;
    }
}