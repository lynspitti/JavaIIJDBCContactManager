package dk.mercantec.javaii;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        DBHelper sqldatabase = new DBHelper();
        sqldatabase.CheckDataBase();

        UI ui = new UI(new Contacts());
        while (true) {
            ui.MainMenu().Show();
        }
    }
}
