package Bank;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LoginForm extends MainMenu implements ActionListener{
    
    //containers
    int initialDeposit = 500;
    JFrame frame = new JFrame("Login Form");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    //Panel 1 contents
    JLabel label1 = new JLabel("Welcome to NU Bank!", SwingConstants.CENTER);
    
    //Panel 2 contents
    JLabel username = new JLabel("Username: ");
    JTextField txtusername = new JTextField(20);
    JLabel password = new JLabel("Password: ");
    JPasswordField txtpassword = new JPasswordField();

    //Panel 3 content
    JButton btnCont = new JButton("Continue >>");
    
    public LoginForm(){
       
        frame.setLayout(new GridLayout(3, 10));
        frame.setSize(1000, 200);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       
        Toolkit tk = frame.getToolkit();
        Dimension size = tk.getScreenSize();
       
        frame.setLocation(size.width/2 - frame.getWidth()/2, size.height/2 - frame.getHeight()/2);
        Font f1 = new Font(Font.SERIF, Font.BOLD, 70);
        frame.setFont(f1);
       
        panel1.setLayout(new GridLayout(1,1));
            panel1.add(label1);

        panel2.setLayout(new GridLayout(2,10));
        panel2.add(username);
            panel2.add(txtusername);
                panel2.add(password);
                    panel2.add(txtpassword);
                    
        panel3.add(btnCont);
            btnCont.addActionListener(this);

        frame.add(panel1);
            frame.add(panel2);
                frame.add(panel3);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
        frame.setVisible(false);
        btnContPerformed(e);
       }
       catch(Exception ex){
        System.out.println("Error in printing the Transaction.");
       }
    }

    private void btnContPerformed (ActionEvent event) {
    
    String username = txtusername.getText().trim();
    String password = txtpassword.getText().trim();

    try {
        BufferedReader br = new BufferedReader(new FileReader("NewAccount.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String fileUsername = parts[0].trim();
            String filePassword = parts[1].trim();
            if (username.equals(fileUsername) && password.equals(filePassword)) {
                // Login successful, show a message and perform some action
                JOptionPane.showMessageDialog(this, "Login successful!");
                //new window for transactions
                Transaction TA = new Transaction();
                TA.setVisible(true);
                this.setVisible(false);
                break;
            }
        }
        if (line == null) {
            // Login failed, show an error message
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
        br.close();
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

    }
}
