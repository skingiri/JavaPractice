package com.mylearning.jdbcexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Integer.parseInt;

public class WriteFileIntoDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sample";
        String username = "root";
        String password = "sweety@1995";

        String filePath = "C:\\JavaPractice\\CSVDemo.csv";
        int batchSize = 20;

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

            String sql = "insert into employee (ID, Fname, Lname, Designation, City) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(filePath));

            String lineText = null;
            int count = 0;

            lineReader.readLine();
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");

                String ID = data[0];
                String Fname = data[1];
                String Lname = data[2];
                String Designation = data[3];
                String City = data[4];

                statement.setInt(1, parseInt(ID));
                statement.setString(2, Fname);
                statement.setString(3, Lname);
                statement.setString(4, Designation);
                statement.setString(5, City);
                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
            lineReader.close();
            statement.executeBatch();
            connection.commit();
            connection.close();
            System.out.println("Data has been Successfully inserted");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
