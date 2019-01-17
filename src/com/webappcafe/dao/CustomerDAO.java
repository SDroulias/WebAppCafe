package com.webappcafe.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;
 
public class CustomerDAO {
 
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
}