package com.mylearning.jdbcexample;

import java.sql.*;


public class JdbcExample {
    public static void main(String[] args) throws SQLException {

//        Connection connection = createConnection();
//        if(connection != null){
//            System.out.println("Connected Successfully");
//        }
//        createTable();
//        insertDataIntoRulesTable();
//        updateDataInRulesTable();
//        deleteDataFromRulesTable();
        selectDataFromRulesTable();
    }



    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "sweety@1995");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Opened database successfully");
        return connection;
    }
    public static void createTable() {
        Statement stmt = null;
        try {
            Connection connection = createConnection();
            stmt = connection.createStatement();
            String sql = "CREATE TABLE RULES " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " RULEPOSITION   CHAR(50)     NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
    public static void insertDataIntoRulesTable() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO RULES (ID,NAME,RULEPOSITION) "
                    + "VALUES (1, 'ADINA', 'APPROVED');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO RULES (ID,NAME,RULEPOSITION) "
                    + "VALUES (2, 'STEVE', 'PENDING');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO RULES (ID,NAME,RULEPOSITION) "
                    + "VALUES (3, 'MARK', 'DENIED');";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO RULES (ID,NAME,RULEPOSITION) "
                    + "VALUES (4, 'CHRIS', 'UNKNOWN');";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            connection.rollback();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Records created successfully");
    }
    public static void updateDataInRulesTable() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "UPDATE RULES SET NAME = 'ALINA' WHERE ID = 1";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            connection.rollback();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Records Updated Successfully");
    }
    public static void deleteDataFromRulesTable() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "DELETE FROM RULES WHERE RULEPOSITION='UNKNOWN'";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            connection.rollback();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Records Deleted Successfully");
    }
    public static void selectDataFromRulesTable() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "SELECT * FROM RULES";
            ResultSet rs = stmt.executeQuery(sql);
//            stmt.executeUpdate(sql);

            while(rs.next())
            {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("NAME: " + rs.getString("NAME"));
                System.out.println("RULEPOSITION: " + rs.getString("RULEPOSITION"));
            }

            stmt.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            connection.rollback();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Selected data is displayed");
    }
}
