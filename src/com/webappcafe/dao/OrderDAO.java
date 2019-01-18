package com.webappcafe.dao;

import com.webappcafe.model.Customer;
import com.webappcafe.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderDAO {

    List<Order> getAllOrders();
    long saveOrder(Order order);

    Map<Order, Customer> getCompletedOrders(String status);
}
