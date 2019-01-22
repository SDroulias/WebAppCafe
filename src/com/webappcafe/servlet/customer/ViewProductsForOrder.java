package com.webappcafe.servlet.customer;

import com.webappcafe.model.Customer;
import com.webappcafe.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "viewProductsForOrder", value = {"/products"})
public class ViewProductsForOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("loggedInCustomer");

        if (customer == null) {
            response.sendRedirect("./");

        } else {

            ProductService service = new ProductService();

            request.setAttribute("products", service.getAvailableProducts());
            request.getRequestDispatcher("placeOrder.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
