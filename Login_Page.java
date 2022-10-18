import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class Login_Page implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userName = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel _userID = new JLabel("Username: ");
    JLabel password = new JLabel("Password: ");
    JLabel message = new JLabel("");
    JButton registerButton = new JButton("Register");
    JButton helpButton = new JButton("Help");
    HashMap<String, String> Credentials;
    HashMap<String, String> otherInfo;
    HashMap<String, String> _Credentials;

    public Login_Page(HashMap<String, String> OriginalInfo) {
        Credentials = OriginalInfo;
        _Credentials = OriginalInfo;
        _userID.setBounds(50, 100, 75, 25);
        password.setBounds(50, 150, 75, 25);

        userName.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);

        message.setBounds(125, 250, 250, 35);
        message.setFont(new Font(null, Font.BOLD, 25));

        loginButton.setBounds(100, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        registerButton.setBounds(100, 250, 100, 25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        helpButton.setBounds(225, 250, 100, 25);
        helpButton.setFocusable(false);
        helpButton.addActionListener(this);
        frame.setTitle("Deep Web Login");
        frame.add(helpButton);
        frame.add(userName);
        frame.add(passwordField);
        frame.add(_userID);
        frame.add(password);
        frame.add(message);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(registerButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        passwordField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton || e.getSource() == passwordField) {
            String userID = userName.getText();
            String pass = String.valueOf(passwordField.getPassword());
            if (Credentials.containsKey(userID) || _Credentials.containsKey(userID)) {
                if (Credentials.get(userID).equals(pass)) {
                    message.setForeground(Color.green);
                    message.setText("Login Successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                } else {
                    message.setForeground(Color.red);
                    message.setText("incorrect");
                }
            }
        } else {
            message.setForeground(Color.red);
            message.setText("Not found");
        }
        if (e.getSource() == helpButton) {
            try {
                String url = "https://www.google.com";
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                message.setText("");
            } catch (java.io.IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        if (e.getSource() == registerButton) {
            try {
                Register register = new Register(otherInfo);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();
        }
        if (e.getSource() == resetButton) {
            userName.setText("");
            passwordField.setText("");
            message.setText("");
        }
    }
}
