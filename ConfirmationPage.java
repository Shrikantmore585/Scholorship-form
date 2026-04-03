import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationPage extends JFrame {
    public ConfirmationPage() {
        setSize(500, 600); // Adjusted size for the text and checkbox
        setLocationRelativeTo(null);

        // Create the main panel with BorderLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Create the form panel with sky-blue background
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); // Vertical layout
        formPanel.setBackground(new Color(135, 206, 235)); // Sky-blue background

        // Create and add the label for the confirmation page
        JLabel confirmationLabel = new JLabel("Confirmation Page", SwingConstants.CENTER);
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        formPanel.add(confirmationLabel);

        // Add the checkbox with a label
        JCheckBox termsAndConditionsCheckbox = new JCheckBox("I agree to the terms and conditions.");
        formPanel.add(termsAndConditionsCheckbox);

        // Add the large confirmation text
        String confirmationText = "<html><p style='width: 400px;'>I / We agree to the terms and conditions of this scholarship. All information given in this application is valid to the best of my knowledge. I / We am / are punishable with penalties / punishments if any of the above mentioned details is false as per the Indian Penal Code, 199 and 200. The decision given by the competent authority will be final and will be accepted by me. If any surplus amount is received from the scholarship due to any reasons, then I / We will return the amount at the earliest. I / We will be responsible for taking action against me / my child against falsehood. I / We promise that we will take the scholarship / education fees as per the terms and conditions of the concerned scheme. All the documents that I have linked to the application have been received from the competent authority / authorities and the documents are valid and have been received by following the required legal procedures. There is no modification / correction / alteration performed on them. I hereby certify that the information provided is true and they are not false or fake. I am fully responsible for the false or fake surveillance of the attached documents, and I am fully aware that I will be entitled to the penalty imposed by the Indian Penal Code, 199 and 200.</p></html>";
        JLabel confirmationTextLabel = new JLabel(confirmationText);
        confirmationTextLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align text to the left
        formPanel.add(confirmationTextLabel);

        // Create the submit and previous buttons
        JButton previousButton = new JButton("Previous");
        JButton submitButton = new JButton("Submit");

        // Set the color for the Previous button (Red)
        previousButton.setBackground(Color.RED);
        previousButton.setOpaque(true);
        previousButton.setBorderPainted(false);
        previousButton.setPreferredSize(new Dimension(120, 40)); // Size adjustment

        // Set the color for the Submit button (Green)
        submitButton.setBackground(Color.GREEN);
        submitButton.setOpaque(true);
        submitButton.setBorderPainted(false);
        submitButton.setPreferredSize(new Dimension(120, 40)); // Size adjustment

        // Add action listener to the "Previous" button
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QualificationDetailsPage qualificationDetailsPage = new QualificationDetailsPage();
                qualificationDetailsPage.setVisible(true);
                dispose();
            }
        });

        // Add action listener to the "Submit" button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (termsAndConditionsCheckbox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "The form is submitted successfully...");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "You must agree to the terms and conditions before submitting.");
                }
            }
        });

        // Create a panel to hold the buttons side by side
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));  // Center-align the buttons with space
        buttonPanel.add(previousButton);
        buttonPanel.add(submitButton);

        // Add the button panel to the form panel
        formPanel.add(Box.createVerticalStrut(20));  // Space between text and buttons
        formPanel.add(buttonPanel); // Buttons added to the form panel

        // Add formPanel to the mainPanel
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Add the mainPanel to the JFrame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Launch the ConfirmationPage
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfirmationPage().setVisible(true);
            }
        });
    }
}