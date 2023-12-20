import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JButton showAnswerButton;
    
    public QuizApp() {
        // Set the layout manager to FlowLayout
        setLayout(new FlowLayout());
        
        // Create the question label
        questionLabel = new JLabel("What is the capital of France?");
        add(questionLabel);
        
        // Create the "Show Answer" button
        showAnswerButton = new JButton("Show Answer");
        add(showAnswerButton);
        
        // Add an ActionListener to the button
        showAnswerButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // When the button is clicked, reveal the answer
        if (e.getSource() == showAnswerButton) {
            questionLabel.setText("The capital of France is Paris.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuizApp app = new QuizApp();
                app.setTitle("Quiz App");
                app.setSize(400, 100);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
            }
        });
    }
}
