package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.ProductOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderDAOImpl implements ProductOrderDAO {

    public static final String GET_PRODUCTS_ORDERS_BY_ORDER_ID_STATEMENT = "SELECT `po`.*\n" +
            "FROM `products_orders` `po`\n" +
            "INNER JOIN `orders` `o` ON `po`.`orders_id` = `o`.`id`\n" +
            "WHERE `po`.`orders_id` = ?\n" +
            "ORDER BY `po`.`products_id`;";

    private Database database = Database.getInstance();

    @Override
    public List<ProductOrder> getProductsOrdersByOrderId(long orderId) {
        List<ProductOrder> productsOrderList = new ArrayList<>();

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(GET_PRODUCTS_ORDERS_BY_ORDER_ID_STATEMENT);
            preparedStatement.setLong(1, orderId);

            resultSet = preparedStatement.executeQuery();

            resultSet.beforeFirst();
            while (resultSet.next()) {
//                Product product = new Product();
//                product.setId(resultSet.getLong(1));
//                product.setName(resultSet.getString(2));
//                product.setDescription(resultSet.getString(3));
//                product.setPrice(resultSet.getDouble(4));
//                productsOfOrderList.add(product);
                ProductOrder productOrder = new ProductOrder();
                productOrder.setId(resultSet.getLong(1));
                productOrder.setOrdersId(resultSet.getLong(2));
                productOrder.setProductsId(resultSet.getLong(3));
                productOrder.setProductsQuantity(resultSet.getInt(4));
                productsOrderList.add(productOrder);
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

        return productsOrderList;
    }
}
