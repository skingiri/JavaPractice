package com.mylearning.jdbcexample;
import java.sql.*;

public class JdbcPostgresExample {
    public static void main(String[] args) throws SQLException {

//        Connection connection = createConnection();
//        if(connection != null){
//            System.out.println("Connected Successfully");
//        }
//        createTable();
        insertDataIntoCompanyTable();

//        getCompanyData();
//        insertDataBulk();
    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb",
                    "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return connection;
    }

    public static void createTable() {
        Statement stmt = null;
        try {
            Connection connection = createConnection();
            stmt = connection.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    public static void insertDataIntoCompanyTable() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
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

    public static void getCompanyData() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT name FROM COMPANY where age > 25;");
            while (rs.next()) {
//                int id = rs.getInt("id");
                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String address = rs.getString("address");
//                float salary = rs.getFloat("salary");
//                System.out.println("ID = " + id);
                System.out.println("NAME = " + name);
//                System.out.println("AGE = " + age);
//                System.out.println("ADDRESS = " + address);
//                System.out.println("SALARY = " + salary);
                System.out.println();
            }
            int x = 10 / 0;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            if(rs != null)
                rs.close();
            if(stmt != null)
                stmt.close();
            if(connection != null)
                connection.close();
        }
        System.out.println("Operation done successfully");
    }


    public static void insertDataBulk() throws SQLException {
        Statement stmt = null;
        Connection connection =null;
        try {
            connection = createConnection();
            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            for (int i = 1; i <= 10000000; i++) {
                String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                        + "VALUES ("+i+", 'Paul "+i+"', "+i+", 'California', 20000.00 );";
                stmt.executeUpdate(sql);
            }
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
}

