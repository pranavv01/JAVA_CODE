import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener
{
    private JTextField inputField1;
    private JTextField inputField2;
    private JButton calculateButton;
    private JTextField resultField;

    public CalculatorApp() 
    {
        // Set up the frame
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        // Create and add components
        inputField1 = new JTextField(10);
        inputField2 = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultField = new JTextField(10);
        
        resultField.setEditable(false); // Make the result field read-only

        add(inputField1);
        add(inputField2);
        add(calculateButton);
        add(resultField);
        calculateButton.addActionListener(this); 
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
                int s1=Integer.parseInt(inputField1.getText());
                int s2=Integer.parseInt(inputField2.getText());
               int result = s1 + s2;
              resultField.setText(Integer.toString(result));

    }

    public static void main(String[] args) 
    {
        CalculatorApp ca=new CalculatorApp();
        ca.setVisible(true);
    }
}


