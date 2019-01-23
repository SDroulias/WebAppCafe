package com.webappcafe.dao;

 
import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class CustomerDAOImpl implements CustomerDAO
{
    private Database database = Database.getInstance();
    public static final String SELECT_CUSTOMERS_STATEMENT = String.format("SELECT * FROM %s;", "`customers`");

    public static final String CREATE_NEW_CUSTOMER = "INSERT INTO `customers` (`fname`,`lname`,`username`,`password`) VALUES (?,?,?,?);";
    public static final String UPDATE_CUSTOMER_STATEMENT = "UPDATE `customers` SET `fname` = ?, `lname` = ?, `username` = ?, `password` = ? "
            + "WHERE `id` = ?";
    public static final String SELECT_CUSTOMER_WHERE_ID_STATEMENT = "SELECT * FROM `customers` WHERE `id` = ?";
    public static final String DELETE_CUSTOMER_BYID = "DELETE FROM `customers` WHERE `id` = ?;";
    public static final String GET_CUSTOMER_BY_USERNAME = "SELECT * FROM `customers` WHERE `username` = ?";

 public String registerUser(Customer registerBean)
 {
    String fname = registerBean.getFname();
    String lname = registerBean.getLname();
    String userName = registerBean.getUsername();
    String password = registerBean.getPassword();

    PreparedStatement preparedStatement = null;
    Database database = Database.getInstance();

    try
    {
        Connection connection = database.getConnection();
//        String query = "INSERT INTO customers(fname,lname,username,password) VALUES (?,?,?,?)";
        preparedStatement = connection.prepareStatement(CREATE_NEW_CUSTOMER); 
        preparedStatement.setString(1, fname);
        preparedStatement.setString(2, lname);
        preparedStatement.setString(3, userName);
        preparedStatement.setString(4, password);

        int i= preparedStatement.executeUpdate();

        if (i!=0)  
        return "SUCCESS"; 
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }

    return "Oops.. Something went wrong there..!";  
}
 
 public List<Customer> getAllCustomers() 
 {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_STATEMENT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong(1));
                customer.setFname(resultSet.getString(2));
                customer.setLname(resultSet.getString(3));
                customer.setUsername(resultSet.getString(4));
                customer.setPassword(resultSet.getString(5));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
 
 public void deleteCustomerByID(long id)
 {
     try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BYID);
             ) {
             preparedStatement.setLong(1, id);
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 }

    @Override
    public int updateCustomer(Customer customer) {
        int affectedRows = 0;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(UPDATE_CUSTOMER_STATEMENT);
        try {
            preparedStmt.setString(1, customer.getFname());
            preparedStmt.setString(2, customer.getLname());
            preparedStmt.setString(3, customer.getUsername());
            preparedStmt.setString(4, customer.getPassword());
            preparedStmt.setLong(5, customer.getId());
            
            affectedRows = preparedStmt.executeUpdate();
            
            return affectedRows;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return affectedRows;
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer c = null;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(SELECT_CUSTOMER_WHERE_ID_STATEMENT);
        try {
            preparedStmt.setLong(1, id);
            
            ResultSet result = preparedStmt.executeQuery();
            
            while(result.next()) {
                c = fetchCustomerByResultSet(result);
            }
            
            return c;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return c;
    }
 
    @Override
    public Customer fetchCustomerByResultSet(ResultSet results) {
        Customer c = null;
        
        try {
            c = Customer.createCustomer(results.getLong("id"), 
                results.getString("fname"), 
                results.getString("lname"), 
                results.getString("username"), 
                results.getString("password"));
        
            return c;
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return c;
    }
    
    @Override
    public Customer getCustomerByUsername(String username) {
        Customer c = null;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(GET_CUSTOMER_BY_USERNAME);
        try {
            preparedStmt.setString(1, username);
            
            ResultSet result = preparedStmt.executeQuery();
            
            while(result.next()) {
                c = fetchCustomerByResultSet(result);
            }
            
            return c;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return c;
    }
}
