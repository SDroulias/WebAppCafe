package com.webappcafe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.webappcafe.model.LoginItem;
import com.webappcafe.datasource.Database;


public class LoginDao 
{
    private Database database = Database.getInstance();

    public String authenticateUser(LoginItem loginBean) throws SQLException
    {
        String username = loginBean.getUsername(); 
        String password = loginBean.getPassword();
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        try
        {
            Connection connection = database.getConnection();
            statement = connection.createStatement(); 
            resultSet = statement.executeQuery("select username,password from customers"); 
            while(resultSet.next()) 
            {
                userNameDB = resultSet.getString("username"); 
                passwordDB = resultSet.getString("password");
                if(username.equals(userNameDB) && password.equals(passwordDB))
                {
                    return "SUCCESS"; 
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials"; 
    }
}
