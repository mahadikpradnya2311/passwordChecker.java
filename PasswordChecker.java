
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PasswordChecker extends JFrame {
    private JTextField passwordField;
    private JLabel strengthLabel;

    public PasswordChecker() {
        setTitle("Password Strength Checker");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));

        passwordField = new JTextField(20);
        strengthLabel = new JLabel("Password Strength: ");

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String password = passwordField.getText();
                String strength = checkPasswordStrength(password);
                strengthLabel.setText("Password Strength: " + strength);
            }
        });

        add(new JLabel("Enter Password:"));
        add(passwordField);
        add(strengthLabel);
    }

    private String checkPasswordStrength(String password) {
        int strength = 0;

        if (password.length() >= 8) {
            strength++;
        }
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        if (password.matches(".*[0-9].*")) {
            strength++;
        }
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            strength++;
        }

        switch (strength) {
            case 0:
            case 1:
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very Strong";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordChecker checker = new PasswordChecker();
            checker.setVisible(true);
        });
    }
}