/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class myConSql {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "yug123";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database.");

            Statement statement = connection.createStatement();

            // Execute a SQL query (replace "your_table" with the actual table name)
            String query = "SELECT * FROM std";
            ResultSet resultSet = statement.executeQuery(query);

            // Display the data
            while (resultSet.next()) {
                int id = resultSet.getInt("roll_no"); // Replace "id" with the actual column name
                String name = resultSet.getString("name"); // Replace "name" with the actual column name
                int mark = resultSet.getInt("marks"); // Replace "id" with the actual column name
                
                System.out.println("ID: " + id + ", Name: " + name+", marks: "+mark);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
    }
}
