package com.webappcafe.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webappcafe.model.LoginItem;
import com.webappcafe.dao.LoginDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginFunction extends HttpServlet 
{
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
            LoginDao loginDao = new LoginDao(); 
            String userValidate = loginDao.authenticateUser(loginBean); 
            if(userValidate.equals("SUCCESS")) 
            {
                request.setAttribute("userName", username); 
                request.getRequestDispatcher("/successfullogin.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("errMessage", userValidate); 
                request.getRequestDispatcher("/loginfailure.jsp").forward(request, response);
            }   
            } catch (SQLException ex)
            {
                Logger.getLogger(LoginFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
