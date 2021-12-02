package wordbook.view;

import wordbook.data.QueryAllWord;
import wordbook.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryAllWordHandler implements ActionListener {
    QueryAllWordTab view;

    public void actionPerformed(ActionEvent e) {
        view.showWord.setText("");
        QueryAllWord query = new QueryAllWord();
        Word[] result = query.queryAllWord();
        for (int i = 0; i < result.length; i++) {
            int m = i + 1;
            view.showWord.append(m + "." + result[i].getEnglishWord());
            view.showWord.append("   " + result[i].getMeaning());
            view.showWord.append("\n");
        }
    }

    public void setView(QueryAllWordTab view) {
        this.view = view;
    }
}