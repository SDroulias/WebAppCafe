package com.webappcafe.servlet.customer;

import com.webappcafe.service.CustomerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "editCustomerFnameLname", urlPatterns = {"/editCustomerFnameLname"})
public class EditCustomerFnameLname extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService service = new CustomerService();
        
        service.editCustomerFnameLname(Long.parseLong(request.getParameter("id")), 
                request.getParameter("fname"), 
                request.getParameter("lname"));
        
    }
    
}
