import java.awt.*;
import javax.swing.*;

public class QualificationDetailsPage extends JFrame {
    private JTextField qualificationField, qualificationLevelField, streamField, yearOfStudyField;
    private JComboBox<String> stateComboBox, districtComboBox;

    public QualificationDetailsPage() {
        setTitle("Qualification Details");
        setSize(450, 500);  // Adjusted size for additional fields
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
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow components to expand horizontally

        // Label for "Qualification Details" at the top
        JLabel qualificationDetailsLabel = new JLabel("Qualification Details", SwingConstants.CENTER);
        qualificationDetailsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Span across both columns
        formPanel.add(qualificationDetailsLabel, gbc);

        // Qualification field
        JLabel qualificationLabel = new JLabel("Qualification:");
        qualificationField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Ensure qualificationLabel stays in one column
        formPanel.add(qualificationLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(qualificationField, gbc);

        // State dropdown field
        JLabel stateLabel = new JLabel("Institute State:");
        stateComboBox = new JComboBox<>(new String[]{"Select State", "Maharashtra", "Uttarakhand"});
        stateComboBox.addActionListener(e -> updateDistricts());
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(stateLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(stateComboBox, gbc);

        // District dropdown field
        JLabel districtLabel = new JLabel("Institute District:");
        districtComboBox = new JComboBox<>(new String[]{"Select District"});
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(districtLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(districtComboBox, gbc);

        // Qualification Level field
        JLabel qualificationLevelLabel = new JLabel("Qualification Level:");
        qualificationLevelField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(qualificationLevelLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(qualificationLevelField, gbc);

        // Stream field
        JLabel streamLabel = new JLabel("Stream:");
        streamField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(streamLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(streamField, gbc);

        // Year of Study field
        JLabel yearOfStudyLabel = new JLabel("Year of Study:");
        yearOfStudyField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 6;
        formPanel.add(yearOfStudyLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(yearOfStudyField, gbc);

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

        nextButton.addActionListener(e -> {
            if (!qualificationField.getText().isEmpty() && !qualificationLevelField.getText().isEmpty() &&
                !streamField.getText().isEmpty() && !yearOfStudyField.getText().isEmpty()) {
                
                // Navigate to the next page (confirmation page)
                ConfirmationPage confirmationPage = new ConfirmationPage();
                confirmationPage.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all qualification details.");
            }
        });

        previousButton.addActionListener(e -> {
            IncomeDetailsPage incomeDetailsPage = new IncomeDetailsPage();
            incomeDetailsPage.setVisible(true);
            dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the buttons
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        formPanel.add(buttonPanel, gbc);


        // Add form panel and button panel to the main panel
        mainPanel.add(formPanel, BorderLayout.CENTER);
       
        // Add the main panel to the frame
        add(mainPanel);
    }

    // Method to update district combo box based on selected state
    private void updateDistricts() {
        String selectedState = (String) stateComboBox.getSelectedItem();
        districtComboBox.removeAllItems();

        if ("Maharashtra".equals(selectedState)) {
            districtComboBox.addItem("Select District");
            districtComboBox.addItem("Nanded");
            districtComboBox.addItem("Beed");
            districtComboBox.addItem("Pune");
            districtComboBox.addItem("Latur");
        } else if ("Uttarakhand".equals(selectedState)) {
            districtComboBox.addItem("Select District");
            districtComboBox.addItem("Chamoli");
            districtComboBox.addItem("Dehradun");
            districtComboBox.addItem("Haridwar");
            districtComboBox.addItem("Pauri Garhwal");
        } else {
            districtComboBox.addItem("Select District");
        }
    }

}