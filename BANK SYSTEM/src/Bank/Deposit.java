package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Deposit extends Balance {

    private JTextField textField;
    private JFrame frame;
    private Object accountNumber;
    

    public Deposit() {
        frame = new JFrame("Deposit");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // components ng balance inquiry
        JLabel instructionLabel = new JLabel("Enter your account number:");
        textField = new JTextField(10);
        JButton checkButton = new JButton("Continue");

         

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(instructionLabel);
        panel.add(textField);
        panel.add(checkButton);

        checkButtonHandler cbh = new checkButtonHandler();
        checkButton.addActionListener(cbh);

        frame.add(panel);
        frame.setVisible(true);
    }
        
    // Event handler class
    private class checkButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Switches to getAccountNumber
            try {
                getAccountNumber(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dispose();
        }
    } 
    private void getAccountNumber(ActionEvent event) throws IOException{ 

    try {
        BufferedReader br = new BufferedReader(new FileReader("NewAccount.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String fileNumber = parts[2].trim();
            if (accountNumber.equals(fileNumber)) {
                System.out.println("Account number logged in");
                showPopUp(fileNumber);
            } else {
                System.out.println("Invalid account number");
            }    
        }
            } catch (IOException e) {
                System.out.println("This is not a registered account number" +e );
            } finally{
                
            }
                
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
}



