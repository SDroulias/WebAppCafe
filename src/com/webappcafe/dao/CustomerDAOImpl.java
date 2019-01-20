package com.webappcafe.dao;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class CustomerDAOImpl implements CustomerDAO
{
    private Database database = Database.getInstance();
    public static final String SELECT_CUSTOMERS_STATEMENT = String.format("SELECT * FROM %s;", "`customers`");
    public static final String DELETE_CUSTOMER_BYID = String.format("DELETE FROM customers WHERE id = ?;");
    public static final String CREATE_NEW_CUSTOMER = String.format("INSERT INTO customers(fname,lname,username,password) VALUES (?,?,?,?)");
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
}
