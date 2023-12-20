import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private JButton button;

    public MyFrame() {
        // Initialize and configure the button
        button = new JButton("Click Me"); 
        button.setBounds(60, 60, 100, 60);

        // Add the button to the JFrame
        add(button);

        // Register the button with ActionListener
        button.addActionListener(this);

        // Set frame properties
        setTitle("Button Example");
        setSize(300, 200);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method will be called when the button is clicked
        System.out.println("Button clicked!");
    }

    public static void main(String[] args) {
        // Create an instance of MyFrame
        MyFrame frame = new MyFrame();
        // Make the frame visible
        frame.setVisible(true);
    }
}
