package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Customer;
import com.webappcafe.model.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {

    private static final String INSERT_ORDER_STATEMENT = String.format("INSERT INTO %s (%s, %s) VALUES(?, ?);",
            "`orders`", "`customer_id`", "`status`");

    public static final String SELECT_ORDERS_STATEMENT = String.format("SELECT * FROM %s;", "`orders`");

    public static final String SELECT_COMPLETED_ORDERS_STATEMENT = "select o.*, c.id, c.fname, c.lname, c.username\n" +
            "from orders o\n" +
            "inner join customers c on o.customer_id = c.id\n" +
            "where o.status = ?;";

    public static final String SELECT_ORDERS_BY_CUSTOMER_ID = "SELECT * FROM `orders` WHERE customer_id = ?;";


    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Database database = Database.getInstance();

    @Override
    public long saveOrder(Order order) {

        long id = 0;

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_ORDER_STATEMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,  order.getCustomerId());
            preparedStatement.setString(2, order.getStatus());

            if (preparedStatement.executeUpdate() > 0) {
                resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return id;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_STATEMENT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.beforeFirst();
            while (resultSet.next()) {

//                Order order = new Order();
//                order.setId(resultSet.getLong(1));
//                order.setDate(LocalDateTime.parse(resultSet.getString(2), DATE_TIME_FORMATTER));
//                order.setCustomerId(resultSet.getLong(3));
//                order.setStatus(resultSet.getString(4));

                Order order = fetchOrderByResultSet(resultSet);
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Map<Order, Customer> getCompletedOrders(String status) {
        Map<Order, Customer> completedOrders = new LinkedHashMap<>();

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(SELECT_COMPLETED_ORDERS_STATEMENT);
            preparedStatement.setString(1, status);

            resultSet = preparedStatement.executeQuery();

            resultSet.beforeFirst();
            while (resultSet.next()) {

//                Order order = new Order();
//                order.setId(resultSet.getLong(1));
//                order.setDate(LocalDateTime.parse(resultSet.getString(2), DATE_TIME_FORMATTER));
//                order.setCustomerId(resultSet.getLong(3));
//                order.setStatus(resultSet.getString(4));

                Order order = fetchOrderByResultSet(resultSet);

                Customer customer = new Customer();
                customer.setId(resultSet.getLong(5));
                customer.setFname(resultSet.getString(6));
                customer.setLname(resultSet.getString(7));
                customer.setUsername(resultSet.getString(8));

                completedOrders.put(order, customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        return completedOrders;
    }

    @Override
    public Order fetchOrderByResultSet(ResultSet resultSet) {
        Order order = null;

        try {
            order = new Order();
            order.setId(resultSet.getLong(1));
            order.setDate(LocalDateTime.parse(resultSet.getString(2), DATE_TIME_FORMATTER));
            order.setCustomerId(resultSet.getLong(3));
            order.setStatus(resultSet.getString(4));

            return order;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        return order;
    }

    @Override
    public List<Order> getOrdersByCustomerId(long customerId) {
        List<Order> customerOrders = new ArrayList<>();

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_CUSTOMER_ID);
            preparedStatement.setLong(1, customerId);

            resultSet = preparedStatement.executeQuery();

            resultSet.beforeFirst();
            while (resultSet.next()) {

                Order order = fetchOrderByResultSet(resultSet);
                customerOrders.add(order);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
        return customerOrders;
    }
}
