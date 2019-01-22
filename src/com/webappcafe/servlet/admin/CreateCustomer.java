package com.webappcafe.servlet.admin;

import com.webappcafe.dao.CustomerDAOImpl;
import com.webappcafe.model.Customer;
import com.webappcafe.servlet.security.RegistrationFunction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.webappcafe.servlet.security.RegistrationFunction.preRegistrationCheck;

@WebServlet(name = "createCustomer", value = {"/admin/createCustomer"})
public class CreateCustomer extends HttpServlet {

    public static final String SELECT_CUSTOMERS_USERNAME = String.format("SELECT username FROM customers");

    public CreateCustomer() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String userRegistered = null;
        try {
            if (!preRegistrationCheck(userName)) {
                response.getWriter().print("false");
            } else {
                Customer registerBean = new Customer();
                registerBean.setFname(fname);
                registerBean.setLname(lname);
                registerBean.setUsername(userName);
                registerBean.setPassword(password);
                CustomerDAOImpl customerDao = new CustomerDAOImpl();
                userRegistered = customerDao.registerUser(registerBean);
                response.getWriter().print("true");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
