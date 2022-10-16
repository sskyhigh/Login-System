import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Register extends HashMap implements ActionListener {
    private final JFrame frame = new JFrame("Deep Web Registration");
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton registerButton = new JButton("Register");
    private JButton Login = new JButton("Login");
    private JLabel userLabel = new JLabel("Username: ");
    private JLabel passwordTitle = new JLabel("Password: ");
    private JCheckBox checkBox = new JCheckBox("Accept terms and conditions");
    private JLabel textHolder = new JLabel();
    private JButton terms = new JButton("Terms");
    private JButton reset = new JButton("Reset");
    private String userData;
    private String userPass;
    private HashMap<String, String> information;
    private ImageIcon image;
    private JLabel backGround;

    public Register() throws IOException {

        image = new ImageIcon(getClass().getResource("hacker.png"));
        backGround = new JLabel(image);
        frame.add(backGround);
        
        frame.setSize(450, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // positioning the buttons
        userLabel.setBounds(50, 80, 100, 25);
        passwordTitle.setBounds(50, 130, 100, 25);
        userField.setBounds(125, 80, 200, 25);
        passwordField.setBounds(125, 130, 200, 25);
        registerButton.setBounds(125, 220, 90, 25);
        Login.setBounds(235, 220, 90, 25);

        checkBox.setSize(195, 20);
        checkBox.setLocation(126, 175);
        checkBox.setFocusable(false);
        checkBox.setSelected(true);
        reset.setBounds(235, 270, 90, 25);
        reset.addActionListener(this);

        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        passwordField.addActionListener(this);

        //colors:
        userLabel.setForeground(Color.green);
        passwordTitle.setForeground(Color.orange);
        registerButton.setBackground(Color.ORANGE);
        Login.setBackground(Color.ORANGE);
        terms.setBackground(Color.ORANGE);
        reset.setBackground(Color.ORANGE);
        checkBox.setBackground(Color.ORANGE);
        userField.setBackground(Color.orange);
        passwordField.setBackground(Color.orange);

        terms.setBounds(125, 270, 90, 25);
        terms.addActionListener(this);

        Login.setFocusable(false);
        Login.addActionListener(this);

        frame.add(reset);
        frame.add(terms);
        frame.add(checkBox);
        frame.add(textHolder);
        frame.add(userField);
        frame.add(passwordField);
        frame.add(passwordTitle);
        frame.add(userLabel);
        frame.add(registerButton);
        frame.add(Login);
        frame.add(backGround);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!checkBox.isSelected()) {
            JOptionPane.showMessageDialog(null, "Please agree to the terms and conditions");
        } else {
            if (e.getSource() == registerButton) {
                try {
                    ID_Pass pass = new ID_Pass();
                    userData = userField.getText();
                    userPass = String.valueOf(passwordField.getPassword());
                    information.put(userData, userPass);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        }

        if (e.getSource() == Login) {
            ID_Pass idPass = null;
            try {
                idPass = new ID_Pass();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Login_Page loginPage = new Login_Page(idPass.getCredentials());
            frame.dispose();
        }
        if (e.getSource() == reset) {
            userField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == terms) {
            try {
                String url = "https://policies.google.com/terms?hl=en-US";
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            } catch (Exception help) {
                help.printStackTrace();
            }
        }
    }
}
