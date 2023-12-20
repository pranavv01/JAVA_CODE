import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing3 extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JComboBox<String> languageComboBox;
    private JButton submitButton;

    public Swing3() {
        // Set the layout manager to FlowLayout
        setLayout(new FlowLayout());

        // Create the title label
        titleLabel = new JLabel("Choose your favorite programming language:");
        add(titleLabel);

        // Create the JComboBox with programming language options
        String[] languages = {"Java", "Python", "C++", "JavaScript", "Swift"};
        languageComboBox = new JComboBox<>(languages);
        add(languageComboBox);

        // Create the "Submit" button
        submitButton = new JButton("Submit");
        add(submitButton);

        // Register an ActionListener for the "Submit" button
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Retrieve the selected language from the JComboBox
            String selectedLanguage = (String) languageComboBox.getSelectedItem();

            // Display a message dialog with the chosen language
            JOptionPane.showMessageDialog(this, "You chose: " + selectedLanguage,
                    "Language Choice", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Swing3 app = new Swing3();
                app.setTitle("Language Choice App");
                app.setSize(400, 150);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
            }
        });
    }
}
