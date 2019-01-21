package com.webappcafe.servlet.product;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;
import com.webappcafe.model.LoginItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "loginFunction", value = {"/loginFunction"})
public class LoginFunction extends HttpServlet 
{
    public static final String SELECT_CUSTOMERS_USERNAME_PASSWORD = String.format("SELECT username,password FROM customers");
    public static final String SELECT_CUSTOMER_INSTANCE = String.format("SELECT * FROM customers WHERE username = ? AND password = ?;");
    
    public LoginFunction() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            LoginItem loginBean = new LoginItem(); 
            loginBean.setUsername(username); 
            loginBean.setPassword(password);
            Customer loggedInCustomer;
            String userValidate = LoginFunction.authenticateUser(loginBean);

            if (username.equals("root") && password.equals("root")) {
                HttpSession session = request.getSession();
                session.setAttribute("username", "root");
                session.setAttribute("password", "root");
//                loggedInCustomer = new Customer();
//                loggedInCustomer.setUsername("root");
//                loggedInCustomer.setPassword("root");
//                session.setAttribute("admin", loggedInCustomer);
                response.getWriter().print("root");

            }else if(userValidate.equals("SUCCESS"))
            {
                //Create new session for currently logged in user
                HttpSession session=request.getSession();
                loggedInCustomer = LoginFunction.getCustomer(username, password);
                session.setAttribute("loggedInCustomer",loggedInCustomer);  
//                request.getRequestDispatcher("/successfullogin.jsp").forward(request, response);
                response.getWriter().print("customer");
            }
            else
            {
                response.getWriter().print("false");
            }   
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(LoginFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static String authenticateUser(LoginItem loginBean) throws SQLException
    {
        Database database = Database.getInstance();

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
            resultSet = statement.executeQuery(SELECT_CUSTOMERS_USERNAME_PASSWORD); 
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
    
    public static Customer getCustomer(String username, String password) throws SQLException
    {
        Database database = Database.getInstance();
        Connection con = database.getConnection();
        Customer customer = null;
        try
        {
            PreparedStatement st = con.prepareStatement(SELECT_CUSTOMER_INSTANCE);
            try
            {
                st.setString(1, username);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                try
                {

                    while (rs.next()) 
                    {
                        customer = Customer.createCustomer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                    }
                }
                finally
                {
                    rs.close();
                }
            }
            finally
            {
                st.close();
            }
        }
        finally
        {
            con.close();
        }
        return customer;
    }
}
