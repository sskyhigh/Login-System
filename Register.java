import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Register implements ActionListener {
    private final JFrame frame = new JFrame();
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton registerButton = new JButton("Register");
    private JButton goBack = new JButton("Back");
    private JLabel userLabel = new JLabel("Username: ");
    private JLabel passwordTitle = new JLabel("Password: ");
    public Register() {
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        userLabel.setBounds(50, 100, 100, 25);
        passwordTitle.setBounds(50, 150, 100, 25);
        userField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 150, 200, 25);
        registerButton.setBounds(75, 220, 100, 25);
        goBack.setBounds(200, 220, 100, 25);

        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        passwordField.addActionListener(this);

        goBack.setFocusable(false);
        goBack.addActionListener(this);

        frame.add(userField);
        frame.add(passwordField);
        frame.add(passwordTitle);
        frame.add(userLabel);
        frame.add(registerButton);
        frame.add(goBack);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goBack){
            ID_Pass idPass = new ID_Pass();
            Login_Page loginPage = new Login_Page(idPass.getCredentials());
            frame.dispose();
        }
    }
}
