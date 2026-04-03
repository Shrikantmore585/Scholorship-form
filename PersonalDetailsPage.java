import java.awt.*;
import javax.swing.*;

public class PersonalDetailsPage extends JFrame {
    private JTextField nameField, dobField, addressField, emailField, mobileField, ageField;
    private JRadioButton maleRadioButton, femaleRadioButton;

    public PersonalDetailsPage() {
        setTitle("Personal Details");
        setSize(450, 550);  // Increased size for better spacing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the form panel with GridBagLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(new Color(135, 206, 235));
         // Sky-blue background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding for components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // Initialize form fields
        JLabel nameLabel = new JLabel("Name:");
        JLabel dobLabel = new JLabel("Date of Birth:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel mobileLabel = new JLabel("Mobile Number:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel ageLabel = new JLabel("Age:");

        nameField = new JTextField(20);
        dobField = new JTextField(20);
        addressField = new JTextField(20);
        emailField = new JTextField(20);
        mobileField = new JTextField(20);
        ageField = new JTextField(20);

        // Gender radio buttons
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Add the "Personal Details" label at the top of the formPanel (centered)
        JLabel personalDetailsLabel = new JLabel("Personal Details", SwingConstants.CENTER);
        personalDetailsLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set a larger font for the label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Span across both columns
        formPanel.add(personalDetailsLabel, gbc);

        // Add components to the form panel with GridBagLayout
        gbc.gridwidth = 1;  // Reset gridwidth for other components

        // Name field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Date of Birth field
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(dobLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(dobField, gbc);

        // Address field
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(addressField, gbc);

        // Email field
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Mobile Number field
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(mobileLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(mobileField, gbc);

        // Gender radio buttons
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(genderLabel, gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        formPanel.add(genderPanel, gbc);

        // Age field
        gbc.gridx = 0;
        gbc.gridy = 7;
        formPanel.add(ageLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(ageField, gbc);

        // Next and Previous buttons
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(Color.GREEN); // Green background
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        nextButton.setPreferredSize(new Dimension(100, 40));

        JButton previousButton = new JButton("Previous");
        previousButton.setBackground(Color.RED); // Red background
        previousButton.setOpaque(true);
        previousButton.setBorderPainted(false);
        previousButton.setPreferredSize(new Dimension(100, 40));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the buttons
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        formPanel.add(buttonPanel, gbc);

        // Action for Next button
        nextButton.addActionListener(e -> {
            if (!nameField.getText().isEmpty() && !dobField.getText().isEmpty() &&
                !addressField.getText().isEmpty() && !emailField.getText().isEmpty() &&
                !mobileField.getText().isEmpty() && !ageField.getText().isEmpty()) {

                // Navigate to IncomeDetailsPage
                IncomeDetailsPage incomeDetailsPage = new IncomeDetailsPage();
                incomeDetailsPage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all details.");
            }
        });

        // Action for Previous button
        previousButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Going to the previous page.");
            dispose();
        });

        // Add the form panel to the main panel
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Set preferred size of the formPanel to adjust its size based on content
        formPanel.setPreferredSize(new Dimension(400, 500)); // Adjust based on the size of your content

        // Add the main panel to the frame
        add(mainPanel);
    }
}