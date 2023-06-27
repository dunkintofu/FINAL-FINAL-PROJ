package Bank;

import java.awt.GridLayout;

public class App {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();

        mainMenu.setDefaultCloseOperation(mainMenu.EXIT_ON_CLOSE);
        mainMenu.setLayout(new GridLayout(2,0));
        mainMenu.setSize(420, 420);
        mainMenu.setVisible(true);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setResizable(true);

    }
}
