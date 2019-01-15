package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final String INSERT_PRODUCT_STATEMENT = String.format("INSERT INTO %s (%s, %s, %s) VALUES(?, ?, ?);",
            "`products`", "`name`", "`description`", "`price`");

    //TODO final String UPDATE_STATEMENT

//    public static final String UPDATE_STATEMENT = String.format("UPDATE %s SET ");

    public static final String SELECT_PRODUCT_STATEMENT = String.format("SELECT * FROM %s;", "`products`");

    private Database database = Database.getInstance();

    public long saveProduct(Product product) {

        long id = 0;

        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_PRODUCT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());

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

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_STATEMENT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setPrice(resultSet.getDouble(4));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
