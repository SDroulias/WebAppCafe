package com.webappcafe.servlet.customer;


import com.webappcafe.dao.CustomerDAO;
import com.webappcafe.dao.CustomerDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "deleteCustomer", value = {"/deleteCustomer"})
public class DeleteCustomer extends HttpServlet 
{

//@WebServlet(name = "setProductUnavailable", urlPatterns = {"/setProductUnavailable"})



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));
//        Customer customer = (Customer) session.getAttribute("admin");

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("./");
        } else {
            String id = request.getParameter("id");
            CustomerDAO customerDAO;

            if(id != null)
            {
                customerDAO = new CustomerDAOImpl();
                customerDAO.deleteCustomerByID(Long.parseLong(id));
            }
        }
    }

}
