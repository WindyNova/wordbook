package wordbook.gui;

import wordbook.data.CreateDatabaseAndTable;
import wordbook.view.IntegrationView;

public class AppWindow {
    public static void main(String[] args) {
        new CreateDatabaseAndTable();
        new IntegrationView();
    }
}