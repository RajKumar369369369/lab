package jdbc_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Student_management extends JFrame {
    private JTextField studentIdField, nameField, ageField, genderField, departmentField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;

    private Connection connection;
    private Statement statement;

    public Student_management() {
        setTitle("Student Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        panel.add(studentIdField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);

        panel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        panel.add(departmentField);

        add(panel, BorderLayout.NORTH);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(buttonPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new Object[]{"Student ID", "Name", "Age", "Gender", "Department"}, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        add(scrollPane, BorderLayout.SOUTH);

        connectToDatabase();
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudents();
            }
        });
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "password");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {
        try {
            String query = "INSERT INTO students (id, name, age, gender, department) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(studentIdField.getText()));
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setInt(3, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(4, genderField.getText());
            preparedStatement.setString(5, departmentField.getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Added Successfully");
            clearFields();
            viewStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateStudent() {
        try {
            String query = "UPDATE students SET name = ?, age = ?, gender = ?, department = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setInt(2, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(3, genderField.getText());
            preparedStatement.setString(4, departmentField.getText());
            preparedStatement.setInt(5, Integer.parseInt(studentIdField.getText()));
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Updated Successfully");
            clearFields();
            viewStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent() {
        try {
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(studentIdField.getText()));
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student Deleted Successfully");
            clearFields();
            viewStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewStudents() {
        try {
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);
            tableModel.setRowCount(0);  // Clear existing rows
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String department = resultSet.getString("department");
                tableModel.addRow(new Object[]{id, name, age, gender, department});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        studentIdField.setText("");
        nameField.setText("");
        ageField.setText("");
        genderField.setText("");
        departmentField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Student_management().setVisible(true);
            }
        });
    }
}
