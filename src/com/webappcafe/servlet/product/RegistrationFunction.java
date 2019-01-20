package com.webappcafe.servlet.product;
import com.webappcafe.dao.CustomerDAO;
import com.webappcafe.dao.CustomerDAOImpl;
import com.webappcafe.model.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "registrationFunction", value = {"/registrationFunction"})
public class RegistrationFunction extends HttpServlet {
 
 public RegistrationFunction() {}
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 {
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String userName = request.getParameter("username");
    String password = request.getParameter("pswd");

    Customer registerBean = new Customer();
    registerBean.setFname(fname);
    registerBean.setLname(lname);
    registerBean.setUsername(userName);
    registerBean.setPassword(password); 

    CustomerDAOImpl customerDao = new CustomerDAOImpl();

    String userRegistered = customerDao.registerUser(registerBean);

    if(userRegistered.equals("SUCCESS"))   
    {
        LoginFunction logUserIn = new LoginFunction();
        logUserIn.doPost(request, response);
    }
    else   
    {
        request.setAttribute("errMessage", userRegistered);
        request.getRequestDispatcher("/landingPage.html").forward(request, response);
    }
 }
}


