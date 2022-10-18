import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel welcomeMessage = new JLabel();

    WelcomePage(String userName) {
        welcomeMessage.setBounds(0, 0, 200, 30);
        welcomeMessage.setFont(new Font(null, Font.BOLD, 30));
        welcomeMessage.setText("Hello " + userName);

        frame.add(welcomeMessage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
