package jdbc_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private String operator = "";
    private double firstNum = 0;

    public Calculator() {
        setTitle("Basic Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String buttonText : buttons) {
            JButton button = new JButton(buttonText);
            panel.add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(buttonText);
                }
            });
        }

        add(panel, BorderLayout.CENTER);

        display.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                display.setText("");
            }

            public void focusLost(FocusEvent e) {}
        });

        display.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode >= KeyEvent.VK_0 && keyCode <= KeyEvent.VK_9) {
                    handleButtonClick(String.valueOf(e.getKeyChar()));
                } else if (keyCode == KeyEvent.VK_EQUALS || keyCode == KeyEvent.VK_ENTER) {
                    handleButtonClick("=");
                } else if (keyCode == KeyEvent.VK_PLUS) {
                    handleButtonClick("+");
                } else if (keyCode == KeyEvent.VK_MINUS) {
                    handleButtonClick("-");
                } else if (keyCode == KeyEvent.VK_ASTERISK) {
                    handleButtonClick("*");
                } else if (keyCode == KeyEvent.VK_SLASH) {
                    handleButtonClick("/");
                }
            }
        });
    }

    private void handleButtonClick(String input) {
        if (input.matches("[0-9]")) {
            currentInput += input;
            display.setText(currentInput);
        } else if (input.equals(".")) {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                display.setText(currentInput);
            }
        } else if (input.equals("=")) {
            calculateResult();
        } else {
            if (!currentInput.isEmpty()) {
                firstNum = Double.parseDouble(currentInput);
                currentInput = "";
                operator = input;
            }
        }
    }

    private void calculateResult() {
        double secondNum = Double.parseDouble(currentInput);
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
        firstNum = result;
        currentInput = "";
        operator = "";
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }
}
