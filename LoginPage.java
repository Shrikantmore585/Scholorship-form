import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
        setTitle("Login Page");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(220, 220, 220)); // Light gray background
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding for components

        // Title label (Login)
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        mainPanel.add(titleLabel, gbc);

        // Form panel with username and password
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(135, 206, 235)); // Light blue background
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setPreferredSize(new Dimension(350, 220));
        
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.GREEN); // Set button color
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setPreferredSize(new Dimension(100, 40));

        // Add action listener for button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usernameField.getText().equals("Shri") && new String(passwordField.getPassword()).equals("1234")) {
                    // Navigate to PersonalDetailsPage
                    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
                    personalDetailsPage.setVisible(true);
                    dispose(); // Close the login page
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
                }
            }
        });

        // Set FlowLayout for centering the button in formPanel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(135, 206, 235)); // Light blue background
        buttonPanel.add(submitButton); // Add submit button to buttonPanel

        // Add the button panel to formPanel (below the username and password fields)
        formPanel.add(buttonPanel);

        // Add form panel to main panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(formPanel, gbc);

        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Launch the login page
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}