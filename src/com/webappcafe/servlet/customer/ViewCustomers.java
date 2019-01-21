package com.webappcafe.servlet.customer;

import com.webappcafe.dao.CustomerDAOImpl;
import com.webappcafe.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewCustomers", value = {"/viewCustomers"})
public class ViewCustomers extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("username"));
        String password = String.valueOf(session.getAttribute("password"));

//        Customer customer = (Customer) session.getAttribute("admin");

        if (!username.equals("root") && !password.equals("root")) {
            response.sendRedirect("landingPage.html");
        } else {
            CustomerDAOImpl customerDAO = new CustomerDAOImpl();

            List<Customer> customers = null;
            customers = customerDAO.getAllCustomers();

            request.setAttribute("customers", customers);
            request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);
        }



    }
}

