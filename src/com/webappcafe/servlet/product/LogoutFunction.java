package com.webappcafe.servlet.product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logoutFunction", value = {"/logoutFunction"})
public class LogoutFunction extends HttpServlet
{
//    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        HttpSession session = request.getSession(false); 
        if(session!=null) 
        {
            session.invalidate(); 
            request.setAttribute("errMessage", "You have logged out successfully");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/landingPage.html");
            requestDispatcher.forward(request, response);
            System.out.println("Logged out");
        }
    }
}
