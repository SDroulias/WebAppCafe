package com.webappcafe;

import com.webappcafe.dao.OrderDAO;
import com.webappcafe.dao.OrderDAOImpl;
import com.webappcafe.model.Order;

public class Test {

    public static void main(String[] args) {

        OrderDAO orderDAO = new OrderDAOImpl();
//
//        List<Order> orderList = orderDAO.getAllOrders();
//
//        for (Order order : orderList) {
//            System.out.println(order);
//        }

        Order order = Order.createOrder(4, "in_progress");

        long id = orderDAO.saveOrder(order);

        System.out.println("Order id = " + id);

    }
}
