package com.webappcafe.servlet.customer;

import com.webappcafe.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCustomerOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderDAO orderDAO = new OrderDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        ProductOrderDAO productOrderDAO = new ProductOrderDAOImpl();

//        List<Order> customerOrders = orderDAO

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }
}
