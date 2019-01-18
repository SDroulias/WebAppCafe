package com.webappcafe.servlet.product;

import com.webappcafe.dao.ProductDAO;
import com.webappcafe.dao.ProductDAOImpl;
import com.webappcafe.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductDAO productDAO = new ProductDAOImpl();
        
        Product p = Product.createProduct(
                request.getParameter("productName"), 
                request.getParameter("description"), 
                Double.parseDouble(request.getParameter("price"))
        );
        
        productDAO.deleteProduct((int)p.getId());
        
    }
    
}
