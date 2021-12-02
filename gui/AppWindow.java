package ch3.gui;

import ch3.data.CreateDatabaseAndTable;
import ch3.view.IntegrationView;

public class AppWindow {
    public static void main(String[] args) {
        new CreateDatabaseAndTable();
        new IntegrationView();
    }
}