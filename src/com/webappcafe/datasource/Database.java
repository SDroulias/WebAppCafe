package com.webappcafe.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * A singleton Class which when we get the instance, a single instance is created.
 * Anytime a query has to be executed, a new connection and a statement is created.
 */
public class Database {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_SERVER = "ra1.anystream.eu:1011";
    private static final String DB_NAME = "ateam";
    private static final String DB_URL = "jdbc:mysql://" + DB_SERVER + "/" + DB_NAME + "?zeroDateTimeBehavior=convertToNull" +
            "&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false";
    private static final String DB_USER = "ateam";
    private static final String DB_PASSWORD = "ateam";

    private static Database databaseInstance;
    public static final String COLUMN_ID = "`id`";

    private Connection connection;
    private Statement statement;

    private Database() {
        connection = null;
        statement = null;
    }

    public <T> T connectAndExecute(String sqlQuery, byte t) {
        switch(t) {
            case 0: 
                return (T) executeUpdate(sqlQuery);
            case 1:
                return (T) executeQuery(sqlQuery);
        }
       return null;
    }
    
    public ResultSet executePreparedStatement(String sqlQuery) {
        connection = getConnection();
        statement = getStatement();
        PreparedStatement prpstmt = getPreparedStatement(sqlQuery);
        
        try {
            return prpstmt.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public PreparedStatement getPreparedStatement(String sqlQuery) {
        connection = getConnection();
        statement = getStatement();
        
        try {
            return connection.prepareStatement(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer executeUpdate(String sqlQuery) {
        connection = getConnection();
        statement = getStatement();
        
        try {
            return statement.executeUpdate(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ResultSet executeQuery(String sqlQuery) {
        connection = getConnection();
        statement = getStatement();
        
        try {
            return statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Database getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Couldn't connect to the database: " + e.getMessage());
        }
        return connection;
    }
    
    public Statement getStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Couldn't create a statement: " + e.getMessage());
        }
        return statement;
    }

    public boolean connectionTest() {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("SELECT 1;");
             ResultSet resultSet = pstmt.executeQuery()) {

            if (resultSet.next()) {
                System.out.println("Connection successful.");
                return true;
            } else {
                System.out.println("Connection failure.");
                return false;
            }


        } catch (SQLException e) {
            System.out.println("Problem with the database!");
        }

        return false;
    }
}
