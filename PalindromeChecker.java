import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalindromeChecker extends JFrame {
    private JTextField inputField;
    private JButton checkButton;
    private JLabel resultLabel;

    public PalindromeChecker() {
        // Set up the frame
        setTitle("Palindrome Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        inputField = new JTextField(20);
        checkButton = new JButton("Check");
        resultLabel = new JLabel("Result: ");

        // Set up the layout
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter a word or phrase:"));
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);
        
        add(panel);

        // Add action listener to the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPalindrome();
            }
        });
    }

    private void checkPalindrome() {
        String input = inputField.getText();
        String cleanedInput = input.replaceAll("[\\W]", "").toLowerCase(); // Remove non-word characters and convert to lower case
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString(); // Reverse the cleaned string

        if (cleanedInput.equals(reversedInput)) {
            resultLabel.setText("Result: It's a palindrome!");
        } else {
            resultLabel.setText("Result: Not a palindrome.");
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(() -> {
            PalindromeChecker checker = new PalindromeChecker();
            checker.setVisible(true);
        });
    }
}
