/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author yugja
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class sqlTable extends JFrame {
    private JTable table;

    public sqlTable() {
        super("Display Records");

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scroll pane to the frame
        add(scrollPane);

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Load data from the database
        loadDataFromDatabase(model);
    }

    private void loadDataFromDatabase(DefaultTableModel model) 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "yug123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM std");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()) 
            {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) 
                {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new sqlTable().setVisible(true);
        });
    }
}