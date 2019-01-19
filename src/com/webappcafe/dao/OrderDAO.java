package com.webappcafe.dao;

import com.webappcafe.model.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> getAllOrders();
    long saveOrder(Order order);
}
