package com.webappcafe.servlet.product;

import com.webappcafe.service.ProductService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "editProduct", urlPatterns = {"/admin/editProduct"})
public class EditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductService service = new ProductService();
        
        service.editProduct(Long.parseLong(request.getParameter("id")), 
                request.getParameter("name"), 
                Double.parseDouble(request.getParameter("price")), 
                request.getParameter("description"));
        
    }
    
}
