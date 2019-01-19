package com.webappcafe.dao;

import com.webappcafe.datasource.Database;
import com.webappcafe.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        long affectedRows = 0;
        
        PreparedStatement preparedStmt = Database.getInstance().getPreparedStatement(INSERT_PRODUCT_STATEMENT);
        try {
            preparedStmt.setString(1, product.getName());
            preparedStmt.setString(2, product.getDescription());
            preparedStmt.setDouble(3, product.getPrice());
            
            affectedRows = preparedStmt.executeUpdate();
            
            return affectedRows;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        
        return affectedRows;
    }

    @Override
    public List<Product> getAllProducts() {
        
        List<Product> productList = new ArrayList<>();
        
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_STATEMENT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.beforeFirst();
            
            while (resultSet.next()) {
                productList.add(fetchProductByResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            
            while(results.next()) {
                p = fetchProductByResultSet(results);
            }
                
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
            p = Product.createProduct(
                results.getLong("id"),
                results.getString("name"),
                results.getString("description"),
                results.getDouble("price"),
                results.getBoolean("is_available"));
            
            return p;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
                
        //if p = null
        return p;
    }
}
