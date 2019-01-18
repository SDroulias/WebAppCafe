package com.webappcafe.servlet.product;

import com.webappcafe.dao.CustomerDAO;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "viewCustomers", value = {"/viewCustomers"})
public class ViewCustomers extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDAO customerDAO = new CustomerDAO();

        List<Customer> customers = null;
        customers = customerDAO.getAllCustomers();

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);

    }
}

