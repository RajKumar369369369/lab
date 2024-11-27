package jdbc_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginRegistrationApp {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DB_USER = "raj";
    private static final String DB_PASSWORD = "raj@8885360519";
    
    private static Connection conn;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Login and Registration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CardLayout cardLayout = new CardLayout();
        JPanel panelContainer = new JPanel(cardLayout);
        
        JPanel loginPanel = createLoginPanel(cardLayout, panelContainer);
        JPanel registerPanel = createRegisterPanel(cardLayout, panelContainer);
        
        panelContainer.add(loginPanel, "Login");
        panelContainer.add(registerPanel, "Register");
        
        frame.add(panelContainer);
        frame.setVisible(true);
    
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static JPanel createLoginPanel(CardLayout cardLayout, JPanel panelContainer) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(panel, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "Register");
            }
        });
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        
        return panel;
    }
    
    private static JPanel createRegisterPanel(CardLayout cardLayout, JPanel panelContainer) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String email = emailField.getText();
                if (registerUser(username, password, email)) {
                    JOptionPane.showMessageDialog(panel, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(panelContainer, "Login");
                } else {
                    JOptionPane.showMessageDialog(panel, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "Login");
            }
        });
        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(registerButton);
        panel.add(backButton);
        
        return panel;
    }
    
    private static boolean validateLogin(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in login validation", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private static boolean registerUser(String username, String password, String email) {
        try {
            String checkQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet checkRs = checkStmt.executeQuery();
            if (checkRs.next()) {
                return false; 
            }
            
            String insertQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, email);
            insertStmt.executeUpdate();
            return true;  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in registration", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
