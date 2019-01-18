package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderDAOImpl implements ProductOrderDAO {

    public static final String GET_PRODUCTS_OF_ORDER_STATEMENT = "SELECT `p`.*\n" +
            " FROM `products` `p`\n" +
            " INNER JOIN `products_orders` `po` ON `p`.`id` = `po`.`products_id`\n" +
            " WHERE `po`.`orders_id` = ?;";


    private Database database = Database.getInstance();

    @Override
    public List<Product> getProductsOfOrder(long product_id) {
        List<Product> productsOfOrederList = new ArrayList<>();

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            preparedStatement = connection.prepareStatement(GET_PRODUCTS_OF_ORDER_STATEMENT);
            preparedStatement.setLong(1, product_id);

            resultSet = preparedStatement.executeQuery();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getDouble(4));
                productsOfOrederList.add(product);
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

        return productsOfOrederList;
    }
}
