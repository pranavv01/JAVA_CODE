/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author yugja
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class dmlState {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/student";
    private static final String username = "root";
    private static final String password = "yug123";

    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Create and configure the Swing frame
      
        JFrame frame = new JFrame("Database Operations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JTextField rollNoField = new JTextField(20);
        JTextField nameField = new JTextField(20);
        JTextField marksField = new JTextField(20);
        inputPanel.add(new JLabel("Roll No:"));
        inputPanel.add(rollNoField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Marks:"));
        inputPanel.add(marksField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton selectButton = new JButton("Show Data");
        buttonPanel.add(insertButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(selectButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        // ActionListener for the Insert button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rollNo = rollNoField.getText();
                String name = nameField.getText();
                String marks = marksField.getText();

                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO std (roll_no, name, marks) VALUES (?, ?, ?)");
                    preparedStatement.setInt(1, Integer.parseInt(rollNo));
                    preparedStatement.setString(2, name);
                    preparedStatement.setInt(3, Integer.parseInt(marks));
                    int rowsAffected = preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, rowsAffected + " row(s) inserted.", "Insert Status", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Insert failed.", "Insert Status", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener for the Delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rollNoToDelete = rollNoField.getText();
                if (!rollNoToDelete.isEmpty()) {
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM std WHERE roll_no = ?");
                        preparedStatement.setInt(1, Integer.parseInt(rollNoToDelete));
                        int rowsAffected = preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, rowsAffected + " row(s) deleted.", "Delete Status", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Delete failed.", "Delete Status", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // ActionListener for the Update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rollNoToUpdate = rollNoField.getText();
                String newMarks = marksField.getText();

                if (!rollNoToUpdate.isEmpty() && !newMarks.isEmpty()) {
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE std SET marks = ? WHERE roll_no = ?");
                        preparedStatement.setInt(1, Integer.parseInt(newMarks));
                        preparedStatement.setInt(2, Integer.parseInt(rollNoToUpdate));
                        int rowsAffected = preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, rowsAffected + " row(s) updated.", "Update Status", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update failed.", "Update Status", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        // ActionListener for the Select button
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM std");
                    ResultSet resultSet = preparedStatement.executeQuery();

                    DefaultTableModel tableModel = buildTableModel(resultSet);

                    JTable table = new JTable(tableModel);

                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setPreferredSize(new Dimension(500, 300));

                    JOptionPane.showMessageDialog(null, scrollPane, "Select Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Select failed.", "Select Result", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
     public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        Vector<String> columnNames = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Get data
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
        
    }
}

