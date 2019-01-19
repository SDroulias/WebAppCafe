package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private static final String INSERT_PRODUCT_STATEMENT = String.format("INSERT INTO %s (%s, %s, %s) VALUES(?, ?, ?);",
            "`products`", "`name`", "`description`", "`price`");
    
    private static final String DELETE_PRODUCT_STATEMENT = "DELETE FROM `products` WHERE `id`=?";

    public static final String UPDATE_PRODUCT_STATEMENT = "UPDATE `products` SET `name` = ?, `description` = ?, `price` = ?, `is_available` = ? "
            + "WHERE `id` = ?";    

    public static final String SELECT_PRODUCT_STATEMENT = String.format("SELECT * FROM %s;", "`products`");
    
    public static final String SELECT_PRODUCT_WHERE_ID_STATEMENT = "SELECT * FROM `products` WHERE `id` = ?";

    private Database database = Database.getInstance();

    @Override
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

    @Override
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

    @Override
    public int deleteProduct(int id) {
        int affectedRows = 0;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(DELETE_PRODUCT_STATEMENT);
        try {
            preparedStmt.setLong(1, id);
            
            ResultSet results = preparedStmt.getGeneratedKeys();
            
            affectedRows = preparedStmt.executeUpdate();
            
            return affectedRows;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return affectedRows;
    }

    @Override
    public int updateProduct(Product product) {
        int affectedRows = 0;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(UPDATE_PRODUCT_STATEMENT);
        try {
            preparedStmt.setString(1, product.getName());
            preparedStmt.setString(2, product.getDescription());
            preparedStmt.setDouble(3, product.getPrice());
            preparedStmt.setBoolean(4, product.getIsAvailable());
            preparedStmt.setLong(5, product.getId());

            ResultSet results = preparedStmt.getGeneratedKeys();
            
            affectedRows = preparedStmt.executeUpdate();
            
            return affectedRows;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        
        return affectedRows;
    }
    
    @Override
    public Product getProductById(long id) {
        Product p = null;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(SELECT_PRODUCT_WHERE_ID_STATEMENT);
        try {
            preparedStmt.setLong(1, id);
            
            ResultSet results = preparedStmt.executeQuery();
            
            p = fetchProductByResultSet(results);
                
            return p;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //if p = null
        return p;
    }
    
    @Override
    public Product fetchProductByResultSet(ResultSet results) {
        Product p = null;
        
            try {
                while(results.next()) {
                p = Product.createProduct(
                        results.getLong("id"), 
                        results.getString("name"), 
                        results.getString("description"), 
                        results.getDouble("price"),
                        results.getBoolean("is_available"));
                
                return p;
                }
                
            } catch(SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
        //if p = null
        return p;
    }
}
