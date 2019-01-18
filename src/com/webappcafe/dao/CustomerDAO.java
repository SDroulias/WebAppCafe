package com.webappcafe.dao;
 
import static com.webappcafe.dao.ProductDAOImpl.SELECT_PRODUCT_STATEMENT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
public class CustomerDAO 
{
    private Database database = Database.getInstance();
    public static final String SELECT_CUSTOMERS_STATEMENT = String.format("SELECT * FROM %s;", "`customers`");
 public String registerUser(Customer registerBean)
 {
    String fname = registerBean.getFname();
    String lname = registerBean.getLname();
    String userName = registerBean.getUsername();
    String password = registerBean.getPassword();

    Connection con = null;
    PreparedStatement preparedStatement = null;
    Database database = Database.getInstance();

    try
    {
        Connection connection = database.getConnection();
        String query = "insert into customers(fname,lname,username,password) values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(query); 
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
}