import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IncomeDetailsPage extends JFrame {
    private JTextField incomeField, certificateNoField, issueDateField, issuingAuthorityField, validTillDateField;

    public IncomeDetailsPage() {
        setTitle("Income Details");
        setSize(450, 400);  // Adjusted size for additional fields
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Form panel with GridBagLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(new Color(135, 206, 235)); // Sky-blue background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding for components

        // Label for "Income Details" at the top
        JLabel incomeDetailsLabel = new JLabel("Income Details", SwingConstants.CENTER);
        incomeDetailsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Span across both columns
        formPanel.add(incomeDetailsLabel, gbc);

        // Initialize form fields
        JLabel incomeLabel = new JLabel("Income:");
        incomeField = new JTextField(20);

        JLabel certificateNoLabel = new JLabel("Income Certificate No:");
        certificateNoField = new JTextField(20);

        JLabel issueDateLabel = new JLabel("Date of Issue:");
        issueDateField = new JTextField(20);

        JLabel issuingAuthorityLabel = new JLabel("Issuing Authority:");
        issuingAuthorityField = new JTextField(20);

        JLabel validTillDateLabel = new JLabel("Valid Till Date:");
        validTillDateField = new JTextField(20);

        // Add components to the form panel with GridBagLayout
        gbc.gridwidth = 1;  // Reset gridwidth for other components

        // Income field
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(incomeLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(incomeField, gbc);

        // Income Certificate No. field
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(certificateNoLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(certificateNoField, gbc);

        // Date of Issue field
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(issueDateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(issueDateField, gbc);

        // Issuing Authority field
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(issuingAuthorityLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(issuingAuthorityField, gbc);

        // Valid Till Date field
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(validTillDateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(validTillDateField, gbc);

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


        nextButton.addActionListener(e -> {
            if (!incomeField.getText().isEmpty() && !certificateNoField.getText().isEmpty() &&
                !issueDateField.getText().isEmpty() && !issuingAuthorityField.getText().isEmpty() &&
                !validTillDateField.getText().isEmpty()) {

                // Navigate to QualificationDetailsPage
                QualificationDetailsPage qualificationDetailsPage = new QualificationDetailsPage();
                qualificationDetailsPage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all income details.");
            }
        });

        previousButton.addActionListener(e -> {
            PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
            personalDetailsPage.setVisible(true);
            dispose();
        });


        // Add buttons to the buttonPanel
       

        // Add form panel and button panel to the main panel
        mainPanel.add(formPanel, BorderLayout.CENTER);
        
        // Add the main panel to the frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Launch the IncomeDetailsPage
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IncomeDetailsPage().setVisible(true);
            }
        });
    }
}