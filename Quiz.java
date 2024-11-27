package jdbc_demo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame {
    private static final String[][] QUESTIONS = {
        {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "Paris"},
        {"Which language is used for Android development?", "Java", "Python", "C++", "Ruby", "Java"},
        {"Who is the CEO of Tesla?", "Jeff Bezos", "Elon Musk", "Bill Gates", "Mark Zuckerberg", "Elon Musk"},
        {"What is 2 + 2?", "3", "4", "5", "6", "4"}
    };
    
    private int currentQuestionIndex = 0;
    private int score = 0;
    
    private JLabel questionLabel;
    private JRadioButton option1, option2, option3, option4;
    private ButtonGroup optionsGroup;
    private JButton nextButton, submitButton, finishButton;
    
    public Quiz() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();
        
        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);
        
        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);
        
        add(optionsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                nextQuestion();
            }
        });
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                showFinalScore();
            }
        });
        
        finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFinalScore();
            }
        });
        
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        buttonPanel.add(finishButton);
        
        add(buttonPanel, BorderLayout.SOUTH);

        loadQuestion(currentQuestionIndex);
    }

    private void loadQuestion(int questionIndex) {
        if (questionIndex >= QUESTIONS.length) {
            showFinalScore();
            return;
        }
        
        String[] questionData = QUESTIONS[questionIndex];
        questionLabel.setText(questionData[0]);
        option1.setText(questionData[1]);
        option2.setText(questionData[2]);
        option3.setText(questionData[3]);
        option4.setText(questionData[4]);
    }

    private void checkAnswer() {
        String correctAnswer = QUESTIONS[currentQuestionIndex][5];
        String selectedAnswer = null;

        if (option1.isSelected()) {
            selectedAnswer = option1.getText();
        } else if (option2.isSelected()) {
            selectedAnswer = option2.getText();
        } else if (option3.isSelected()) {
            selectedAnswer = option3.getText();
        } else if (option4.isSelected()) {
            selectedAnswer = option4.getText();
        }

        if (selectedAnswer != null && selectedAnswer.equals(correctAnswer)) {
            score++;
        }
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < QUESTIONS.length) {
            loadQuestion(currentQuestionIndex);
            optionsGroup.clearSelection();
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        JOptionPane.showMessageDialog(this, "Your score: " + score + "/" + QUESTIONS.length);
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }
}
