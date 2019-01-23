package com.webappcafe.servlet.security;
import com.webappcafe.dao.CustomerDAOImpl;
import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
@WebServlet(name = "registrationFunction", value = {"/registrationFunction"})
public class RegistrationFunction extends HttpServlet {
 
public static final String SELECT_CUSTOMERS_USERNAME = String.format("SELECT username FROM customers");

    
 public RegistrationFunction() {}
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String userName = request.getParameter("username");
    String password = request.getParameter("pswd");
    String userRegistered = null;
//    Customer loggedInCustomer;
     try
     {
        if(!preRegistrationCheck(userName))
        {
            response.getWriter().print(false);
        }
        else
        {
            Customer registerBean = new Customer();
            registerBean.setFname(fname);
            registerBean.setLname(lname);
            registerBean.setUsername(userName);
            registerBean.setPassword(password); 
            CustomerDAOImpl customerDao = new CustomerDAOImpl();
            userRegistered = customerDao.registerUser(registerBean);
            //fetch newly registered user's every detail, including id
            registerBean = customerDao.getCustomerByUsername(userName);
            HttpSession session=request.getSession();
            session.setAttribute("loggedInCustomer",registerBean);
            response.getWriter().print(true);
        }
     } 
     catch (SQLException ex)
     {
         Logger.getLogger(RegistrationFunction.class.getName()).log(Level.SEVERE, null, ex);
     }
 }

 public static boolean preRegistrationCheck(String usr) throws SQLException
    {
        Database database = Database.getInstance();

        String username = usr; 
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        try
        {
            Connection connection = database.getConnection();
            statement = connection.createStatement(); 
            resultSet = statement.executeQuery(SELECT_CUSTOMERS_USERNAME); 
            while(resultSet.next()) 
            {
                userNameDB = resultSet.getString("username"); 
                if(username.equals(userNameDB))
                {
                    return false; 
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return true; 
    }
}


