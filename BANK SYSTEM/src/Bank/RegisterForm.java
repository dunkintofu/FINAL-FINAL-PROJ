package Bank;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class RegisterForm extends MainMenu implements ActionListener{

    Random random = new Random();
    String accNumber = "500" + random.nextInt(900) + 1000;
    int initialDeposit = 500;
    int depositAmount;
    int withdrawalAmount;
    //for bal inquiry - general balance ng account
    int runningBalance = 500 + depositAmount - withdrawalAmount;
    //int variable for withdrawal lang yung remaining balance
    int remainingBalance = runningBalance - withdrawalAmount;

    //containers
    
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
    
    //Panel 2 contents
    JLabel FN = new JLabel("First Name: ");
    JTextField txtFN = new JTextField(20);
    JLabel MN = new JLabel("Middle Name: ");
    JTextField txtMN = new JTextField(20);
    JLabel LN = new JLabel("Last Name:");
    JTextField txtLN = new JTextField(20);
    
    //Panel 3 contents
    JLabel CN = new JLabel("Contact No.: ");
    JTextField txtCN = new JTextField(20);
    
    JLabel Gender = new JLabel("                    Gender: ");
    ButtonGroup genderGrp = new ButtonGroup();
    JRadioButton rbtMale = new JRadioButton("Male", true);
    JRadioButton rbtFemale = new JRadioButton("Female");
    JRadioButton rbtOther = new JRadioButton("Other");

    //Panel 4 contents 
    JLabel Address = new JLabel("Address:");
    JLabel BD = new JLabel("Birthdate: ");
    JTextField txtAddress = new JTextField(40);
    JTextField txtBD = new JTextField(20);

    //Panel 5 contents
    JLabel FathersName = new JLabel("Father's Name: ");
    JLabel MothersName = new JLabel("Mother's Name: ");
    
    JTextField txtFathersName = new JTextField(20);
    JTextField txtMothersName = new JTextField(20);

    //Panel 6 contents
    JLabel username = new JLabel("Username: ");
    JLabel password = new JLabel("          Password: ");

    JTextField txtusername = new JTextField(20);
    JTextField txtpassword = new JTextField(20);

    //Panel 7 content
    JButton btnCont = new JButton("Continue >>");
    
    public RegisterForm(){
       
        frame.setLayout(new GridLayout(7, 7));
        frame.setSize(900, 420);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       
        Toolkit tk = frame.getToolkit();
        Dimension size = tk.getScreenSize();
       
        frame.setLocation(size.width/2 - frame.getWidth()/2, size.height/2 - frame.getHeight()/2);
        Font f1 = new Font(Font.SERIF, Font.BOLD, 70);
        frame.setFont(f1);
       
        panel1.setLayout(new GridLayout(1,1));
            panel1.add(label1);

        panel2.add(FN);
            panel2.add(txtFN);
                panel2.add(MN);
                    panel2.add(txtMN);
                        panel2.add(LN);
                             panel2.add(txtLN);

        genderGrp.add(rbtMale);
            genderGrp.add(rbtFemale);
                genderGrp.add(rbtOther);

        Box b1 = Box.createVerticalBox();
        b1.add(rbtMale);
            b1.add(rbtFemale);
                b1.add(rbtOther);

        panel3.setLayout(new FlowLayout());
            panel3.add(CN);
                panel3.add(txtCN);
                    panel3.add(Gender);
                        panel3.add(b1);

        panel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel3.setPreferredSize(new Dimension(100, 75));
        panel3.setMaximumSize(new Dimension(100, 75)); 
        frame.getContentPane().add(panel3);

        panel4.add(BD);
            panel4.add(txtBD);
                panel4.add(Address);
                    panel4.add(txtAddress);

        panel4.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel4.setPreferredSize(new Dimension(100, 50));
        panel4.setMaximumSize(new Dimension(100, 50)); 
        frame.getContentPane().add(panel4);

        panel5.add(FathersName);
            panel5.add(txtFathersName);
                panel5.add(MothersName);
                    panel5.add(txtMothersName);

        panel6.add(username);
            panel6.add(txtusername);
                panel6.add(password);
                    panel6.add(txtpassword);
                    
        panel7.add(btnCont);
            btnCont.addActionListener(this);

        frame.add(panel1);
            frame.add(panel2);
                frame.add(panel3);
                    frame.add(panel4);
                        frame.add(panel5);
                            frame.add(panel6);
                                frame.add(panel7);

        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {

       try{

        // saves the acc deets into NewAccount.txt
        printTransaction();

        // calls the login form to pop up
        new LoginForm();
        
       }
       catch(Exception ex){
        System.out.println("There was an error in making the transaction.");
       }
    }

    public void printTransaction() throws IOException{
        File transact = new File("NewAccount.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(transact));

        try{
        //same method accNumber para di different yung display sa file written accNumber
         JOptionPane.showMessageDialog(null, "Bank account created\nYour account number is: " + accNumber, "Account created", JOptionPane.INFORMATION_MESSAGE);
         // Write username, password, and account number to the file
        bw.write(txtusername.getText() + "," + txtpassword.getText() + "," + accNumber + "," + initialDeposit);
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            bw.flush();
            bw.close();
        }
    } 
}
