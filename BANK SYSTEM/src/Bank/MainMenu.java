package Bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    MainMenu() {
        super("Personal Bank Account");
        this.setLayout(new FlowLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
    
        //panel 1
        JLabel label1 = new JLabel("Welcome to NU Bank!", SwingConstants.CENTER);
        label1.setFont(new Font("Consolas", Font.BOLD, 25));

        //panel 2
        JButton login = new JButton();
        JButton register = new JButton();

        login.setText("LOG IN");
        login.setFont(new Font("Consolas", Font.BOLD, 18));
        register.setText("REGISTER");
        register.setFont(new Font("Consolas", Font.BOLD, 18));
        panel1.setLayout(new GridLayout(1,1));
        
        panel1.add(label1);
        panel2.add(login);
        panel2.add(register);

        LoginHandler loginHandler = new LoginHandler();
        RegisterHandler registerHandler = new RegisterHandler();
        login.addActionListener(loginHandler);
        register.addActionListener(registerHandler);

        // this.add(label);
        this.add(panel1);
        this.add(panel2);
        
    }

    // Event handler class
    private class LoginHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Switches to login menu
            new LoginForm();

            // Closes main menu
            dispose();
        }
    }

    private class RegisterHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Switches to Bank system method register
            new RegisterForm();

            // Closes main menu
            dispose();
        }
    }
}