package com.webappcafe.servlet.customer;

	
import com.webappcafe.dao.CustomerDAO;
import com.webappcafe.dao.CustomerDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        String id = request.getParameter("id");
        CustomerDAO customerDAO;

        if(id != null) 
        {
            customerDAO = new CustomerDAOImpl();
            customerDAO.deleteCustomerByID(Long.parseLong(id));
        }

    }

}
