package Javatodatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Javatodatabase {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "9443212896Fid$";

        // SQL query to insert data
        String sql = "INSERT INTO emptable (empcode, empname , empage , esalary )VALUES (?, ?, ?, ?) ";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            // Data to be inserted
            String createdb="create database Jdatabase";
            String use="use Jdatabase";
            String createtable="create table emptable(empcode INT, empname VARCHAR(255), empage INT, esalary INT)";
            String select="select * from emptable";
            int[] empCodes = {101, 102, 103, 104, 105};
            String[] empNames = {"jenny", "jacky", "joe", "john", "shameer"};
            int[] empAges = {25, 30, 20, 40, 25};
            int[] salaries = {10000, 20000, 40000, 80000, 90000};

            stmt.execute(createdb);
            stmt.execute(use);
            stmt.execute(createtable);

            // Insert data for each employee
            for (int i = 0; i < empCodes.length; i++) {
                stmt.setInt(1, empCodes[i]);
                stmt.setString(2, empNames[i]);
                stmt.setInt(3, empAges[i]);
                stmt.setInt(4, salaries[i]);
                stmt.addBatch();
            }

            // Execute batch insert
            int[] affectedRows = stmt.executeBatch();

            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

