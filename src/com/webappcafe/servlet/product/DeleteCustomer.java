package com.webappcafe.servlet.product;

	
import com.webappcafe.dao.CustomerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteCustomer", value = {"/DeleteCustomer"})
public class DeleteCustomer extends HttpServlet 
{

//@WebServlet(name = "setProductUnavailable", urlPatterns = {"/setProductUnavailable"})



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        CustomerDAO customerDAO;

        if(request.getParameter("id") != null) {
	
	            customerDAO = new CustomerDAO();
	
	            customerDAO.deleteCustomerByID(Integer.parseInt(request.getParameter("id")));
	
	
	        }

        response.sendRedirect("createProductSuccess.jsp");
    }

}
