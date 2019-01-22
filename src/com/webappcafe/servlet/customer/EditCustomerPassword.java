package com.webappcafe.servlet.customer;

import com.webappcafe.model.Customer;
import com.webappcafe.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "editCustomerPassword", urlPatterns = {"/editCustomerPassword"})
public class EditCustomerPassword extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            response.sendRedirect("/");
        } else {
            CustomerService service = new CustomerService();
            String password = request.getParameter("password");

            service.editCustomerPassword(customer.getId(), password);

            customer.setPassword(password);
            session.setAttribute("loggedInCustomer", customer);
        }
    }
}
