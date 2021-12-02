package wordbook.view;

import wordbook.data.QueryAllWord;
import wordbook.data.Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleQueryAllWord implements ActionListener {
    QueryAllWordView view;

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

    public void setView(QueryAllWordView view) {
        this.view = view;
    }
}