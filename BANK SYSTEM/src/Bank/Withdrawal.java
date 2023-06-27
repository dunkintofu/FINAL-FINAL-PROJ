package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Withdrawal extends Balance {

    private JTextField textField;
    private JFrame frame;


    public Withdrawal() {
        frame = new JFrame("Withdrawal");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // components ng Withdrawal menu 
        JLabel instructionLabel = new JLabel("Enter your account number: ");
        textField = new JTextField(10);
        JButton checkButton = new JButton("Continue");

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = textField.getText();

                double balance = getBalance(accountNumber);

                String message;
                if (balance >= 0) {
                    message = "Your balance is: " + balance;
                } else {
                    message = "This is not a registered account number";
                }

                // call for pop up 
                showPopUp(message);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(instructionLabel);
        panel.add(textField);
        panel.add(checkButton);

        frame.add(panel);

        //call to make the panel visible
        frame.setVisible(true);
    }

    private double getBalance(String accountNumber) {

    try {
        BufferedReader br = new BufferedReader(new FileReader("NewAccount.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String fileNumber = parts[2].trim();
            if (accountNumber.equals(fileNumber)) {
                return runningBalance;
            } else {
                return -1;
            }    
        }
            } catch (IOException e) {
                System.out.println("Error reading from File: " +e );
            } finally{}
                return 0;
        }

    // hindi ko mapantay layout dito, pinagtatabi ko yung ok button pati main menu button pota ayaw mag work

    private void showPopUp(String message) {
        // Close the frame
        frame.dispose();

        JButton mainMenuButton = new JButton("Main Menu");

        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // call for the main menu panel 
                new MainMenu();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4 ));
        panel.add(new JLabel(message));
        panel.add(mainMenuButton);

        // Show the pop-up with main menu button
        JOptionPane.showMessageDialog(null, panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Balance();
            }
        });
    }
}



