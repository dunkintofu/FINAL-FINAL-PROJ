package Bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Transaction extends MainMenu implements ActionListener{
    //containers
    int initialDeposit = 500;
    JFrame frame = new JFrame("Registration Form");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();

        //Panel 1 contents
        JLabel label1 = new JLabel("Welcome to NU Bank!", SwingConstants.CENTER);

        //panel 2
        JButton balanceInquiry = new JButton();
        //panel 3
        JButton deposit = new JButton();
        //panel 4
        JButton withdrawal = new JButton();

    
    public Transaction(){

        frame.setLayout(new GridLayout(4, 1));
        frame.setSize(700, 420);
        frame.setLocation(600,350);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        label1.setFont(new Font("Consolas", Font.BOLD, 25));

        balanceInquiry.setText("Balance Inquiry");
        balanceInquiry.setFont(new Font("Consolas", Font.BOLD, 18));
        
        deposit.setText("Deposit");
        deposit.setFont(new Font("Consolas", Font.BOLD, 18));
        
        withdrawal.setText("Withdrawal");
        withdrawal.setFont(new Font("Consolas", Font.BOLD, 18));

        panel1.setLayout(new GridLayout(1,10));
        panel1.add(label1);
            panel2.add(balanceInquiry);
                    panel3.add(deposit);
                        panel4.add(withdrawal);
       
            panel1.add(label1);
                panel2.add(balanceInquiry);
                    panel3.add(deposit);
                        panel4.add(withdrawal);

        panel2.setPreferredSize(new Dimension(100, 50));
            panel2.setMaximumSize(new Dimension(100, 50)); 
                frame.getContentPane().add(panel2);

        panel3.setPreferredSize(new Dimension(100, 50));
            panel3.setMaximumSize(new Dimension(100, 50)); 
                frame.getContentPane().add(panel3);

        panel4.setPreferredSize(new Dimension(100, 50));
            panel4.setMaximumSize(new Dimension(100, 50)); 
                frame.getContentPane().add(panel4);

        balanceInquiry.addActionListener(this);
        deposit.addActionListener(this);
        withdrawal.addActionListener(this);

        frame.add(panel1);
            frame.add(panel2);
                frame.add(panel3);
                    frame.add(panel4);

        BalanceHandler bHandler = new BalanceHandler();
        DepositHandler dHandler = new DepositHandler();
        WithdrawalHandler whandler = new WithdrawalHandler();
        balanceInquiry.addActionListener(bHandler);
        deposit.addActionListener(dHandler);
        withdrawal.addActionListener(whandler);
        
        Font f1 = new Font(Font.SERIF, Font.BOLD, 70);
        frame.setFont(f1);

        frame.pack();
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    // Event handler class
    private class BalanceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Switches to Balance menu
            new Balance();

        }
    }

    private class DepositHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            //Switches to Deposit form
            new Deposit();

        }
    }

    private class WithdrawalHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            // Switches to Withdrawal form
            new Withdrawal();

        }
    }

    public void setVisible(boolean b) {
    }
}
