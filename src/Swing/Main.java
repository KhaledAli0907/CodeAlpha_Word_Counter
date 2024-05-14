package Swing;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a simple GUI application to count the number of words entered in a text field.
 */
public class Main {
    public static void main(String[] args) {
        // Create a new JFrame container with the title "Words Counter"
        JFrame f = getjFrame();

        // Create a label prompting the user to enter words
        JLabel words = new JLabel("Enter words: ");

        // Add the label to the frame
        f.add(words);

        // Create a text field with a specified column width
        JTextField t1 = new JTextField(20);

        // Add the text field to the frame
        f.add(t1);

        // Create a submit button
        JButton submit = new JButton("Submit");

        // Add the submit button to the frame
        f.add(submit);

        // Create a label to display the result
        JLabel result = new JLabel("");

        // Add an action listener to the submit button
        submit.addActionListener(_ -> {
            // Call the calculateWords method and get the count of words from the text field
            int wordsCount = calculateWords(t1);

            // Set the text of the result label to display the words count
            result.setText("Words Count: " + wordsCount);
        });

        // Add the result label to the frame
        f.add(result);

        // Set the frame to be visible
        f.setVisible(true);
    }

    /**
     * This method creates and configures a JFrame for the Words Counter application.
     * It sets the visibility, default close operation, size, and layout of the frame.
     *
     * @return A fully configured JFrame.
     */
    private static JFrame getjFrame() {
        JFrame f = new JFrame("Words Counter");

        // Set the default close operation to exit the application when the user closes the frame
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set the size of the frame
        f.setSize(800, 400);

        // Set the layout manager to FlowLayout
        f.setLayout(new FlowLayout());
        return f;
    }


    /**
     * This method calculates the number of words in the text contained within a JTextField.
     * It considers words to be separated by any number of whitespace characters.
     *
     * @param t1 The JTextField from which to retrieve the text.
     * @return The number of words in the text field.
     */
    private static int calculateWords(JTextField t1) {
        // Get the text from the JTextField, removing any leading or trailing whitespace
        String text = t1.getText().trim();

        // If the text is empty, return 0 as there are no words to count
        if (text.isEmpty())
            return 0;

        // Split the text into an array of words, using whitespace as the delimiter
        String[] words = text.split("\\s+");

        // Return the length of the array, which corresponds to the number of words
        return words.length;
    }
}