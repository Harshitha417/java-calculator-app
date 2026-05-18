import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    String operator;

    public CalculatorGUI() {

        setTitle("Calculator");
        setSize(300, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextField();
        display.setBounds(20, 20, 240, 40);
        add(display);

        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "C","0","=","+"
        };

        int x = 20;
        int y = 80;

        for (String text : buttons) {

            JButton btn = new JButton(text);
            btn.setBounds(x, y, 50, 40);
            btn.addActionListener(this);
            add(btn);

            x += 60;

            if (x > 200) {
                x = 20;
                y += 50;
            }
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // Numbers
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        }

        // Clear
        else if (command.equals("C")) {
            display.setText("");
        }

        // Operators
        else if (command.equals("+") ||
                 command.equals("-") ||
                 command.equals("*") ||
                 command.equals("/")) {

            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        }

        // Equal
        else if (command.equals("=")) {

            num2 = Double.parseDouble(display.getText());

            switch(operator) {

                case "+":
                    result = num1 + num2;
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}